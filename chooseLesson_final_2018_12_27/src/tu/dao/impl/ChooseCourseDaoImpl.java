package tu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tu.dao.ChooseCourseDao;
import tu.db.DBAccess;
import tu.domain.Course;

public class ChooseCourseDaoImpl implements ChooseCourseDao {

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		Statement sql = null;
		ResultSet rs = null;
		DBAccess con = new DBAccess();
		con.getConn();
		List<Course> list = new ArrayList<Course>();
		String order = "select * from course";
		try {
			rs = con.query(order);
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getString("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setTeacher((rs.getString("teacher")));
				course.setPoint(rs.getInt("course_id"));
				course.setTime_1(rs.getString("time_1"));
				course.setTime_2(rs.getString("time_2"));
				course.setLocation(rs.getString("location"));
				course.setLimited(rs.getInt("limited"));
				list.add(course);
			}
			con.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库失败");
		}
		System.out.println("输出list");
		return list;
	}

	@Override
	public void chooseCourse(String username, String courseid) {
		// TODO Auto-generated method stub
		System.out.println("before create");
		DBAccess con = new DBAccess();
		System.out.println("fater create");
		Connection conn = null;
		Statement stmt = null;
		conn = con.getConn();
		String order = "insert into elective(username,course_id) values('"+username+"','"+courseid+"')";
		boolean rs = false;
		System.out.println(courseid + "kkp" + username);
		try {
			stmt=conn.createStatement();
			System.out.println("before ex");
			rs=stmt.execute(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dont say 1");
		}
		System.out.println(rs);
		con.closeConnection();
	}

}
