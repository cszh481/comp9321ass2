package dao;

import dto.User;

public interface UserDao {

	/**
	 * 
	 * @param user
	 */
	public void saveOrUpdate(User user);

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User getLoginUser(String username, String password);


	public User getUserByUsername(String username);

	public User getUserByUuid(String uuid);

}
