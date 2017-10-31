/**
 *
 */
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.SelectCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.util.creditcard.manager.CreditUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * クレジットカードの種類を判別し情報が正しいかチェックするク
 * @author Shun Nagao
 *
 */
public class DoPaymentAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -649673649697037412L;

	private int creditId;

	private int user_id;

	private int total_price;

	private String creditNumber;

	private String nameE;

	private String securityCode;

	private int expirationMonth;

	private int expirationYear;

	private Map<String, Object> session;

	private String errmsg1;

	private String creditBrand;

	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();


	/**
	 * クレジットカード番号、セキュリティコード、有効期限、名義人の照合
	 * @return ERROR or SUCCESS
	 */
	public String execute() {
		CreditUtil util = new CreditUtil(creditId, creditNumber);

		if(util.brandCheck()) {
			if(util.creditCheck(securityCode, expirationYear, expirationMonth, nameE )) {



				String result = ERROR;
				if(session.containsKey("userId")){
					user_id = (int)session.get("userId");

					SelectCartDAO cartDao = new SelectCartDAO();

					//アレイリストに情報を入れる
					cartList = cartDao.selectCart(user_id);
					if(cartList.size() > 0){

						for(int i = 0; i < cartList.size(); i++) {

							total_price = cartList.get(i).getPrice() * cartList.get(i).getOrder_count();

							//CartDAOに合計金額を格納する
							CartDTO dto = new CartDTO();

							dto.setTotal_price(total_price);
						}
						String lastCreditNumber = creditNumber.substring(12, creditNumber.length());
						creditNumber = "************" + lastCreditNumber;

						result = SUCCESS;
					}else{
						result = LOGIN;
					}
				}
				return result;
			} else {
				errmsg1="*入力された情報に間違いがあります。";
				return ERROR;
			}

		} else {
			errmsg1="*入力された情報に間違いがあります。";
			return ERROR;
		}
	}




	public int getCreditId() {
		return creditId;
	}


	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getTotal_price() {
		return total_price;
	}


	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}


	public String getCreditNumber() {
		return creditNumber;
	}


	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}


	public String getNameE() {
		return nameE;
	}


	public void setNameE(String nameE) {
		this.nameE = nameE;
	}


	public String getSecurityCode() {
		return securityCode;
	}


	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}


	public int getExpirationMonth() {
		return expirationMonth;
	}


	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}


	public int getExpirationYear() {
		return expirationYear;
	}


	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getErrmsg1() {
		return errmsg1;
	}


	public void setErrmsg1(String errmsg1) {
		this.errmsg1 = errmsg1;
	}


	public String getCreditBrand() {
		return creditBrand;
	}


	public void setCreditBrand(String creditBrand) {
		this.creditBrand = creditBrand;
	}


	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}


	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}

}
