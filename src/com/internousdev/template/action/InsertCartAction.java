/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.InsertCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.SelectCartDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品詳細からカートに遷移するクラス
 * @author internousdev
 *
 */
public class InsertCartAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -24324L;

	/**
	 * カートID
	 */
	private int cart_id;

	/**
	 * ユーザーID
	 */
	private int user_id;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String item_name;

	/**
	 * 価格
	 */
	private int price;

	/**
	 * 数量
	 */
	private int count;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 合計金額
	 */
	private int total_price;

	/**
	 * カート情報
	 */
	private ArrayList<CartDTO> cartList;

	/**
	 * 商品情報
	 */
	private ArrayList<SelectCartDTO> itemStatus;

	/**
	 * 商品追加
	 */
	private int addCount;

	/**
	 * 小計
	 */
	private BigDecimal sub_total;

	/**
	 * 画像パス
	 */
	private String img;

	/**
	 * 実行メソッド
	 * 商品詳細からカートに購入情報を送る
	 * @return success or error
	 * @author Shun Nagao
	 * @since 2017/10/18
	 * @version 1.0
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		if(session.containsKey("id")) {
			user_id = (int) session.get("id");

			InsertCartDAO dao = new InsertCartDAO();

			itemStatus = dao.itemStatus(itemId);
			this.price = itemStatus.get(0).getPrice();
			addCount = dao.addToCart(user_id, itemId, count, price);
			cartList = dao.selected(user_id);


			if(cartList.size() > 0) {
				for (int i = 0; i < cartList.size(); i++) {

					//total_price = total_price.add(cartList.get(i).getPrice().multiply(BigDecimal.valueOf(cartList.get(i).getOrder_count())));
					total_price = cartList.get(i).getPrice() * cartList.get(i).getOrder_count();
				}
				result = SUCCESS;
			}
		}
		return result;
	}

	/**
	 * カートIDを取得するメソッド
	 * @return cart_id
	 */
	public int getCart_id() {
		return cart_id;
	}

	/**
	 * カートIDを格納するメソッド
	 * @param cart_id
	 */
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	/**
	 * ユーザーIDを取得するメソッド
	 * @return user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーIDを格納するメソッド
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * 商品IDを取得するメソッド
	 * @return item_id
	 */
	public int getItemId() {
		return itemId;
	}
	/**
	 * 商品IDを格納するメソッド
	 * @param item_id
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品名を取得するメソッド
	 * @return item_name
	 */
	public String getItem_name() {
		return item_name;
	}
	/**
	 * 商品名を格納するメソッド
	 * @param item_name
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	/**
	 * 価格を取得するメソッド
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 価格を格納するメソッド
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 数量を取得するメソッド
	 * @return order_count
	 */
	public int getOrder_count() {
		return count;
	}

	/**
	 * 数量を格納するメソッド
	 * @param order_count
	 */
	public void setOrder_count(int order_count) {
		this.count = order_count;
	}

	/**
	 * セッションを取得するメソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを格納するメソッド
	 * @param session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 合計金額を取得するメソッド
	 * @return total_price
	 */
	public int getTotal_price() {
		return total_price;
	}
	/**
	 * 合計金額を格納するメソッド
	 * @param total_price
	 */
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	/**
	 * カート情報を取得するメソッド
	 * @return cartList
	 */
	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}
	/**
	 * カート情報を格納するメソッド
	 * @param cartList
	 */
	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * 商品情報を取得するメソッド
	 * @return itemStatus
	 */
	public ArrayList<SelectCartDTO> getItemStatus() {
		return itemStatus;
	}

	/**
	 * 商品情報を格納するメソッド
	 * @param
	 */
	public void setItemStatus(ArrayList<SelectCartDTO> itemStatus) {
		this.itemStatus = itemStatus;
	}
	/**
	 * 商品追加を取得するメソッド
	 * @return
	 */
	public int getAddCount() {
		return addCount;
	}
	/**
	 * 商品追加を格納するメソッド
	 * @param
	 */
	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

	/**
	 * 小計を取得するメソッド
	 * @return
	 */
	public BigDecimal getSub_total() {
		return sub_total;
	}

	/**
	 * 小計を格納するメソッド
	 * @param
	 */
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	/**
	 * 画像パスを取得するメソッド
	 * @return
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 画像パスを格納するメソッド
	 * @param
	 */
	public void setImg(String img) {
		this.img = img;
	}

}