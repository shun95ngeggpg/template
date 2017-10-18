/**
 *
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.util.db.mysql.MySqlConnector;

/**
 * 決済完了に関するクラス
 * @author Shun Nagao
 *
 */
public class PayCompDAO {

	/**
	 * カート・商品の情報の取得に関するメソッド
	 * @param user_id
	 * @return cartList
	 */

	public ArrayList<CartDTO> cartSelect(int user_id) {

		MySqlConnector db = new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "", "root","mysql");
		Connection con = db.getConnection();

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sql = "select * from cart where user_id = ? and purchase_flg = 0";

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


	/**
	 * 購入情報の登録に関するメソッド
	 * @param user_id
	 * @param item_id
	 * @param order_count
	 * @param total_price
	 * @return addCount
	 */

	public int payInsert(int user_id, int item_id, int order_count) {
		int addCount = 0;

		MySqlConnector db = new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "", "root","mysql");
		Connection con = db.getConnection();

		String sql = "update cart set purchase_flg=1 where user_id=? and item_id=? and order_count=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, item_id);
			ps.setInt(3,  order_count);

			addCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addCount;
	}


	/**
	 * カートテーブル内情報の削除に関するメソッド
	 * @param user_id
	 * @return ret 削除件数
	 */

	public int cartDelete(int user_id) {
		MySqlConnector dbCon = new MySqlConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/", "", "root","mysql");
		Connection con = dbCon.getConnection();
		int ret = 0;
		String sql = "delete from cart where user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user_id);

			ret = ps.executeUpdate();
		} catch(SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
