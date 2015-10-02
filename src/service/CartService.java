package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.CartDao;
import dao.CartDaoImpl;
import dto.Cart;

public class CartService {
	private CartDao cartDao = CartDaoImpl.getInstance();

	// get all items in shopping cart
	private List<Cart> getAllCart(int user_id) {
		return cartDao.getCart(user_id);
	}

	// get all removed items in shopping cart
	public List<Cart> getRemovedCart(int user_id) {
		List<Cart> list = new ArrayList<Cart>();
		for (Cart c : getAllCart(user_id)) {
			if (c.isRemoved()) {
				list.add(c);
			}
		}
		return list;
	}

	// get all non removed items in shopping cart
	public List<Cart> getExistedCart(int user_id) {
		List<Cart> list = new ArrayList<Cart>();
		for (Cart c : getAllCart(user_id)) {
			if (!c.isRemoved()) {
				list.add(c);
			}
		}
		return list;
	}

	/**
	 * clear shopping cart
	 * @param user_id
	 */
	public void clearCartByUserId(int user_id) {
		cartDao.clearCartByUserId(user_id);
	}

	public void saveToCart(int user_id, int item_id, int count) {
		Cart cart = cartDao.getCartByUserIdAndItemId(user_id, item_id);
		if (cart == null) {
			cart = new Cart();
			cart.setUser_id(user_id);
			cart.setItem_id(item_id);
		}
		cart.setCount(count);
		cartDao.saveOrUpdate(cart);
	}

	public void removeCart(int user_id, int item_id) {
		Cart cart = cartDao.getCartByUserIdAndItemId(user_id, item_id);
		if (cart != null) {
			cart.setRemoved(new Timestamp(System.currentTimeMillis()));
			cartDao.saveOrUpdate(cart);
		}
	}

	public Cart getCartByUserIdAndItemId(int user_id, int item_id) {
		return cartDao.getCartByUserIdAndItemId(user_id, item_id);
	}

}
