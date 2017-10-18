/**
 *
 */
package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;

/**
 * カーと情報を取得するクラス
 * @author Shun Nagao
 *
 */
public class SelectCartDAO {
	public ArrayList<CartDTO> selectCart(int user_id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "select * from cart where user_id=? and purchase_flg=0";
		String select2 = "SELECT * FROM item WHERE item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setCart_id(rs.getInt("cart_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));

				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(select2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs2.next()) {
					dto.setItem_name(rs2.getString("item_name"));
					dto.setPrice(rs2.getBigDecimal("price"));
					dto.setSub_total(dto.getPrice().multiply(BigDecimal.valueOf(dto.getOrder_count())));
					dto.setImg(rs2.getString("img"));

				}
			}
		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();

			} catch(Exception e) {
				e.printStackTrace();

			}
		}
		return cartList;
	}
}
