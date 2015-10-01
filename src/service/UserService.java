package service;

import java.util.List;
import java.util.UUID;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;
import exception.UserBannedException;
import exception.UserUnVerifiedException;
import javax.servlet.http.HttpServletRequest;
import javax.mail.MessagingException;

public class UserService {

	private UserDao userDao = UserDaoImpl.getInstance();

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws UserBannedException
	 * @throws UserUnVerifiedException
	 */
	public User login(String username, String password)
	        throws UserBannedException, UserUnVerifiedException {

		User user = userDao.getLoginUser(username, password);

		if (user == null) {
			return null;
		} else if (user.isBan()) {
			throw new UserBannedException();
		} else if (!user.isVerified()) {
			throw new UserUnVerifiedException();
		}

		return user;
	}

	/**
	 * helper
	 * @param id
	 * @return
	 */
	public User getUserById(String id) {
		return this.userDao.getUserById(Integer.parseInt(id));
	}

	/**
	 * helper
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		return this.userDao.getUserByUsername(username);
	}

	/**
	 * for admin page
	 * @return
	 */
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}

	/**
	 * for user register page
	 * 
	 * currently if and only if username is taken, this will return false
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(User user) throws MessagingException {

		// verify username unique
		User exist_user = userDao.getUserByUsername(user.getUsername());
		if (exist_user != null) {
			return false;
		}

		user.setUuid(UUID.randomUUID().toString());
		userDao.saveOrUpdate(user);

		// if success, then send email
        SendEmail.sendEmail();

		return true;
	}

	/**
	 * for verify user page
	 * @param uuid
	 * @return
	 */
	public User verifyUserEmail(String uuid) {
		User user = userDao.getUserByUuid(uuid);

		if (user == null) {
			return null;
		} else {
			user.setVerified(true);
			userDao.saveOrUpdate(user);
		}
		return user;
	}

    public User makeUserbyRequest (HttpServletRequest request){
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setBirthyear(Integer.parseInt(request.getParameter("birthyear")));
        user.setAddress(request.getParameter("address"));
        user.setCreditcard(request.getParameter("creditcard"));
        user.setBan(false);
        user.setVerified(false);
        return user;
    }

}
