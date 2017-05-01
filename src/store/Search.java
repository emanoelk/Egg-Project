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
    
/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;
          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    public void init(ServletConfig config) throws ServletException {
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
        request.getRequestDispatcher( "/WEB-INF/Search.jsp" )
            .forward( request, response );
    }
   
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Farm> Farms = new ArrayList<Farm>();
        String search_query = request.getParameter("search");
        ArrayList<String> search_list = match_making.tokenizer(search_query);
           
        Connection c = null;
   
        try
        {
             String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
             String username = "cs3220stu47";
             String password = "*s.##ci.";
   
   
             c = DriverManager.getConnection( url, username, password );
               
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from FarmName;");
               
               
            while( rs.next() )
            {
                Farm temp = new Farm (rs.getInt( "farmId" ), rs.getString( "farmName" ), rs.getString("description"), rs.getInt("inventory"), rs.getInt("Farmer_Id"));
                ArrayList<String> target_list = match_making.tokenizer(temp.getfarmName());
                if(match_making.match_check(search_list, target_list))
                    Farms.add(temp);
            }
                   
            c.close();
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
   
           
        request.setAttribute("farms", Farms);
        request.getRequestDispatcher( "/WEB-INF/Search.jsp" )
        .forward( request, response );
    }
   
}