package com.internousdev.template.dto;

import java.math.BigDecimal;

public class BuyItemDTO {

	public int itemId;

	public String itemName;

	public BigDecimal Price;

	public String type;

	public int quantity;

	private String comment;

	private String img;

	/**
	 * 商品リストから価を取得するためのインデックス番号
	 */
	private int index;




	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}



}
