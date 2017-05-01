package store;
 
import java.io.IOException;
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
  
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
    private static final long serialVersionUID = 1L;
         
    public AddComment() {
        super();
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object buyer_Id =  (Object) (request.getSession().getAttribute("buyer_Id"));
        String message = request.getParameter("message");
        Object farmId =  (Object) (request.getParameter("farmId"));
        String userName;
        String temp ="";
              
            if(buyer_Id == (null)){
              response.sendRedirect( "./Login" );
                return;
                }
              Connection c = null;
                try
                {
                    String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
                    String username = "cs3220stu47";
                    String password = "*s.##ci.";
  
                    c = DriverManager.getConnection( url, username, password );
                     
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery( "SELECT userName FROM userAccount where user_Id = " + buyer_Id);
                      
                    while(rs.next()){
                        temp = rs.getString("userName");
                    }
                    userName = temp;
                      
                    String sql = "Insert INTO CS3337_Comment set userName = ?, message = ?, user_Id = ?, farmId = ?";
                    PreparedStatement pstmt = c.prepareStatement( sql );
                          
                    pstmt.setString( 1, userName );
                    pstmt.setString( 2, message );
                    pstmt.setInt( 3, (Integer) buyer_Id );
                    pstmt.setString( 4, (String) farmId );
                      
                    pstmt.executeUpdate();
                }
                catch( SQLException e )
                {
                    throw new ServletException( e );
                }
                finally
                {
                    try
                    {
                        if( c != null ) c.close();
                    }
                    catch( SQLException e )
                    {
                        throw new ServletException( e );
                    }
                }
          
        response.sendRedirect("./FarmInventory?id="+farmId);
    }
  
}