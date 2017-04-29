package Store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
 
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		//access user database
		List<User> Users = new ArrayList<User>();
			 
	         Connection d = null;
	       
	         try
	         {
	             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
	             //Database info for sql account
	             String username = "cs3220stu47";
	             String password = "*s.##ci.";
	
	             d = DriverManager.getConnection( url, username, password );
	              
	             Statement stmt = d.createStatement();
	             ResultSet rs = stmt.executeQuery( "SELECT * FROM userAccount" );
	
	             while( rs.next() )
	             {
	                 User users = new User (rs.getInt( "user_id" ), rs.getString( "userName" ), rs.getString( "password" ), rs.getString("type"));
	                 Users.add( users );
	             }		                                  
	         }
	         catch( SQLException e )
	         {
	             throw new ServletException( e );
	         }
	         finally
	         {
	             try
	             {
	                 if( d != null ) d.close();
	             }
	             catch( SQLException e )
	             {
	                 throw new ServletException( e );
	             }
	         }
						
		for(User account:Users){
			if(account.getUserName().equals(user) && account.getPassword().equals(pass)){
				if(account.getType().equals("Buyer")){
				    request.getSession().setAttribute("buyer_Id", account.getUser_id());
					response.sendRedirect( "./HomeUser" );
			        return;
				}
				if(account.getType().equals("Seller")){
					request.getSession().setAttribute("seller_Id", account.getUser_id());
					response.sendRedirect( "./Seller" );
					return;
			        
				}
			}			
		}
	}

}




