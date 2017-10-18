/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.SelectCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート画面から支払い画面に遷移するクラス
 * @author Shun Nagao
 *
 */
public class GoPaymentAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3439574768409L;

	private Map<String, Object> session;

	private int user_id;

	private BigDecimal total_price = BigDecimal.ZERO;

	private BigDecimal sub_total = BigDecimal.ZERO;
	private ArrayList<CartDTO> cartList = new ArrayList<>();

	private ArrayList<CartDTO> userList = new ArrayList<>();

	/**
	 * カート・商品情報を格納する実行メソッド
	 *
	 */

	public String execute() {
		String result = ERROR;

		if (session.containsKey("user_id")) {
			user_id = (int) session.get("userId");

			SelectCartDAO cartDao = new SelectCartDAO();

			cartList = cartDao.selectCart(user_id);

			for(int i=0; i < cartList.size(); i++) {
				total_price = total_price.add(cartList.get(i).getSub_total());
			}

			if (cartList.size() > 0) {
				return SUCCESS;
			}
		} else {
			return LOGIN;
		}
		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	public ArrayList<CartDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<CartDTO> userList) {
		this.userList = userList;
	}



}
