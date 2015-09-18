package dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDaoImpl;
import dto.Item;
import dto.User;

public class ItemDaoTest {

	ItemDao itemDao;

	@Before
	public void setup() {
		itemDao = ItemDaoImpl.getInstance();
	}

	@Test
	public void testSave() {
		// Item item = new Item();
		// item.setTitle("book1");
		// item.setSeller_id(1);
		// itemDao.saveOrUpdate(item);

		Item item2 = itemDao.getItemById(4);
		assertEquals("book1", item2.getTitle());

		// testing git commit

	}

	@Test
	public void testUpdate() {
		Item item = itemDao.getItemById(4);
		item.setTitle("video1");
		itemDao.saveOrUpdate(item);

		Item item2 = itemDao.getItemById(4);
		assertEquals("video1", item2.getTitle());

	}

	@Test
	public void testGetAll() {
		List<Item> list = itemDao.getAllItems();
		assertEquals(2, list.size());

	}

}
