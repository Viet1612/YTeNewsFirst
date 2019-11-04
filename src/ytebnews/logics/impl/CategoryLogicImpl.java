/**
 * Copyright(C) 2019 Tran Thanh Viet
 * CategoryLogicimpl.java, Oct 13, 2019 VietTT
 */
package ytebnews.logics.impl;

import java.sql.SQLException;
import java.util.List;

import ytebnews.dao.CategoryDao;
import ytebnews.dao.impl.CategoryDaoImpl;
import ytebnews.entities.Category;
import ytebnews.logics.CategoryLogic;

/**
 * @author VietTT
 *
 */
public class CategoryLogicImpl implements CategoryLogic {

	private CategoryDao categoryDao = new CategoryDaoImpl();

	/*
	 * (non-javadoc)
	 * 
	 * @see ytebnews.logics.CategoryLogic#getListCategory()
	 */
	@Override
	public List<Category> getListCategory() throws ClassNotFoundException, SQLException {
		List<Category> listCategories = categoryDao.getListCategory();
		return listCategories;
	}

}
