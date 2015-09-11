package dao;

import dto.Item;


public interface ItemDao {

	public void saveOrUpdate(Item item);

	public Item getItemById(int id);



}
