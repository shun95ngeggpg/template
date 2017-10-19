/**
 *
 */
package com.internousdev.template.action;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ItemDetailDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品詳細を表示するクラス
 * @author Shun Nagao
 *
 */
public class ItemDetailAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2464526565L;

	private int item_id;

	private String item_name;

	private BigDecimal price;

	private int quantity;

	private String type;

	private String comment;

	private String img;

	/**
	 * 商品一覧表示用リスト
	 */
	private ArrayList<BuyItemDTO> displayList = new ArrayList<BuyItemDTO>();

	private Map<String, Object> session;

	/**
	 * 商品詳細を表示するメソッド
	 */

	public String execute() throws SQLException {
		String result = ERROR;

		ItemDetailDAO dao = new ItemDetailDAO();
		displayList = dao.select(item_id);

		if(displayList.size() != 0) {
			this.item_name = displayList.get(0).getItemName();
			this.img = displayList.get(0).getImg();

			result = SUCCESS;
		}
		return result;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public ArrayList<BuyItemDTO> getDisplayList() {
		return displayList;
	}

	public void setDisplayList(ArrayList<BuyItemDTO> displayList) {
		this.displayList = displayList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
