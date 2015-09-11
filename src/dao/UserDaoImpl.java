package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		// if it's new user, the do insert
		if (user.getId() == 0) {
			Connection connection = getConnection();
			try {

				String sql = "INSERT INTO user (username, password, firstname, lastname, email, birthyear, address, creditcard, ban, verified, uuid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement preparedStatement = connection
				        .prepareStatement(sql);

				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getFirstname());
				preparedStatement.setString(4, user.getLastname());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setInt(6, user.getBirthyear());
				preparedStatement.setString(7, user.getAddress());
				preparedStatement.setString(8, user.getCreditcard());
				preparedStatement.setBoolean(9, user.isBan());
				preparedStatement.setBoolean(10, user.isVerified());
				preparedStatement.setString(11, user.getUuid());

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getLoginUser(String username, String password) {
		return null;
	}

	@Override
	public User getUserByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public User getUserByUsername(String username) {
	    // TODO Auto-generated method stub
	    return null;
    }

}
