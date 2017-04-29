package Store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Store.DetailsEntry;
import Store.StoreEntry;
import reddit.ListEntry;

/**
 * Servlet implementation class FarmInventory
 */
@WebServlet("/FarmInventory")
public class FarmInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	public FarmInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<FarmInventoryEntry> inventory = new ArrayList<FarmInventoryEntry>();
		
		
		String s = request.getParameter("farmName");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		int fid = 0;
		String fname = null;
		String fdesc = null;
		Double price = (double) 0;
		int inv = 0;
		double totalCost = 0;
	
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
			String username = "cs3220stu47";
			String password = "*s.##ci.";

			c = DriverManager.getConnection(url, username, password);
				
			String sql = "select * from FarmName where farmId = ?;";

			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
					
					fid = rs.getInt("farmId");
					fname = rs.getString( "farmName" );
					fdesc = rs.getString("description");
					price = rs.getDouble("Price");
					inv = rs.getInt("inventory");
				
				
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
		request.setAttribute("inv", inv);
		request.setAttribute("fid", fid);
		request.setAttribute("fname", fname);
		request.setAttribute("fdesc", fdesc);
		request.setAttribute("price", price);
		session.setAttribute("totalCost", totalCost);
		
		request.getRequestDispatcher("/WEB-INF/FarmInventory.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
