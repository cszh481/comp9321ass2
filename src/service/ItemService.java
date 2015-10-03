package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;
import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.Item;
import dto.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	/**
	 * For store page
	 *
	 * @param userId
	 */
	public List<Item> getAllItemByseller(int userId){
		return itemDao.getAllItemsBySellerId(userId);
	}

	public Item getItemById(String id){
		return  itemDao.getItemById(Integer.parseInt(id));
	}

	public Item makeItemByRequest (HttpServletRequest request) throws ParseException {
		Item item = new Item();
		item.setId(0);
		if (request.getParameter("title") != null && !request.getParameter("title").equals("")) {
			item.setTitle(request.getParameter("title"));
		}
		if (request.getParameter("author") != null && !request.getParameter("author").equals("")) {
			item.setAuthors(request.getParameter("author"));
		}
		if (request.getParameter("publicationdate") != null && !request.getParameter("publicationdate").equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			item.setPublication_date(sdf.parse(request.getParameter("publicationdate")));
		}
		if (request.getParameter("venues") != null && !request.getParameter("venues").equals("")) {
			item.setVenue(request.getParameter("venues"));
		}
		if (request.getParameter("price") != null && !request.getParameter("price").equals("")) {
			item.setPrice(Double.parseDouble(request.getParameter("price")));
		}
		if (request.getParameter("quantity") != null && !request.getParameter("quantity").equals("")) {
			item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		}
		if (request.getParameter("image") != null && !request.getParameter("image").equals("")) {
			item.setImageURL(request.getParameter("image"));
		}
		if (request.getParameter("typesearch") != null && !request.getParameter("typesearch").equals("")) {
			item.setType(request.getParameter("typesearch"));
		}
		item.setPaused(false);
		item.setBan(false);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		item.setSeller_id(user.getId());
		return item;
	}
}
