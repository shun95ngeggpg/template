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

	public ArrayList<BuyItemDTO> select() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<BuyItemDTO> itemList = new ArrayList<BuyItemDTO>();
		String sql = "SELECT * FROM item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO dto = new BuyItemDTO();

				dto.setItemId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));//DTOのsetItemNameメソッドにrs.getString("item_name")を渡している
				dto.setPrice(rs.getInt("item_price"));
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
