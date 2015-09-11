package dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

public class UserDaoTest {

	@Test
	public void testSaveUser() {
		UserDao userDao = UserDaoImpl.getInstance();
//		User user = new User();
//		user.setUsername("lee");
//		user.setPassword("lee");
//		userDao.saveOrUpdate(user);

		User user2 = userDao.getUserByUsername("lee");
		assertEquals("lee", user2.getUsername());
		
		
		//testing git commit

	}

}
