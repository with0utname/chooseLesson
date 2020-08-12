package tu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tu.domain.User;
import tu.service.LoginService;
import tu.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		LoginService loginService = new LoginServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(role);

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);
		request.setAttribute("user", user);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("role", role);


		if (loginService.check(username, password, role) == false) {
			request.getRequestDispatcher("/WEB-INF/error.html").forward(request, response);
		} else {
			if (Integer.parseInt(user.getRole()) == 0) {
				request.setAttribute("manager", "chooseCourse");
				request.getRequestDispatcher("/Manager").forward(request, response);
			} else if (Integer.parseInt(user.getRole()) == 1) {
				request.setAttribute("manager", "courseList");
				request.getRequestDispatcher("/Manager").forward(request, response);
			}
		}
	}

}
