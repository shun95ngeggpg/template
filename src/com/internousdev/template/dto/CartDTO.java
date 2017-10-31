/**
 *
 */
package com.internousdev.template.dto;

/**
 * カート情報に関するDTOクラス
 * @author Shun Nagao
 *
 */
public class CartDTO {

	private int cart_id;

	private int user_id;

	private String family_name_kanji;

	private String given_neme_kanji;

	private int payment_method;

	private int item_id;

	private String item_name;

	private int count;

	private int price;

	private int total_price;

	private String note;

	private String img;

	private String registration_date;

	private String updated_date;

	private String item_category;

	private int sub_total;

	private int purchase_flg;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFamily_name_kanji() {
		return family_name_kanji;
	}

	public void setFamily_name_kanji(String family_name_kanji) {
		this.family_name_kanji = family_name_kanji;
	}

	public String getGiven_neme_kanji() {
		return given_neme_kanji;
	}

	public void setGiven_neme_kanji(String given_neme_kanji) {
		this.given_neme_kanji = given_neme_kanji;
	}

	public int getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(int payment_method) {
		this.payment_method = payment_method;
	}

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

	public int getOrder_count() {
		return count;
	}

	public void setOrder_count(int order_count) {
		this.count = order_count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public int getSub_total() {
		return sub_total;
	}

	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}

	public int getPurchase_flg() {
		return purchase_flg;
	}

	public void setPurchase_flg(int purchase_flg) {
		this.purchase_flg = purchase_flg;
	}


}
