package dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

public class UserDaoTest extends BaseTest {

	UserDao userDao;

	@Before
	public void setup() {
		userDao = UserDaoImpl.getInstance();
		getTestUser();
	}

	@Test
	public void testUpdateUser() {
		User user = getTestUser();
		user.setPassword("xxx");
		userDao.saveOrUpdate(user);
		user = getTestUser();
		assertEquals("xxx", user.getPassword());
	}

	@Test
	public void testGetUserByUUID() {
		User user = getTestUser();
		User user2 = userDao.getUserByUuid(user.getUuid());
		assertEquals(user.getUsername(), user2.getUsername());
	}

	@Test
	public void testGetUsers() {
		List<User> list = userDao.getAllUsers();
		assertTrue(list.size() > 0);
	}

}
