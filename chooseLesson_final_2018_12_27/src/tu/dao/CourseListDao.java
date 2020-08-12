package tu.dao;

import java.util.List;

import tu.domain.Course;

public interface CourseListDao {
	public List<Course> findAllCourse();
}
