package shopping;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmServlet() {
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
		Enumeration<String> params = request.getParameterNames();
		String param = "";
		String target = "";
		String targetId = "";
		String quantity = "";

		while (params.hasMoreElements()) {
			param = params.nextElement();
			System.out.println(param);
			if (param.matches(".*submit")) {
				targetId = param.replace("submit", "");
				target = param.replace("submit", "list");
				break;
			}
		}
		quantity = request.getParameter(target);
		Item item = new Item();
		ItemBean itembean = item.getItemId(targetId);

		request.setAttribute("item", itembean);
		request.setAttribute("quantity", quantity);

		rd = request.getRequestDispatcher("./jsp/result.jsp");
		rd.forward(request, response);
	}

}
