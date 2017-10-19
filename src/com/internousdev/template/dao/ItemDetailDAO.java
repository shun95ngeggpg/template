/**
 *
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

/**
 * 商品詳細を表示するクラス
 * @author Shun Nagao
 *
 */
public class ItemDetailDAO {

	public ArrayList<BuyItemDTO> select(int item_id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO dto = new BuyItemDTO();
		ArrayList<BuyItemDTO> itemList = new ArrayList<BuyItemDTO>();
		String sql = "SELECT * FROM item where item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dto.setItemId(rs.getInt("itemId"));
				dto.setItemName(rs.getString("itemName"));
				dto.setPrice(rs.getBigDecimal("Price"));
				dto.setType(rs.getString("type"));
				dto.setComment(rs.getString("Comment"));
				dto.setImg(rs.getString("img"));
				dto.setQuantity(rs.getInt("quantity"));
				itemList.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();

			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return itemList;
	}

}
