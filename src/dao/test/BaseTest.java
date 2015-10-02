package dao.test;

import java.util.UUID;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Item;
import dto.User;

public class BaseTest {

	public static User getTestUser() {
		UserDao userDao = UserDaoImpl.getInstance();
		User user = userDao.getUserByUsername("testuser");
		if (user == null) {
			user = new User();
			user.setUsername("testuser");
			user.setPassword("password");
			user.setUuid(UUID.randomUUID().toString());
			userDao.saveOrUpdate(user);
		}
		return user;
	}

	public static Item getTestItem1() {
		ItemDao itemDao = ItemDaoImpl.getInstance();
		Item item = itemDao.getItemById(1);

		if (item == null) {
			item = new Item();
			item.setTitle("test item");
			item.setAuthors("test authors");
			item.setSeller_id(getTestUser().getId());
			itemDao.saveOrUpdate(item);
		}

		return item;
	}

	public static Item getTestItem2() {
		ItemDao itemDao = ItemDaoImpl.getInstance();
		Item item = itemDao.getItemById(2);

		if (item == null) {
			item = new Item();
			item.setTitle("test item 2");
			item.setAuthors("test authors 2");
			item.setSeller_id(getTestUser().getId());
			itemDao.saveOrUpdate(item);
		}

		return item;
	}
}
