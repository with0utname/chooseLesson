package tu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// ‘ˆº”≤‚ ‘
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

		String manager = request.getParameter("manager");
		if (manager == null || manager.equals(""))
			manager = (String) request.getAttribute("manager");

		request.setAttribute("function", "findAllCourse");
		if (manager.equals("courseList")) {
			request.getRequestDispatcher("/CourseListController").forward(
					request, response);
		} else if (manager.equals("chooseCourse")) {
			request.getRequestDispatcher("/ChooseCourseController").forward(
					request, response);
		} else if (manager.equals("addCourse")) {
			
			request.getRequestDispatcher("/AddCourseController").forward(
					request, response);
		} else if (manager.equals("viewCourse")) {
			request.setAttribute("function", "findMyCourse");
			request.getRequestDispatcher("/ViewCourseController").forward(
					request, response);
		} else
			request.getRequestDispatcher("index.html").forward(request,
					response);
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
