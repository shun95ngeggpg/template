/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.DeleteCartDAO;
import com.internousdev.template.dao.SelectCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カーとの中身を削除するクラス
 * @author Shun Nagao
 *
 */
public class DeleteCartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -87443638327L;

	private BigDecimal total_price = BigDecimal.ZERO;

	private int order_count;

	private int user_id;

	private int cart_id;

	private int delCount;

	private Map<String, Object> session;

	private List<CartDTO> cartList = new ArrayList<>();


	/**
	 * カートの商品を削除処理をする実行メソッド
	 * @Shun Nagao
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.get("userId") != null) {
			int user_id = (int) session.get("userId");

			DeleteCartDAO dcDao = new DeleteCartDAO();
			SelectCartDAO scDao = new SelectCartDAO();

			delCount = dcDao.delete(user_id,  cart_id);

			if(delCount > 0) {
				cartList = scDao.selectCart(user_id);

				if(cartList.size() > 0) {
					for(int i = 0; i < cartList.size(); i++) {
						total_price = total_price.add(cartList.get(i).getPrice().multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())));

					}
					result = SUCCESS;
				}
			}
		}
		return result;
	}


	public BigDecimal getTotal_price() {
		return total_price;
	}


	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}


	public int getOrder_count() {
		return order_count;
	}


	public void setOrder_count(int order_count) {
		this.order_count = order_count;
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


	public int getDelCount() {
		return delCount;
	}


	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public List<CartDTO> getCartList() {
		return cartList;
	}


	public void setCartList(List<CartDTO> cartList) {
		this.cartList = cartList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
