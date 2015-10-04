package dao;

import java.util.Calendar;
import java.util.Date;

import service.ItemService;
import dto.DblpElement;
import dto.Item;

public class ConvertHandler {
	public Item convert(DblpElement element) {
		Item item = new Item();
		item.setTitle(element.getTitle());
		item.setAuthors(element.getAuthors().toString());
		item.setType(element.getType());
		item.setVenue(element.getJournal());

		int year = Integer.parseInt(element.getYear());
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, year);
		Date result = cld.getTime();
		item.setPublication_date(result);

		return item;
	}

	public void InsertItem() {
		ItemService itemService = new ItemService();
		for (DblpElement e : DblpDao.allElements) {
			Item i = convert(e);
			System.out.print(i.getTitle());
			itemService.saveOrUpdate(i);
		}
	}
	
	public void main (){
		this.InsertItem();
	}
}
