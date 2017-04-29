package store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	public AddCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));
		String s = request.getSession().getId();

		HttpSession session = request.getSession();
	//	Integer crt = (Integer) request.getSession().getAttribute("cart");
	//	int cart = crt;
		boolean alreadyinCart = false;
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
			String username = "cs3220stu47";
			String password = "*s.##ci.";
			

				String sql = "insert into EggCart (user_id, item_id, quantity) values (?, ?, ?)";
	
				c = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
				pstmt.setString(1, s);
				pstmt.setInt(2, id);
				pstmt.setInt(3, quantity);
				pstmt.executeUpdate();
	
				Statement stmt = c.createStatement();
				ResultSet rs = stmt
						.executeQuery("select count(quantity) as cart from EggCart where user_id = '" + s + "'");
				while (rs.next()) {
	//				cart = rs.getInt("cart");
				}
			}catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

	//	session.setAttribute("cart", cart);
		response.sendRedirect("EggCart");

	}

}
