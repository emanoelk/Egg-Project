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
  
  
@WebServlet(urlPatterns={"/Seller"}, loadOnStartup = 1)
public class Seller extends HttpServlet {
    private static final long serialVersionUID = 1L;        
  
    public Seller() {
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
        List<Farm> farm = new ArrayList<Farm>();
        int seller_Id =  (int) (request.getSession().getAttribute("seller_Id"));
         
        System.out.println(seller_Id);
        if((Object)seller_Id == (null)){
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
                     
                    if((int)seller_Id == farms.getFarmer_Id()){
                        farm.add( farms );
                    }
                   }              
                 
                 d.close();              
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
              
            request.setAttribute( "Farms", farm );
            request.getSession().setAttribute("seller_Id", seller_Id);
            request.getRequestDispatcher( "/WEB-INF/Seller.jsp" ).forward(request, response );
 
    }
  
      
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
        doGet(request, response);
    }
  
}