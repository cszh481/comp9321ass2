package service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Cart;
import dto.Item;
import dto.User;
import exception.UserBannedException;
import exception.UserUnVerifiedException;

public class UserService {

	private UserDao userDao = UserDaoImpl.getInstance();
	private ItemDao itemDao = ItemDaoImpl.getInstance();

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

	public User getUserById(String id) {
		return this.userDao.getUserById(Integer.parseInt(id));
	}

	public User getUserByUsername(String username) {
		return this.userDao.getUserByUsername(username);
	}

	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}

	/**
	 * currently only username been taken will return false
	 * 
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

	public List<Cart> getShoppingCart(User user) {
		return itemDao.getShoppingCart(user.getId());
	}

	public void saveToShoppingCart(User user, String item_id, int count) {
		this.itemDao.updateShoppingCart(user.getId(),
		        Integer.parseInt(item_id), count);
	}

}
