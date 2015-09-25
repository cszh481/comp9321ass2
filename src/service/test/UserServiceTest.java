package service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import service.UserService;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Cart;
import dto.Item;
import dto.User;

public class UserServiceTest {

	UserService userService;

	@Before
	public void setup() {
		userService = new UserService();
	}

	@Test
	public void testShoppingCart() {
		User user = userService.getUserById("1");

		
		
	}

}
