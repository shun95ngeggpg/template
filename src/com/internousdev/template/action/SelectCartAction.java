/**
 *
 */
package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.SelectCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート情報を取得するアクション
 * @author Shun Nagao
 */
public class SelectCartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -1339727407L;

	private int user_id;

	private int item_id;

	private String item_name;

	private int order_count;

	private int total_price;

	private ArrayList<CartDTO> cartList = new ArrayList<>();

	private Map<String, Object> session;

	private String img;


	/**
	 * 実行メソッド
	 * 1：セッション情報を持っているか判断
	 * 2：session内のuserIdを使用し、カートへ登録された情報を取得
	 * 3：カート内の情報を元に合計金額を算出
	 * @return SUCCESS
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if (session.containsKey("userId")) {
			user_id = (int) session.get("userId");

			SelectCartDAO dao = new SelectCartDAO();
			cartList = dao.selectCart(user_id);

			if (cartList.size()>0) {
				for(int i =0; i < cartList.size(); i++) {
					total_price = cartList.get(i).getPrice() * cartList.get(i).getOrder_count();

				}
				result = SUCCESS;
			}
		}
		return result;
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


	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}


	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}



}
