package dto;

import java.util.Date;

public class Cart {
	private int user_id;
	private int item_id;
	private int count;
	private Date added;
	private Date removed;
	private Item Item;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		Item = item;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Date getRemoved() {
		return removed;
	}

	public void setRemoved(Date removed) {
		this.removed = removed;
	}

	public boolean isRemoved() {
		return this.removed != null;
	}

}
