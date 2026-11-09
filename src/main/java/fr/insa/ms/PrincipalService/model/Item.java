package fr.insa.ms.PrincipalService.model;

public class Item {
	
	private int itemId;
	private String itemLabel;
	private String itemDescription;
	
	public Item() {}
	
	public Item(int itemId, String itemLabel, String itemDescription) {
		this.itemId = itemId;
		this.itemLabel = itemLabel;
		this.itemDescription = itemDescription;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemLabel() {
		return itemLabel;
	}
	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}