package service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import service.CartService;
import service.UserService;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.test.BaseTest;
import dto.Cart;
import dto.Item;
import dto.User;

public class CartServiceTest extends BaseTest {

	CartService cartService;
	Item item1;
	Item item2;
	User user;

	@Before
	public void setup() {
		cartService = new CartService();
		item1 = getTestItem1();
		item2 = getTestItem2();
		user = getTestUser();
	}

	@Test
	public void testClearCart() {
		cartService.clearCartByUserId(user.getId());
		assertEquals(0, cartService.getExistedCart(user.getId()).size());
		assertEquals(0, cartService.getRemovedCart(user.getId()).size());
		
	}

	@Test
	public void testSaveAndUpdate() {
		cartService.clearCartByUserId(user.getId());
		cartService.saveToCart(user.getId(), item1.getId(), 2);
		assertEquals(1, cartService.getExistedCart(user.getId()).size());

		cartService.saveToCart(user.getId(), item1.getId(), 5);
		assertEquals(1, cartService.getExistedCart(user.getId()).size());
		assertEquals(5, cartService.getCartByUserIdAndItemId(user.getId(), item1.getId()).getCount());

		cartService.saveToCart(user.getId(), item2.getId(), 3);
		assertEquals(2, cartService.getExistedCart(user.getId()).size());

	}

//	@Test
//	public void testRemoveCart() {
//		cartService.clearCartByUserId(user.getId());
//		cartService.saveToCart(user.getId(), item1.getId(), 2);
//		assertEquals(1, cartService.getExistedCart(user.getId()).size());
//
//		// remove the item
//		cartService.removeCart(user.getId(), item1.getId());
//		assertEquals(0, cartService.getExistedCart(user.getId()).size());
//		assertEquals(1, cartService.getRemovedCart(user.getId()).size());
//	
//	
//	}

}
