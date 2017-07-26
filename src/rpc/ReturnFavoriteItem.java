package rpc;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;

/**
 * Servlet implementation class ReturnFavorateItem
 */
@WebServlet("/returnItem")
public class ReturnFavoriteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBConnection conn = DBConnectionFactory.getDBConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnFavoriteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userId = request.getParameter("user_id");
		Set<Item> res = conn.getFavoriteItems(userId);
		for (Item item : res) {
			System.out.println(item.getName());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
