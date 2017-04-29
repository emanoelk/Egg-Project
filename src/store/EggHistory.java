package store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Store.TranHistoryEntry;

/**
 * Servlet implementation class EggHistory
 */
@WebServlet("/EggHistory")
public class EggHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EggHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EggHistoryEntry> eggHistory = new ArrayList<EggHistoryEntry>();

		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
			String username = "cs3220stu47";
			String password = "*s.##ci.";

			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select concat( fname, ' ', lname) as name, email, farm, quantity, price from transaction_history;");

			while (rs.next()) {
				EggHistoryEntry history = new EggHistoryEntry(rs.getString("name"), rs.getString("email"),
						rs.getString("farm"), rs.getDouble("price"), rs.getInt("quantity"));

				eggHistory.add(history);
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
		request.setAttribute("eggHistory", eggHistory);

		request.getRequestDispatcher("/WEB-INF/EggHistory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
