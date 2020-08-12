package tu.service;

import java.util.List;

import tu.domain.Course;

public interface ChooseCourseService {

	public List<Course> findAllCourse();
	public List<Course>chooseCourse(String username,String courseid);
}