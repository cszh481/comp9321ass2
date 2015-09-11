package dao;

import dto.Item;

public class ItemDaoImpl implements ItemDao {

	// singleton
	public static ItemDaoImpl instance;

	public static ItemDaoImpl getInstance() {
		if (instance == null) {
			instance = new ItemDaoImpl();
		}
		return instance;
	}
	
	@Override
	public void saveOrUpdate(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
