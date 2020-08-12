package tu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tu.dao.ViewCourseDao;
import tu.db.DBAccess;
import tu.domain.Course;

public class ViewCourseDaoImpl implements ViewCourseDao {
	// String order = "select * from course where course_id in (select course_id
	// from elective where username="+username+")";
	@Override
	public List<Course> findMyCourse(String username) {
		// TODO Auto-generated method stub
		Statement sql = null;
		ResultSet rs = null;
		DBAccess con = new DBAccess();
		con.getConn();
		List<Course> list = new ArrayList<Course>();
		System.out.println(username + "nowineed");
		String order = "select * from course where course_id in (select course_id from elective where username='"
				+ username + "')";
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
	public void deleteCourse(String username,String course_id) {
		// TODO Auto-generated method stub
		DBAccess con = new DBAccess();
		Connection conn = null;
		Statement stmt = null;
		conn = con.getConn();
		String order = "delete from elective where course_id='"+course_id+"' and username='"+username+"';";
		boolean rs = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.execute(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dont say 1");
		}
		System.out.println(rs);
		con.closeConnection();
	}
}
