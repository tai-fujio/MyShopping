package shopping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("./shopping/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("submit");
		HttpSession session = request.getSession();
		RequestDispatcher rd;

		if ("ログイン".equals(btn)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			User user = new User();
			UserBean userbean = user.getUserData(name, password);

			if (userbean != null) {
				session.setAttribute("user", userbean);
				session.setAttribute("isLogged", true);
				rd = request.getRequestDispatcher("./shopping/ShoppingListServlet");
			} else {
				rd = request.getRequestDispatcher("./jsp/loginNg.jsp");
			}
			rd.forward(request, response);
		} else if ("logout".equals(btn) || "ログアウト".equals(btn)) {
			session.removeAttribute("isLogged");
			session.removeAttribute("user");
			response.sendRedirect("./jsp/login.jsp");

		} else if ("購入一覧".equals(btn)) {
			rd = request.getRequestDispatcher("./shopping/BaughtListServlet");
		}
	}

}
