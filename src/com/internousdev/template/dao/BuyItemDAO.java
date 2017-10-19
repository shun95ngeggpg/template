package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return BuyItemDTO
	 */
	public BuyItemDTO getBuyItemInfo() {

		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				buyItemDTO.setItemId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setPrice(resultSet.getBigDecimal("item_price"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return buyItemDTO;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
}