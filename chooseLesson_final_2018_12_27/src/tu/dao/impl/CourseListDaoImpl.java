package tu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tu.dao.CourseListDao;
import tu.db.DBAccess;
import tu.domain.Course;

public class CourseListDaoImpl implements CourseListDao{

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
				course.setPoint(rs.getInt("point"));
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

}
