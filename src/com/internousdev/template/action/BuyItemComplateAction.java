package com.internousdev.template.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemComplateAction extends ActionSupport implements SessionAware{

	public Map<String,Object> buyItemInfoSession = new HashMap<String, Object>();

	public String result;

	/**
	 * 商品購入情報登録完了メソッド
	 *
	 * @author internous
	 */
	public String execute() {

		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> buyItemInfoSession) {
		this.buyItemInfoSession = buyItemInfoSession;
	}
}
