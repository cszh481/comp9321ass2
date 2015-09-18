package service;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Item;
import dto.User;

public class ItemService {

	private ItemDao itemDao = ItemDaoImpl.getInstance();
	private UserDao userDao = UserDaoImpl.getInstance();

	public void loadItemSeller(Item item) {
		User seller = userDao.getUserById(item.getSeller_id());
		item.setSeller(seller);
	}

	public void pauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPaused(true);
		itemDao.saveOrUpdate(item);
	}

	public void unPauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPaused(false);
		itemDao.saveOrUpdate(item);
	}

}
