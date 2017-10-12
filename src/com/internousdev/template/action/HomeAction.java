package com.internousdev.template.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private Map<String, Object> loginUserInfoMap = new HashMap<String, Object>();

	/**
	 * ログインボタン押下時に実行
	 * ログイン画面へ遷移します。
	 *
	 * @return SUCCSESS
	 */
	public String execute() {
		String result = "login";
		if (session.containsKey("id")) {
			loginUserInfoMap.putAll(session);
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public void setLoginUserInfoMap(Map<String, Object> loginUserInfoMap) {
		this.loginUserInfoMap = loginUserInfoMap;
	}

	public Map<String, Object> getLoginUserInfoMap() {
		return this.loginUserInfoMap;
	}
}
