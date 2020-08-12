package tu.dao;

import java.util.List;

import tu.domain.Course;

public interface ChooseCourseDao {
	public List<Course> findAllCourse();
	public void chooseCourse(String username,String courseid);
}
