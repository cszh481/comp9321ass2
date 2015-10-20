package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	// singleton
	public static UserDaoImpl instance;

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public void saveOrUpdate(User user) {
		Connection connection = getConnection();

		// if it's new user, the do insert
		if (user.getId() == 0) {
			try {

				String sql = "INSERT INTO user (username, password, nickname, firstname, lastname, email, birthyear, address, creditcard, ban, verified, uuid, salt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement preparedStatement = connection
				        .prepareStatement(sql);

				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getNickname());
				preparedStatement.setString(4, user.getFirstname());
				preparedStatement.setString(5, user.getLastname());
				preparedStatement.setString(6, user.getEmail());
				preparedStatement.setInt(7, user.getBirthyear());
				preparedStatement.setString(8, user.getAddress());
				preparedStatement.setString(9, user.getCreditcard());
				preparedStatement.setBoolean(10, user.isBan());
				preparedStatement.setBoolean(11, user.isVerified());
				preparedStatement.setString(12, user.getUuid());
				preparedStatement.setString(13, user.getSalt());

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				String sql = "UPDATE user SET username=?, password=?, nickname=?, firstname=?, lastname=?, email=?, birthyear=?, address=?, creditcard=?, ban=?, verified=?, uuid=?, salt=? WHERE id=?";

				PreparedStatement preparedStatement = connection
				        .prepareStatement(sql);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getNickname());
				preparedStatement.setString(4, user.getFirstname());
				preparedStatement.setString(5, user.getLastname());
				preparedStatement.setString(6, user.getEmail());
				preparedStatement.setInt(7, user.getBirthyear());
				preparedStatement.setString(8, user.getAddress());
				preparedStatement.setString(9, user.getCreditcard());
				preparedStatement.setBoolean(10, user.isBan());
				preparedStatement.setBoolean(11, user.isVerified());
				preparedStatement.setString(12, user.getUuid());
				preparedStatement.setString(13, user.getSalt());
				preparedStatement.setInt(14, user.getId());

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getLoginUser(String username, String password) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				connection.close();
				return convertUser(rs);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getUserByUuid(String uuid) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM user WHERE uuid = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setString(1, uuid);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				connection.close();
				return convertUser(rs);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM user WHERE username = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				connection.close();
				return convertUser(rs);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getUserById(int id) {
		Connection connection = getConnection();
		String sql = "SELECT * FROM user WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				connection.close();
				return convertUser(rs);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		Connection connection = getConnection();
		String sql = "SELECT * FROM user";

		try {
			PreparedStatement preparedStatement = connection
			        .prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User user = convertUser(rs);
				users.add(user);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	private User convertUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setBirthyear(rs.getInt("birthyear"));
		user.setAddress(rs.getString("address"));
		user.setCreditcard(rs.getString("creditcard"));
		user.setBan(rs.getBoolean("ban"));
		user.setVerified(rs.getBoolean("verified"));
		user.setUuid(rs.getString("uuid"));
		user.setNickname(rs.getString("nickname"));
		return user;
	}

}
