package service;

import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.OrderItemDao;
import dao.OrderItemDaoImpl;
import dto.Cart;
import dto.Order;
import dto.OrderItem;

public class OrderService {

	private OrderDao orderDao = OrderDaoImpl.getInstance();
	private OrderItemDao orderItemDao = OrderItemDaoImpl.getInstance();
	private CartService cartService = new CartService();

	/**
	 * create order
	 * @param user_id
	 */
	public void createOrder(int user_id) {
		// step 1, insert into order table
		Order order = new Order();
		order.setUser_id(user_id);
		orderDao.saveOrUpdate(order);

		// step 2, move all shopping cart into orderItem
		for (Cart c : cartService.getExistedCart(user_id)) {
			OrderItem oi = new OrderItem();
			oi.setOrder_id(order.getId());
			oi.setItem_id(c.getItem_id());
			oi.setCount(c.getCount());
			orderItemDao.save(oi);
		}

		// step 3, clear cart
		cartService.clearCartByUserId(user_id);
		
		// step 4, send email
		// TODO: send email
	}
}
