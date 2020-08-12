package tu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tu.dao.LoginDao;
import tu.db.DBAccess;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean check(String username, String password, String role) {
		Statement sql = null;
		ResultSet rs = null;
		DBAccess dbaccess = new DBAccess();
		Connection con = dbaccess.getConn();
		String order = "select * from user where username = '" + username + "' and  password='" + password
				+ "' and role='" + role + "'";
		System.out.println(order);
		try {
			sql = con.createStatement();
			rs = sql.executeQuery(order);
			if (rs.next()) {
				return true;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			isright = rs.getBoolean(0);
		dbaccess.closeConnection();
		return false;
	}

}
