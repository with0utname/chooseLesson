package tu.service.impl;

import java.util.ArrayList;
import java.util.List;

import tu.dao.CourseListDao;
import tu.dao.impl.CourseListDaoImpl;
import tu.domain.Course;
import tu.service.CourseListService;

public class CourseListServiceImpl implements CourseListService {

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<Course>();
		 CourseListDao courseListDao = new CourseListDaoImpl();
		 list =courseListDao.findAllCourse();
		return list;
	}


}
