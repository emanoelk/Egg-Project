package store;
 
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
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
        List<Comment> Comments = new ArrayList<Comment>();
        HttpSession session = request.getSession();
         
        Object buyer_Id =  (Object) (request.getSession().getAttribute("buyer_Id"));
         
        Integer id = Integer.parseInt(request.getParameter("id"));
        int fid = 0;
        String fname = null;
        String fdesc = null;
        Double price = (double) 0;
        int inv = 0;
        double totalCost = 0;
     
        boolean factChecker = false;
        
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
            Statement stmt = c.createStatement();
            ResultSet rs2 = stmt.executeQuery( "SELECT * FROM CS3337_Comment Where farmId = "+ id);
              
            while(rs2.next()){
                 Comment entry = new Comment (rs2.getInt( "id" ), rs2.getString("userName"), rs2.getString( "message" ), rs2.getInt("user_Id"), rs2.getInt
                        ("farmId"));
                 Comments.add( entry );
                  
            }            
          ResultSet rs3 = stmt.executeQuery("Select farm, buyId From transaction_history where buyId = " + buyer_Id);
            
            while(rs3.next()){
            	if(fname.equals(rs3.getString("farm")) && (Integer) buyer_Id == rs3.getInt("buyId")){
            		factChecker = true;
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
        request.setAttribute("inv", inv);
        request.setAttribute("fid", fid);
        request.setAttribute("fname", fname);
        request.setAttribute("fdesc", fdesc);
        request.setAttribute("price", price);
        session.setAttribute("totalCost", totalCost);
        request.setAttribute("farmId", id);
        request.setAttribute("itWorks", factChecker);
        request.setAttribute("Comment", Comments);
         
        request.getRequestDispatcher("/WEB-INF/FarmInventory.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        doGet(request, response);
    }
 
 
}