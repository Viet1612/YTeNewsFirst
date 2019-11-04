/**
 * Copyright(C) 2019 Tran Thanh Viet
 * NewsLogicImpl.java, Oct 15, 2019 VietTT
 */
package ytebnews.logics.impl;

import java.sql.SQLException;
import java.util.List;

import ytebnews.dao.NewsDao;
import ytebnews.dao.impl.NewsDaoImpl;
import ytebnews.entities.News;
import ytebnews.logics.NewsLogic;
import ytebnews.utils.Common;

/**
 * @author VietTT
 *
 */
public class NewsLogicImpl implements NewsLogic {

	private NewsDao newsDao = new NewsDaoImpl();

	/*
	 * (non-javadoc)
	 * 
	 * @see ytebnews.logics.NewsLogic#getTotalNews(java.lang.String, int)
	 */
	@Override
	public int getTotalNews(String keyName, int categoryId, int approve, int userId)
			throws ClassNotFoundException, SQLException {
		int total = newsDao.getTotalNews(Common.replaceSqlWildcard(keyName), categoryId, approve, userId);
		return total;
	}

	/*
	 * (non-javadoc)
	 * 
	 * @see ytebnews.logics.NewsLogic#getListNews(int, int, int, java.lang.String)
	 */
	@Override
	public List<News> getListNews(int offset, int limit, int categoryId, String keyName, int approve, int userId)
			throws ClassNotFoundException, SQLException {
		List<News> listNews = newsDao.getListNews(offset, limit, categoryId, Common.replaceSqlWildcard(keyName),
				approve, userId);
		return listNews;
	}

	/* (non-javadoc)
	 * @see ytebnews.logics.NewsLogic#insertNewAuthor(ytebnews.entities.News)
	 */
	@Override
	public void insertNewAuthor(News news) throws ClassNotFoundException, SQLException {
		newsDao.insertNewAuthor(news);
		
	}

}
