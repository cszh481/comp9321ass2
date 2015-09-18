package dao;

import java.util.List;

import dto.Cart;
import dto.Item;

public interface ItemDao {

	public void saveOrUpdate(Item item);

	public Item getItemById(int id);

	public List<Item> getAllItems();

	public List<Cart> getShoppingCart(int user_id);
	
	public void updateShoppingCart(int user_id, int item_id, int count);

}
