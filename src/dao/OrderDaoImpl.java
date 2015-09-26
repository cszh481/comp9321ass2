package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	// singleton
	public static OrderDaoImpl instance;

	public static OrderDaoImpl getInstance() {
		if (instance == null) {
			instance = new OrderDaoImpl();
		}
		return instance;
	}

	@Override
	public void saveOrUpdate(Order order) {

		Connection connection = getConnection();

		if (order.getId() > 0) {
			// update

			String sql = "UPDATE `order` SET `user_id` = ?, `created` = ? WHERE `id`=?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, order.getUser_id());
				preparedStatement.setDate(2,
				        order.getCreated() != null ? new java.sql.Date(order
				                .getCreated().getTime()) : null);
				preparedStatement.setInt(3, order.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			// save
			String sql = "INSERT INTO `order` (`user_id`, `created`) VALUES (?, ?)";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql,
				        PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, order.getUser_id());
				preparedStatement.setDate(2,
				        order.getCreated() != null ? new java.sql.Date(order
				                .getCreated().getTime()) : null);
				preparedStatement.executeUpdate();

				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					order.setId(id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public List<Order> getAllOrderByUserId(int user_id) {
		List<Order> resultList = new ArrayList<Order>();
		Connection connection = getConnection();
		String sql = "SELECT * from `order` where user_id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setUser_id(rs.getInt("user_id"));
				o.setCreated(rs.getDate("created"));
				resultList.add(o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Order getOrderByOrderId(int id) {

		Connection connection = getConnection();
		String sql = "SELECT * from `order` where id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setUser_id(rs.getInt("user_id"));
				o.setCreated(rs.getDate("created"));
				return o;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
