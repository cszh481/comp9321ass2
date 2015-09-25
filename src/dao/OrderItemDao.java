package dao;

import java.util.List;

import dto.Order;
import dto.OrderItem;

public interface OrderItemDao {

	public void save(OrderItem orderItem);

	public List<OrderItem> getAllOrderItemByOrderId(int order_id);

	public OrderItem getOrderItemById(int id);
}
