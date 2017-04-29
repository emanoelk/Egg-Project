package Store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Store.ShoppingCartEntry;

/**
 * Servlet implementation class EggCheckout
 */
@WebServlet("/EggCheckout")
public class EggCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EggCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<EggCartEntry> eggcart = new ArrayList<EggCartEntry>();
		HttpSession session = request.getSession();
		Double totalCost = (Double) request.getSession().getAttribute("totalCost");
		String s = request.getSession().getId();
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
			String username = "cs3220stu47";
			String password = "*s.##ci.";

			String sql = "SELECT e.FarmName as name, e.Price as price, sum(p.quantity) as quantity "
					+ "FROM FarmName e, EggCart p WHERE p.user_id = ? and item_id = e.farmId GROUP BY item_id";;
 
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, s);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				EggCartEntry item = new EggCartEntry(rs.getString("name"), rs.getDouble("price"),
						rs.getInt("quantity"));
				eggcart.add(item);
			}

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		session.setAttribute("totalCost", totalCost);
		session.setAttribute("eggcart", eggcart);

		request.getRequestDispatcher("/WEB-INF/EggCheckout.jsp").forward(request, response);
	}
}