package store;

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
   /* 
    private String getUsersName( HttpServletRequest request ){
		
		Cookie[] cookies = request.getCookies();
		
		// Are there any cookies?
		if ( cookies != null )
			for (Cookie cookie : cookies)
				if ( cookie.getName().equals("username") )
					return cookie.getValue();
			
		
		return null;
	}*/
    
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
                  
                 User user = new User (rs.getInt( "user_id" ), rs.getString( "userName" ), rs.getString( "password" ));
                 Users.add( user );
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
		
		
         request.setAttribute( "Users", Users );
         System.out.println("We got here.");
         request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getServletContext().getAttribute("Users");

		for(User account:users){
			if(account.getUserName().equals(username) && account.getPassword().equals(password)){
		         response.sendRedirect( "Home" );
		         return;
				}
		}
		
		System.out.println("We are here.");
        request.getRequestDispatcher( "/Home" ).forward(request, response );

	}

}




