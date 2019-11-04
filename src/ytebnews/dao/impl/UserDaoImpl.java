/**
 * Copyright(C) 2019 Tran Thanh Viet
 * UserDaoImpl.java, Oct 13, 2019 VietTT
 */
package ytebnews.dao.impl;

import java.sql.SQLException;

import ytebnews.dao.UserDao;
import ytebnews.entities.User;
import ytebnews.utils.Constant;

/**
 * @author VietTT
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/*
	 * (non-javadoc)
	 * 
	 * @see ytebnews.dao.UserDao#getUserByLoginName(java.lang.String)
	 */
	@Override
	public User getUserByLoginName(String loginName) throws SQLException, ClassNotFoundException {
		User user = null;
		try {
			connectDB();
			if (con != null) {
				// Câu SQl
				StringBuilder sqlQuery = new StringBuilder();
				sqlQuery.append("SELECT * ");
				sqlQuery.append("FROM tbl_user ");
				sqlQuery.append("WHERE BINARY login_name = ?");
				// Tao đối tượng prepareStatement để gửi các câu lệnh sql được tham số hóa đến
				// csdl
				pst = con.prepareStatement(sqlQuery.toString());
				int index = 0;
				pst.setString(++index, loginName);
				rs = pst.executeQuery();
				// Lấy bản ghi
				while (rs.next()) {
					user = new User();
					user.setLoginName(rs.getString(Constant.T_LOGIN_NAME));
					user.setPass(rs.getString(Constant.T_PASS));
					user.setSalt(rs.getString(Constant.T_SALT));
					user.setRule(rs.getInt(Constant.T_RULE));
					user.setUserId(rs.getInt(Constant.T_USER_ID));
					user.setFullName(rs.getString(Constant.T_FUll_NAME));
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + "-"
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());
			throw e;
		} finally {
			closeConnectDB();
		}
		return user;
	}

	/*
	 * (non-javadoc)
	 * 
	 * @see ytebnews.dao.UserDao#checkUserId(int)
	 */
	@Override
	public boolean checkUserId(int userId, int rule) throws ClassNotFoundException, SQLException {
		boolean check = false;
		try {
			connectDB();
			if (con != null) {
				// Câu SQl
				StringBuilder sqlQuery = new StringBuilder();
				sqlQuery.append("SELECT user_id ");
				sqlQuery.append("FROM tbl_user ");
				sqlQuery.append("WHERE user_id = ? ");
				sqlQuery.append("AND rule = ?");
				// Tao đối tượng prepareStatement để gửi các câu lệnh sql được tham số hóa đến
				// csdl
				pst = con.prepareStatement(sqlQuery.toString());
				int index = 0;
				pst.setInt(++index, userId);
				pst.setInt(++index, rule);
				rs = pst.executeQuery();
				// Lấy bản ghi
				if (rs.next()) {
					check = true;
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass().getName() + "-"
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());
			throw e;
		} finally {
			closeConnectDB();
		}

		return check;
	}

}
