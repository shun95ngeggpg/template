/**
 *
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;


/**
 * カートテーブル内情報の削除に関するクラス
 * @author Shun Nagao
 *
 */
public class DeleteCartDAO {
	/**
	 * カートにある商品を削除するためのメソッド
	 * @param card_id
	 * @return 削除できたら1、できなかったら0を繰り返す
	 */

	public int delete(int user_id, int cart_id) {
		int delete = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from cart where user_id=? and cart_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, cart_id);

			delete = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();

			} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return delete;
}
}
