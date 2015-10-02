package service;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Item;
import dto.User;

public class ItemService {

	private ItemDao itemDao = ItemDaoImpl.getInstance();
	private UserDao userDao = UserDaoImpl.getInstance();

	/**
	 * helper function, load seller object for item, by default, item object
	 * only contians seller_id
	 * 
	 * @param item
	 */
	public void loadItemSeller(Item item) {
		User seller = userDao.getUserById(item.getSeller_id());
		item.setSeller(seller);
	}

	// list all avaiable items
	private List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	/**
	 * For home page
	 */
	public List<Item> getAllAvailibleItems() {
		List<Item> resultList = new ArrayList<Item>();
		for (Item i : getAllItems()) {
			if (!i.isPaused() && i.isPaused()) {
				resultList.add(i);
			}
		}
		return resultList;
	}

	/**
	 * for advance search
	 */
	public List<Item> searchItemsByParam(Item example) {
		List<Item> resultList = new ArrayList<Item>();

		for (Item i : getAllAvailibleItems()) {
			// compare title
			if (example.getTitle() != null && i.getTitle() != null) {
				if (!i.getTitle().equalsIgnoreCase(example.getTitle())) {
					continue;
				}
			}
			// compare type
			if (example.getType() != null && i.getType() != null) {
				if (!i.getType().equalsIgnoreCase(example.getType())) {
					continue;
				}
			}

			// compare authors
			if (example.getAuthors() != null && i.getAuthors() != null) {
				if (!i.getAuthors().toLowerCase()
				        .contains(example.getAuthors().toLowerCase())) {
					continue;
				}
			}

			// compare Venue
			if (example.getVenue() != null && i.getVenue() != null) {
				if (!i.getVenue().toLowerCase()
				        .contains(example.getVenue().toLowerCase())) {
					continue;
				}
			}

			resultList.add(i);
		}

		return resultList;
	}

	/**
	 * For item detail page
	 * 
	 * @param id
	 */
	public void pauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPaused(true);
		itemDao.saveOrUpdate(item);
	}

	/**
	 * For item detail page
	 * 
	 * @param id
	 */
	public void unPauseItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setPaused(false);
		itemDao.saveOrUpdate(item);
	}

	/**
	 * for user uploaded items pages
	 * 
	 * @param seller_id
	 * @return
	 */
	public List<Item> getAllOwnedItems(int seller_id) {
		return itemDao.getAllItemsBySellerId(seller_id);
	}

	/**
	 * for add/edit item pages
	 * 
	 * @param item
	 */
	public void saveOrUpdate(Item item) {
		itemDao.saveOrUpdate(item);
	}

	/**
	 * For admin ban page
	 * 
	 * @param id
	 */
	public void banItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setBan(true);
		itemDao.saveOrUpdate(item);
	}

	/**
	 * For admin page
	 * 
	 * @param id
	 */
	public void unBanItem(String id) {
		Item item = itemDao.getItemById(Integer.parseInt(id));
		item.setBan(false);
		itemDao.saveOrUpdate(item);
	}

	/**
	 * For home page
	 *
	 * @param
	 */
	public List<Item> getRandom10(){
		return itemDao.getRandomten();
	}
}
