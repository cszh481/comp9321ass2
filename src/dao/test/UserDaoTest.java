package dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

public class UserDaoTest {

	UserDao userDao;

	@Before
	public void setup() {
		userDao = UserDaoImpl.getInstance();
	}

	@Test
	public void testSaveUser() {
		// User user = new User();
		// user.setUsername("lee");
		// user.setPassword("lee");
		// userDao.saveOrUpdate(user);

		// User user2 = userDao.getUserByUsername("lee");
		// assertEquals("lee", user2.getUsername());

		// testing git commit

	}

	@Test
	public void testUpdateUser() {
		// User user = new User();
		// user.setId(1);
		// user.setUsername("xxx");
		//
		// userDao.saveOrUpdate(user);
	}

	@Test
	public void testGetUser() {
		User user;

		user = userDao.getUserByUsername("xxx");
		assertEquals(1, user.getId());

		user = userDao.getLoginUser("xxx", "lee");
		assertEquals(1, user.getId());

		user = userDao.getLoginUser("xxx", "xx");
		assertEquals(null, user);

		user = userDao.getUserByUuid("dddddd");
		assertEquals(1, user.getId());

		user = userDao.getUserByUuid("fff");
		assertEquals(null, user);

	}
	
	@Test
	public void testGetUsers() {
		List<User> list = userDao.getAllUsers();
		assertEquals(2, list.size());

	}

}
