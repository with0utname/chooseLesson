package tu.dao;

import java.util.List;

import tu.domain.Course;

public interface ViewCourseDao {
	public List<Course> findMyCourse(String username);
	
	public void deleteCourse(String username,String course_id);
}
