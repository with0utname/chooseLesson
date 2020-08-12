package tu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tu.domain.Course;
import tu.service.AddCourseService;
import tu.service.impl.AddCourseServiceImpl;

@WebServlet("/AddCourseController")
public class AddCourseController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddCourseController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddCourseService addCourseService = new AddCourseServiceImpl();
		List<Course> list = new ArrayList<Course>();
		String username = request.getParameter("username");

		String function = request.getParameter("function");
		if (function == null)
			function = (String) request.getAttribute("function");

		if (function.equals("addCourse")) {
			String courseid1 = request.getParameter("courseid1");
			String coursename1 = request.getParameter("coursename1");
			String teacher = request.getParameter("teacher");
			String point = request.getParameter("point");
			String time_1 = request.getParameter("time_1");
			String time_2 = request.getParameter("time_2");
			String location = request.getParameter("location");
			String limited = request.getParameter("limited");
			addCourseService.addCourse(courseid1, coursename1, teacher, point, time_1, time_2, location, limited);
		}

		request.setAttribute("username", username);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/manager/addCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
