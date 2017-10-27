package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログイン認証処理
 * Login.jspからログインID、ログインパスワードを受け取り
 * DBへ問い合わせを行います。
 *
 * @author internous
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */
public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * ログインID
	 */
	public String loginUserId;

	/**
	 * ログインパスワード
	 */
	public String loginPassword;

	/**
	 * 処理結果を格納
	 */
	public String result;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session = new HashMap<>();

	/**
	 * ログイン情報取得DAO
	 */
	public LoginDAO loginDAO = new LoginDAO();

	/**
	 * ログイン情報格納DTO
	 */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * アイテム情報を取得
	 */
	public BuyItemDAO buyItemDAO = new BuyItemDAO();

	/**
	 * 実行メソッド
	 */
	public String execute() {

		result = ERROR;

		// ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		session.put("id", loginDTO);

		// ログイン情報を比較
		if(loginDTO.getLoginFlg()) {
			result = SUCCESS;

			// アイテム情報を取得
			ArrayList<BuyItemDTO> buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("login_user_id",	loginDTO.getLoginId());

			session.put("buyItemDTOList",	buyItemDTOList);

			/**
			loginUserInfoMap.put("id", buyItemDTO.getItemId());
			loginUserInfoMap.put("buyItem_name", buyItemDTO.getItemName());
			loginUserInfoMap.put("buyItem_price", buyItemDTO.getPrice());
			*/

			return result;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
