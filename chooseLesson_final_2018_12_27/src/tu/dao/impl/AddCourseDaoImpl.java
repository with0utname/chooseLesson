package tu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tu.dao.AddCourseDao;
import tu.db.DBAccess;
import tu.domain.Course;

public class AddCourseDaoImpl implements AddCourseDao {
	// TODO Auto-generated method stub
	/*
	 * //数据库连接 Connection conn = null; Statement sql = null; ResultSet rs; final
	 * String url = "jdbc:mysql://127.0.0.1/employee"; final String user =
	 * "root"; final String password = "12345678"; try { conn =
	 * DriverManager.getConnection(url,user,password); } catch (SQLException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } try {
	 * sql=conn.createStatement(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } try {
	 * rs=sql.executeQuery("select * from course"); } catch (SQLException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 */

	@Override
	public void addCourse(String courseid, String course_name, String teacher,
			int point, String time_1, String time_2, String location,
			int limited) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("before create");
		DBAccess con = new DBAccess();
		System.out.println("fater create");
		Connection conn = null;
		Statement stmt = null;
		conn = con.getConn();
		String order = "insert into course(course_id,course_name,teacher,point,time_1,time_2,location,limited) values('"
				+ courseid
				+ "','"
				+ course_name
				+ "','"
				+ teacher
				+ "','"
				+ point
				+ "','"
				+ time_1
				+ "','"
				+ time_2
				+ "','"
				+ location
				+ "','" + limited + "')";
		boolean rs = false;
		System.out.println(order);
		try {
			stmt = conn.createStatement();
			System.out.println("before ex");
			rs = stmt.execute(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dont say 2");
		}
		System.out.println(rs);
		con.closeConnection();
	}

}
