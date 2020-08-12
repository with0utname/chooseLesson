package tu.service.impl;

import tu.dao.AddCourseDao;
import tu.dao.impl.AddCourseDaoImpl;
import tu.service.AddCourseService;

public class AddCourseServiceImpl implements AddCourseService {


	@Override
	public void addCourse(String courseid, String coursename, String teacher,
			String limited, String time_1, String time_2, String location,
			String point) {
		// TODO Auto-generated method stub
		AddCourseDao addCourseDao = new AddCourseDaoImpl();
		addCourseDao.addCourse(courseid, coursename, teacher, Integer.parseInt(point), time_1, time_2, location, Integer.parseInt(point));
	}


}
