/**
 * Copyright(C) 2019 Tran Thanh Viet
 * ValidateUser.java, Oct 13, 2019 VietTT
 */
package ytebnews.validates;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import ytebnews.entities.User;
import ytebnews.logics.UserLogic;
import ytebnews.logics.impl.UserLogicImpl;
import ytebnews.utils.Constant;
import ytebnews.utils.MessageProperties;

/**
 * @author VietTT
 *
 */
public class ValidateUser {

	private UserLogic userLogic = new UserLogicImpl();

	/**
	 * Validate cho loginName và pass
	 * 
	 * @param loginName
	 * @param pass
	 * @return Message danh sách các lỗi
	 */
	public String validateLoginAdmin(String loginName, String pass)
			throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
		String errMes = "";
		User user = userLogic.getUserByLoginName(loginName);
		if (!userLogic.existUser(loginName, pass) || user.getRule() == Constant.RULE_USER) {
			// kiểm tra loginname, pass đúng không sai add lỗi vào errMes
			errMes = MessageProperties.getMesage(Constant.ER016);
		}
		return errMes;

	}

}
