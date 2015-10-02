package dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dto.Item;

public class ItemDaoTest extends BaseTest {

	ItemDao itemDao;

	@Before
	public void setup() {
		itemDao = ItemDaoImpl.getInstance();
	}

	@Test
	public void testUpdate() {
		Item item = getTestItem1();
		item.setAuthors("fake authors");
		assertEquals("fake authors", item.getAuthors());
	}

	@Test
	public void testGetAll() {
		List<Item> list = itemDao.getAllItems();
		assertTrue(list.size() > 0);
	}

}
