package shopping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShoppingListServlet")
public class ShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item = new Item();
		ArrayList<ItemBean> itembeans = item.getItemList();
		request.setAttribute("itemList", itembeans);
		RequestDispatcher rd = request.getRequestDispatcher("./jsp/itemList.jsp");
		rd.forward(request, response);
	}
}
