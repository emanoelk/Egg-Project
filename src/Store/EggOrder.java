package store;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EggOrder
 */
@WebServlet("/EggOrder")
public class EggOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EggOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("error").toString().equals("Please Enter a Valid Entry")){
			response.sendRedirect("EggCheckout");
		}
		else{
		request.getSession().setAttribute("cart", null);
		
		// NEED TO DISPLAY ORDER COMPLETE AND GENERATE A RANODM ORDER NUMBER
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(request.getAttribute("autoID").toString().getBytes());

	        byte byteData[] = md.digest();

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        String orderid = sb.toString();
	        request.setAttribute("orderID", orderid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.getRequestDispatcher("/WEB-INF/Order.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String error = "";
		
		if (email == null || email.equals("") || fname == null || fname.equals("") || lname == null || lname.equals("")) {
			error = "Please Enter a Valid Entry";
		}
		else{
			// Subtract items purchased and move items to transaction history sql
			String s = request.getSession().getId();

			Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
				String username = "cs3220stu47";
				String password = "*s.##ci.";
				// Check if Items quantities are still in stock
				
				//If Items are in stock Update to store to subtract bought items 
				//And put the purchase into transaction history
				String sql = "SELECT item_id, sum(quantity) as quantity FROM EggCart WHERE user_id = ? GROUP BY item_id";
	 
				
				c = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, s);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					int itemid = rs.getInt("item_id");
					int quantity = rs.getInt("quantity");
					
					String sql2 = "SELECT FarmName, inventory, Price FROM FarmName WHERE farmId = ?";
					 
					
					PreparedStatement pstmt2 = c.prepareStatement(sql2);
					pstmt2.setInt(1, itemid);
					ResultSet rs2 = pstmt2.executeQuery();
					
					while (rs2.next()) {
						int storeStock = rs2.getInt("inventory");
						String farmN = rs2.getString("FarmName");
						double price= rs2.getDouble("price");
						
						String sql3 = "UPDATE FarmName SET inventory = ? WHERE farmId = ?";
						 
						
						PreparedStatement pstmt3 = c.prepareStatement(sql3);
						pstmt3.setInt(1, (storeStock - quantity));
						pstmt3.setInt(2, itemid);
						pstmt3.executeUpdate();
						
						// Now the items have been subtracted from the ITEMS table
						// Next log transaction history and clear shopping cart
						// Transaction History needs :
						// fname (string), lname (string), email (string), itemname (string)
						// quantity (int), price (double) (price is individual price)
				
						String transsql = "INSERT INTO transaction_history (fname, lname, email, farm, quantity, price)"
								+ " values (?, ?, ?, ?, ?, ?)";
						
						PreparedStatement transpstmt = (PreparedStatement) c.prepareStatement(transsql, Statement.RETURN_GENERATED_KEYS);
						transpstmt.setString(1, fname);
						transpstmt.setString(2, lname);
						transpstmt.setString(3, email);
						transpstmt.setString(4, farmN);
						transpstmt.setInt(5, quantity);
						transpstmt.setDouble(6, price);
						transpstmt.executeUpdate();
						ResultSet tableKeys = transpstmt.getGeneratedKeys();
						tableKeys.next();
						int autoID = tableKeys.getInt(1);
						request.setAttribute("autoID", autoID);
					}
				}
				String deletesql = "DELETE FROM EggCart WHERE user_id = ?";
				PreparedStatement deletepstmt = (PreparedStatement) c.prepareStatement(deletesql);
				deletepstmt.setString(1, s);
				deletepstmt.executeUpdate();
				
				//Else if the items are not in stock anymore make an error message and send them back to store?
				
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
		}
		session.setAttribute("error", error);
		
		doGet(request, response);

	}
}