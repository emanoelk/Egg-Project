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
   
   
@WebServlet("/HomeUser")
public class HomeUser extends HttpServlet {
    private static final long serialVersionUID = 1L;        
   
    public HomeUser() {
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
        List<Farm> Farms = new ArrayList<Farm>();
        List<Follow> Follow = new ArrayList<Follow>();
  
        Object buyer_Id =  (Object) (request.getSession().getAttribute("buyer_Id"));
          
            if(buyer_Id == (null)){
              response.sendRedirect( "./Login" );
                return;
                }
           Connection d = null;
            
            try
            {
                String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
                //Database info for sql account
                String username = "cs3220stu47";
                String password = "*s.##ci.";
   
                d = DriverManager.getConnection( url, username, password );
                   
                Statement stmt = d.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FarmName");
                  
                while( rs.next() )
                {
                       
                    Farm farms = new Farm (rs.getInt( "farmId" ), rs.getString( "farmName" ), rs.getString("description"), rs.getInt
                            ("inventory"), rs.getInt("Farmer_Id"));
                    Farms.add( farms );
                }              
                  
                ResultSet rs2 = stmt.executeQuery( "SELECT * FROM Follow where user_Id = "+ buyer_Id);
  
                while( rs2.next() )
                {
                       
                    Follow farms = new Follow (rs2.getInt( "id" ), rs2.getInt( "farmId" ), rs2.getString( "farmName" ), rs2.getString
                            ("description"), rs2.getInt("user_Id"));
                      
                    List<Object> toRemove = new ArrayList<Object>();
                    for(Farm a: Farms){
                        if(farms.getfarmName().equals(a.getfarmName())){
                            toRemove.add(a);                        
                        }
                    }
                    Farms.removeAll(toRemove);
                        Follow.add( farms );
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
  
            request.setAttribute( "Follow", Follow ); 
            request.setAttribute("Farm", Farms);
            request.setAttribute("buyer_Id", buyer_Id);
            request.getRequestDispatcher( "/WEB-INF/HomeUser.jsp" ).forward(request, response );
  
    }
   
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
        doGet(request, response);
    }
   
}