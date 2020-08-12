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
import tu.service.ViewCourseService;
import tu.service.impl.ViewCourseServiceImpl;

@WebServlet("/ViewCourseController")
public class ViewCourseController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public ViewCourseController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ViewCourseService viewCourseService = new ViewCourseServiceImpl();
		List<Course> list = new ArrayList<Course>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String courseid = request.getParameter("courseid");
		String role = request.getParameter("role");
		
		//request.setAttribute("username", username); 这些千万不能放在这。会被删除
		System.out.println("controller1启动");
		String function = request.getParameter("function");
		if (function == null)
			function = (String) request.getAttribute("function");

		if (function.equals("findMyCourse")) {
			System.out.print(username + "controller");
			list = viewCourseService.findMyCourse(username);
		} else if (function.equals("deleteCourse")) {
			list = viewCourseService.deleteCourse(username, courseid);
		}
		request.setAttribute("role", role);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("courseid", courseid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/manager/viewCourse.jsp")
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
