/**
 * Copyright(C) 2019 Tran Thanh Viet
 * UserDao.java, Oct 13, 2019 VietTT
 */
package ytebnews.dao;

import java.sql.SQLException;

import ytebnews.entities.User;

/**
 * @author VietTT
 *
 */
public interface UserDao {

	/**
	 * Lấy user từ tbl_user với login nhập ở form
	 * 
	 * @param loginName tên đăng nhập
	 * @param rule      phân cấp user
	 * @return User
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public User getUserByLoginName(String loginName) throws SQLException, ClassNotFoundException;
	
	/**
	 * Check tồn tại của userId
	 * @param userId , rule
	 * @return true tồn tại
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean checkUserId(int userId, int rule) throws ClassNotFoundException, SQLException;

}
