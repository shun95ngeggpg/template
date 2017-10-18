/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PayCompDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 決済を完了するためのクラス
 * @author Shun Nagao
 *
 */
public class PayCompAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -46936205923738L;

	private Map<String, Object> session;

	private ArrayList<CartDTO> cartList;

	private int user_id;

	private int cart_id;

	private Date purchase_date;

	private BigDecimal total_price;


	/**
	 * 購入板商品の情報を格納する
	 * @return success or error or login
	 */

	public String execute() {
		String result = ERROR;

		if (session.containsKey("userId")) {
			CartDTO dto = new CartDTO();

			user_id = (int) session.get("userId");

			PayCompDAO dao = new PayCompDAO();

			cartList = dao.cartSelect(user_id);

			for (int i = 0; i < cartList.size(); i++) {
				total_price = dto.getTotal_price();
				if (dao.payInsert(user_id, cartList.get(i).getItem_id(), cartList.get(i).getOrder_count()) != 0) {
					result = SUCCESS;
				}
			}

		} else {
			result = LOGIN;
		}
		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}


	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getCart_id() {
		return cart_id;
	}


	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public Date getPurchase_date() {
		return purchase_date;
	}


	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}


	public BigDecimal getTotal_price() {
		return total_price;
	}


	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
