/**
 *
 */
package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.SelectCartDAO;
import com.internousdev.template.dao.UpdateCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.SelectItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート内の商品数量を変更するクラス
 * @author Shun Nagao
 *
 */

public class UpdateCartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8073474230094L;

	private int cart_id;

	private int user_id;

	private int item_id;

	private String item_name;

	private int price;

	private int order_count;

	private int total_price;

	private int updateCount;

	private ArrayList<CartDTO> cartList;

	private ArrayList<SelectItemDTO> itemList;

	private Map<String, Object> session;

	/**
	 * カートの上限処理を実行するメソッド
	 *
	 */

	public String execute() throws SQLException{
		String result = ERROR;

		if(session.containsKey("userId")) {
			user_id = (int) session.get("userId");

			UpdateCartDAO ucDao = new UpdateCartDAO();
			SelectCartDAO scDao = new SelectCartDAO();

			updateCount = ucDao.updateCart(cart_id, user_id, order_count, price);
			cartList = scDao.selectCart(user_id);

			if (cartList.size() > 0) {
				for(int i= 0; i < cartList.size(); i++) {

					total_price = cartList.get(i).getPrice() * cartList.get(i).getOrder_count();

					result = SUCCESS;
				}
			}
		}
		return result;
	}

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

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getUpdate_countDTO() {
		return updateCount;
	}

	public void setUpdate_count(int updateCount) {
		this.updateCount = updateCount;
	}

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	public ArrayList<SelectItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<SelectItemDTO> itemList) {
		this.itemList = itemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
