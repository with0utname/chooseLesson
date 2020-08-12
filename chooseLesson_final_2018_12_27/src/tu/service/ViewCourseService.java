package tu.service;

import java.util.List;

import tu.domain.Course;

public interface ViewCourseService {
	public List<Course> findMyCourse(String username);
	
	public List<Course> deleteCourse(String username,String course_id);
}
