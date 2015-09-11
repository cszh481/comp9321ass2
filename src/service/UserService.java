package service;

import java.util.UUID;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;
import exception.UserBannedException;
import exception.UserUnVerifiedException;

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
	 * currently only username been taken will return false
	 * @param user
	 * @return
	 */
	public boolean register(User user) {

		// verify username unique
		User exist_user = userDao.getUserByUsername(user.getUsername());
		if (exist_user != null) {
			return false;
		}

		user.setUuid(UUID.randomUUID().toString());
		userDao.saveOrUpdate(user);

		// if success, then send email
		// TODO: SEND EMAIL

		return true;
	}

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

}
