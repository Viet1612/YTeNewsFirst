/**
 * Copyright(C) 2019 Tran Thanh Viet
 * CategoryLogic.java, Oct 13, 2019 VietTT
 */
package ytebnews.logics;

import java.sql.SQLException;
import java.util.List;

import ytebnews.entities.Category;

/**
 * @author VietTT
 *
 */
public interface CategoryLogic {
	
	/**
	 * Lấy danh sách Category từ DB
	 * 
	 * @return List Category
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Category> getListCategory() throws ClassNotFoundException, SQLException;

}
