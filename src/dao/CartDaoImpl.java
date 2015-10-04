package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Cart;
import dto.Item;
import dto.User;

public class CartDaoImpl extends BaseDao implements CartDao {

	ItemDaoImpl itemDao = ItemDaoImpl.getInstance();

	// singleton
	public static CartDaoImpl instance;

	public static CartDaoImpl getInstance() {
		if (instance == null) {
			instance = new CartDaoImpl();
		}
		return instance;
	}

	public List<Cart> getCart(int user_id) {
		List<Cart> cartItems = new ArrayList<Cart>();

		Connection connection = getConnection();
		String sql = "SELECT i.*, c.* FROM " + "item i, user u, cart c WHERE "
		        + "c.user_id = u.id and c.item_id = i.id and u.id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Cart c = new Cart();
				Item item = itemDao.convertItem(rs);
				c.setItem(item);
				c.setItem_id(item.getId());
				c.setCount(rs.getInt("count"));
				c.setUser_id(user_id);
				c.setAdded(rs.getTimestamp("added"));
				c.setRemoved(rs.getTimestamp("removed"));
				cartItems.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cartItems;
	}

	public void saveOrUpdate(Cart cart) {
		Connection connection = getConnection();
		Cart exist_cart = getCartByUserIdAndItemId(cart.getUser_id(),
		        cart.getItem_id());
		if (exist_cart == null) {
			// save
			String sql = "INSERT INTO `cart` (`user_id`, `item_id`, `count`, `added`, `removed`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cart.getUser_id());
				preparedStatement.setInt(2, cart.getItem_id());
				preparedStatement.setInt(3, cart.getCount());
				preparedStatement.setTimestamp(4, cart.getAdded());
				preparedStatement.setTimestamp(5, cart.getRemoved());

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			// update

			String sql = "UPDATE `cart` SET `count`=?, `added`=?, `removed`=? WHERE `id`=?";

			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cart.getCount());
				preparedStatement.setTimestamp(2, cart.getAdded());
				preparedStatement.setTimestamp(3, cart.getRemoved());
				preparedStatement.setInt(4, cart.getId());
				

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void clearCartByUserId(int user_id) {
		Connection connection = getConnection();
		String sql = "DELETE from `cart` where user_id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Cart getCartById(int cart_id){
		Connection connection = getConnection();
		String sql = "SELECT * FROM cart WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, cart_id);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return convertCart(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Cart getCartByUserIdAndItemId(int user_id, int item_id) {

		Connection connection = getConnection();
		String sql = "SELECT i.*, c.* FROM "
		        + "item i, user u, cart c where "
		        + "c.user_id = u.id and c.item_id = i.id and u.id = ? and i.id = ? and c.removed = NULL ";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, item_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Cart c = new Cart();
				Item item = itemDao.convertItem(rs);
				c.setItem(item);
				c.setItem_id(item.getId());
				c.setCount(rs.getInt("count"));
				c.setUser_id(user_id);
				c.setAdded(rs.getTimestamp("added"));
				c.setRemoved(rs.getTimestamp("removed"));
				return c;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	private Cart convertCart(ResultSet rs) throws SQLException{
		Cart cart = new Cart();
		cart.setId(rs.getInt("id"));
		cart.setUser_id(rs.getInt("user_id"));
		cart.setItem_id(rs.getInt("item_id"));
		cart.setCount(rs.getInt("count"));
		cart.setAdded(rs.getTimestamp("added"));
		cart.setRemoved(rs.getTimestamp("removed"));
	    return cart;
    }

}
