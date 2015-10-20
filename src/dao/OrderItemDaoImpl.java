package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.OrderItem;
import service.ItemService;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	// singleton
	public static OrderItemDaoImpl instance;

	public static OrderItemDaoImpl getInstance() {
		if (instance == null) {
			instance = new OrderItemDaoImpl();
		}
		return instance;
	}

	@Override
	public void save(OrderItem orderItem) {
		Connection connection = getConnection();

		// save
		String sql = "INSERT INTO `orderItem` (`count`, `item_id`, `order_id`) VALUES (?, ?, ?);";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderItem.getCount());
			preparedStatement.setInt(2, orderItem.getItem_id());
			preparedStatement.setInt(3, orderItem.getOrder_id());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrderId(int order_id) {
		List<OrderItem> resultList = new ArrayList<OrderItem>();
		Connection connection = getConnection();
		String sql = "SELECT * from `orderItem` where order_id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, order_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrderItem o = new OrderItem();
				o.setId(rs.getInt("id"));
				o.setItem_id(rs.getInt("item_id"));
				o.setOrder_id(rs.getInt("order_id"));
				o.setCount(rs.getInt("count"));
				ItemDao itemDao = new ItemDaoImpl();
				OrderDao orderDao = new OrderDaoImpl();
				o.setItem(itemDao.getItemById(o.getItem_id()));
				o.setOrder(orderDao.getOrderByOrderId(o.getOrder_id()));
				resultList.add(o);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		Connection connection = getConnection();
		String sql = "SELECT * from `orderItem` where id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				OrderItem o = new OrderItem();
				o.setId(rs.getInt("id"));
				o.setItem_id(rs.getInt("item_id"));
				o.setOrder_id(rs.getInt("order_id"));
				o.setCount(rs.getInt("count"));
				connection.close();
				return o;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
