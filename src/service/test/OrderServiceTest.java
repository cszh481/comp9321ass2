package service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import service.CartService;
import service.OrderService;
import service.UserService;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.test.BaseTest;
import dto.Cart;
import dto.Item;
import dto.Order;
import dto.User;

public class OrderServiceTest extends BaseTest {

	CartService cartService;
	OrderService orderService;
	Item item1;
	Item item2;
	User user;

	@Before
	public void setup() {
		cartService = new CartService();
		orderService = new OrderService();
		item1 = getTestItem1();
		item2 = getTestItem2();
		user = getTestUser();
	}

	@Test
	public void testCreateOrder() {
		cartService.clearCartByUserId(user.getId());
		cartService.saveToCart(user.getId(), item1.getId(), 2);
		cartService.saveToCart(user.getId(), item2.getId(), 3);

		Order order = orderService.createOrder(user.getId());
		assertTrue(orderService.getAllOrderByUserId(user.getId()).size() > 0);
		assertEquals(2, orderService.getAllOrderItemByOrderId(order.getId())
		        .size());
	}

}
