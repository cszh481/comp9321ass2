package service;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dto.Item;

public class ItemService {

	private ItemDao itemDao = ItemDaoImpl.getInstance();

	public void pauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPause(true);
		itemDao.saveOrUpdate(item);
	}

	public void unPauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPause(false);
		itemDao.saveOrUpdate(item);
	}

}
