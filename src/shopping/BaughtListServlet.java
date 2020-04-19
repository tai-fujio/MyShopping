package shopping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shopping/BaughtListServlet")
public class BaughtListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaughtListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		if (session.getAttribute("isLogged") == "true") {
			Item item = new Item();
			UserBean userbean = (UserBean) session.getAttribute("user");
			ArrayList<HistoryBean> historybean = item.getHistoryData(userbean.getId());
			request.setAttribute("history", historybean);
			rd = request.getRequestDispatcher("./jsp/history.jsp");
			rd.forward(request, response);
		}
	}

}
