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
import tu.service.CourseListService;
import tu.service.impl.CourseListServiceImpl;

@WebServlet("/CourseListController")
public class CourseListController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseListController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CourseListService CourseListService = new CourseListServiceImpl();
		List<Course> list = new ArrayList<Course>();
		String username = request.getParameter("username");
		String courseid = request.getParameter("courseid");
		System.out.println(username + "manager1");
		request.setAttribute("username", username);
		request.setAttribute("courseid", courseid);
		System.out.println(username + "manager");
		System.out.println("controller∆Ù∂Ø");
		String function = request.getParameter("function");
		if (function == null)
			function = (String) request.getAttribute("function");

		if (function.equals("findAllCourse")) {
			list = CourseListService.findAllCourse();
			System.out.println(username + "out");
		}
		request.setAttribute("username", username);
		request.setAttribute("list", list);
		System.out.print("CourseListServiceControllerlast:"+username);
		request.getRequestDispatcher("/WEB-INF/manager/courseList.jsp")
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