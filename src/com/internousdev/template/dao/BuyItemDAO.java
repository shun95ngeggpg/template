package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return BuyItemDTO
	 */
	public ArrayList<BuyItemDTO> getBuyItemInfo() {

		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();

				buyItemDTO.setItemId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				System.out.println(buyItemDTO.getItemName());
				buyItemDTO.setPrice(resultSet.getInt("item_price"));

				buyItemDTOList.add(buyItemDTO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return buyItemDTOList;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTO() {
		return buyItemDTOList;
	}
}