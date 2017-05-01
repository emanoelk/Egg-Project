package store;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
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
        List<EggBuyerEntry> eggbuyer = new ArrayList<EggBuyerEntry>();
 
        Connection c = null;
        int id= Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        try {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
            String username = "cs3220stu47";
            String password = "*s.##ci.";
 
            c = DriverManager.getConnection(url, username, password);
 
          //  Statement stmt = c.createStatement();
            if(type.equals("seller")){
                String sql = 
                    "select concat( e.fname, ' ', e.lname) as name, e.email, e.quantity, e.price "
                    + "FROM transaction_history e, FarmName f WHERE f.Farmer_Id = ? and f.FarmName = e.farm;";
                PreparedStatement pstmt = c.prepareStatement(sql);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                EggHistoryEntry seller = new EggHistoryEntry(rs.getString("name"), rs.getString("email"),
                     rs.getDouble("price"), rs.getInt("quantity"));
 
                eggHistory.add(seller);
            }
            }if(type.equals("buyer")){
                String sql = "select a.farm, a.quantity, a.price FROM transaction_history a, userAccount b "
                        + "Where b.user_id = ? AND b.user_id = a.buyId ;";
                 
                PreparedStatement pstmt = c.prepareStatement(sql);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                 
                while (rs.next()) {
                    EggBuyerEntry buyer = new EggBuyerEntry(rs.getString("farm"), rs.getDouble("price"), rs.getInt("quantity"));
 
                    eggbuyer.add(buyer);
     
                }
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
        request.setAttribute("eggbuyer", eggbuyer);
     
         
         
         
         
 
        request.getRequestDispatcher("/WEB-INF/EggHistory.jsp").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        doGet(request, response);
 
    }
 
}