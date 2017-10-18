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
import com.internousdev.template.dto.SelectCartDTO;
import com.internousdev.template.util.DBConnector;

/**
 * 商品詳細からカートに遷移するクラス
 * @author Shun Nagao
 *
 */

public class InsertCartDAO {
	public ArrayList<SelectCartDTO> itemStatus(int item_id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<SelectCartDTO> itemStatus = new ArrayList<SelectCartDTO>();

		String sql = "select * from item where item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				SelectCartDTO scDto = new SelectCartDTO();
				scDto.setItem_name(rs.getString("item_name"));
				scDto.setPrice(rs.getBigDecimal("price"));
				scDto.setImg(rs.getString("img"));

				itemStatus.add(scDto);
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
		return itemStatus;
	}



	public int addToCart(int user_id, int item_id, int order_count, BigDecimal price) {
		int addCount = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into cart(user_id, item_id, order_count, price) values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user_id);
			ps.setInt(2, item_id);
			ps.setInt(3, order_count);
			ps.setBigDecimal(4,  price);
			addCount = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			if(con != null) {
				try {
					con.close();

				} catch(SQLException e) {
					e.printStackTrace();

				}
			}
		}
		return addCount;
	}



	/**
	 * 商品詳細からカートに遷移
	 * @param user_id
	 * @return cartList
	 * @auther Shun Nagao
	 * @since 2017/10/18
	 * @version 1.0
	 */

	public ArrayList<CartDTO> selected(int user_id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "select * from cart where user_id=?";
		String select2 = "SELECT * FROM item WHERE item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setItem_id(rs.getInt("item_id"));
				dto.setOrder_count(rs.getInt("order_count"));
				dto.setCart_id(rs.getInt("cart_id"));

				cartList.add(dto);

				PreparedStatement ps2 = con.prepareStatement(select2);
				ps2.setInt(1, dto.getItem_id());
				ResultSet rs2 = ps2.executeQuery();

				while(rs.next()) {
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
