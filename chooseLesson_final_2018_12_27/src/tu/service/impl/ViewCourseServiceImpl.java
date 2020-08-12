package tu.service.impl;

import java.util.ArrayList;
import java.util.List;

import tu.dao.ViewCourseDao;
import tu.dao.impl.ViewCourseDaoImpl;
import tu.domain.Course;
import tu.service.ViewCourseService;

public class ViewCourseServiceImpl implements ViewCourseService{

	@Override
	public List<Course> findMyCourse(String username) {
		// TODO Auto-generated method stub
		ViewCourseDao viewCourseDao = new ViewCourseDaoImpl();
		List<Course> list = new ArrayList<Course>();
		System.out.print(username+"service");
		list=viewCourseDao.findMyCourse(username);
		return list;
	}

	@Override
	public List<Course> deleteCourse(String username,String course_id) {
		// TODO Auto-generated method stub
		ViewCourseDao viewCourseDao = new ViewCourseDaoImpl();
		List<Course> list = new ArrayList<Course>();
		viewCourseDao.deleteCourse(username,course_id);
		list=viewCourseDao.findMyCourse(username);
		return list;
	}

}
