/**
 *
 */
package com.internousdev.template.dto;

/**
 * カート情報を格納・取得するクラス
 * @author Shun Nagao
 *
 */
public class SelectCartDTO {

	private int item_id;

	private String item_name;

	private int price;

	private int order_count;

	private String img;

	private int purchase_flg;


	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPurchase_flg() {
		return purchase_flg;
	}

	public void setPurchase_flg(int purchase_flg) {
		this.purchase_flg = purchase_flg;
	}


}
