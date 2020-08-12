package tu.domain;

public class Course {
	public String course_id;
	public String course_name;
	public String teacher;
	public int point;
	public String time_1;
	public String time_2;
	public String location;
	public int limited;

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getTime_1() {
		return time_1;
	}

	public void setTime_1(String time_1) {
		this.time_1 = time_1;
	}

	public String getTime_2() {
		return time_2;
	}

	public void setTime_2(String time_2) {
		this.time_2 = time_2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLimited() {
		return limited;
	}

	public void setLimited(int limited) {
		this.limited = limited;
	}

}
