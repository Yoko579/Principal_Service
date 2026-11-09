package fr.insa.ms.PrincipalService.model;

import fr.insa.ms.PrincipalService.model.Item;

public class Inventory {
	
	private int stock;
	private Item item;
	
	public Inventory() {}
	
	public Inventory(int stock, Item item) {
		this.stock = stock;
		this.item = item;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}	
}