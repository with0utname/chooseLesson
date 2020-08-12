package tu.service.impl;

import java.util.ArrayList;
import java.util.List;

import tu.dao.ChooseCourseDao;
import tu.dao.impl.ChooseCourseDaoImpl;
import tu.domain.Course;
import tu.service.ChooseCourseService;

public class ChooseCourseServiceImpl implements ChooseCourseService{

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		ChooseCourseDao chooseCourseDao = new ChooseCourseDaoImpl();
		List<Course> list= new ArrayList<Course>();
		list = chooseCourseDao.findAllCourse();
		return list;
	}

	@Override
	public List<Course> chooseCourse(String username,String courseid) {
		// TODO Auto-generated method stub
		ChooseCourseDao chooseCourseDao = new ChooseCourseDaoImpl();
		//chooseCourseDao.chooseCourse(username, courseid);
		List<Course> list= new ArrayList<Course>();
		list = chooseCourseDao.findAllCourse();
		chooseCourseDao.findAllCourse();
		chooseCourseDao.chooseCourse(username, courseid);
		return list;
	}

}
