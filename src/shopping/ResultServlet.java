package shopping;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("./shopping/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResultServlet() {
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

		String userId = ((UserBean) session.getAttribute("user")).getId();
		String itemId = (String) request.getAttribute("item_id");
		int itemQuantity = (Integer) request.getAttribute("item_quantity");

		ItemDao dao = new ItemDao();

		try {
			dao.updateStock(itemId, itemQuantity);
			dao.updateHistory(userId, itemId, itemQuantity);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dao.close();
		}

		rd = request.getRequestDispatcher("./jsp/result.jsp");
		rd.forward(request, response);

	}

}
