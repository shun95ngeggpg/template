/**
 *
 */
package com.internousdev.template.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;



/**
 * カート内の商品の数量を変更するクラス
 * @author Shun Nagao
 *
 */
public class UpdateCartDAO {
	public int updateCart(int cart_id, int user_id, int order_count, BigDecimal price) {
		int count = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql ="update cart set order_count=?, price=? where user_id=? and cart_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  order_count);
			ps.setBigDecimal(2, price);
			ps.setInt(3, user_id);
			ps.setInt(4,  cart_id);
			count = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			if(con!=null) {
				try {
					con.close();

				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;

	}
}