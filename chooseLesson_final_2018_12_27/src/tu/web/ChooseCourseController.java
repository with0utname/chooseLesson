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
import tu.service.ChooseCourseService;
import tu.service.impl.ChooseCourseServiceImpl;

@WebServlet("/ChooseCourseController")
public class ChooseCourseController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseCourseController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ChooseCourseService chooseCourseService = new ChooseCourseServiceImpl();
		List<Course> list = new ArrayList<Course>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String courseid = request.getParameter("courseid");
		String role = request.getParameter("role");
		System.out.println(username + "manager1");
		request.setAttribute("role", role);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("courseid", courseid);
		System.out.println(username + "manager");
		System.out.println("controller∆Ù∂Ø");
		String function = request.getParameter("function");
		if (function == null)
			function = (String) request.getAttribute("function");

		if (function.equals("findAllCourse")) {
			list = chooseCourseService.findAllCourse();
			System.out.println(username + "out");
		} else if (function.equals("chooseCourse")) {
			System.out.println(username + "out");
			list = chooseCourseService.chooseCourse(username, courseid);
		}
		request.setAttribute("username", username);
		request.setAttribute("list", list);
		System.out.print("chooseCourseControllerlast:"+username);
		request.getRequestDispatcher("/WEB-INF/manager/chooseCourse.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
