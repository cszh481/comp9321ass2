package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Item;

public class ItemDaoImpl extends BaseDao implements ItemDao {

	// singleton
	public static ItemDaoImpl instance;

	public static ItemDaoImpl getInstance() {
		if (instance == null) {
			instance = new ItemDaoImpl();
		}
		return instance;
	}

	@Override
	public void saveOrUpdate(Item item) {
		Connection connection = getConnection();

		// if it's new user, the do insert
		if (item.getId() == 0) {
			try {

				String sql = "INSERT INTO item (title, authors, type, publication_date, venue, price, paused, ban, quantity, imageURL, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection
				        .prepareStatement(sql);

				preparedStatement.setString(1, item.getTitle());
				preparedStatement.setString(2, item.getAuthors());
				preparedStatement.setString(3, item.getType());
				preparedStatement.setDate(4,
				        item.getPublication_date() != null ? new java.sql.Date(
				                item.getPublication_date().getTime()) : null);
				preparedStatement.setString(5, item.getVenue());
				preparedStatement.setDouble(6, item.getPrice());
				preparedStatement.setBoolean(7, item.isPaused());
				preparedStatement.setBoolean(8, item.isBan());
				preparedStatement.setInt(9, item.getQuantity());
				preparedStatement.setString(10, item.getImageURL());
				preparedStatement.setInt(11, item.getSeller_id());

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {

				String sql = "UPDATE item SET title=?, authors=?, type=?, publication_date=?, venue=?, price=?, paused=?, ban=?, quantity=?, imageURL=?, seller_id=? WHERE id=?";

				PreparedStatement preparedStatement = connection
				        .prepareStatement(sql);
				preparedStatement.setString(1, item.getTitle());
				preparedStatement.setString(2, item.getAuthors());
				preparedStatement.setString(3, item.getType());
				preparedStatement.setDate(4,
				        item.getPublication_date() != null ? new java.sql.Date(
				                item.getPublication_date().getTime()) : null);
				preparedStatement.setString(5, item.getVenue());
				preparedStatement.setDouble(6, item.getPrice());
				preparedStatement.setBoolean(7, item.isPaused());
				preparedStatement.setBoolean(8, item.isBan());
				preparedStatement.setInt(9, item.getQuantity());
				preparedStatement.setString(10, item.getImageURL());
				preparedStatement.setInt(11, item.getSeller_id());
				preparedStatement.setInt(12, item.getId());

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Item getItemById(int id) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM item WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return convertItem(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM item";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item item = convertItem(rs);
				items.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

	@Override
	public List<Item> getRandomten() {
		List<Item> items = new ArrayList<Item>();

		Connection connection = getConnection();
		String sql = "select * from item WHERE paused = 0 and ban = 0 order by rand() limit 10";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item item = convertItem(rs);
				items.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

	public List<Item> getAllItemsBySellerId(int seller_id) {
		List<Item> items = new ArrayList<Item>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM item where seller_id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, seller_id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item item = convertItem(rs);
				items.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}




	protected Item convertItem(ResultSet rs) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setTitle(rs.getString("title"));
		item.setAuthors(rs.getString("authors"));
		item.setType(rs.getString("type"));
		item.setPublication_date(rs.getDate("publication_date"));
		item.setVenue(rs.getString("venue"));
		item.setPrice(rs.getDouble("price"));
		item.setBan(rs.getBoolean("ban"));
		item.setPaused(rs.getBoolean("paused"));
		item.setQuantity(rs.getInt("quantity"));
		item.setSeller_id(rs.getInt("seller_id"));
		item.setImageURL(rs.getString("imageURL"));
		UserDao userDao = new UserDaoImpl();
		item.setSeller(userDao.getUserById(rs.getInt("seller_id")));
		return item;
	}

}
