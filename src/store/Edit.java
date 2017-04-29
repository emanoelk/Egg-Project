package store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Farm getEntry( Integer Farmer_Id ) throws ServletException
    {
    	
        Farm entry = null;
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
            String username = "cs3220stu47";
            String password = "*s.##ci.";

            String sql = "select * from FarmName where farmer_Id = ?";

            c = DriverManager.getConnection( url, username, password );
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            
            pstmt.setInt( 1, Farmer_Id );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
            	 entry = new Farm (rs.getInt( "farmId" ), rs.getString( "farmName" ), rs.getString("description"), rs.getInt
                 		("inventory"), rs.getInt("Farmer_Id"));
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
        return entry;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // get the entry to be edited
        int Farmer_Id =  Integer.parseInt(request.getParameter("seller_Id"));
        Farm entry = getEntry( Farmer_Id );
        
        // pass the entry to jsp using request scope
        request.setAttribute( "Farm", entry );
       
        request.getRequestDispatcher( "/WEB-INF/Edit.jsp" ).forward(request, response );
        System.out.println("I get here.");
    }
   

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
        System.out.println("I get here too?.");
        // get the entry to be edited
        int Farmer_Id = Integer.parseInt( request.getParameter( "id" ) );
        String FarmName = request.getParameter( "farmName" );
        String description = request.getParameter( "description" );
        Integer inventory = Integer.valueOf(request.getParameter( "inventory" ));
        
        

        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu47";
            String username = "cs3220stu47";
            String password = "*s.##ci.";

            String sql = "update FarmName set FarmName = ?, description = ?, inventory = ? where Farmer_Id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, FarmName );
            pstmt.setString( 2, description );
            pstmt.setInt( 3, inventory );
            pstmt.setInt( 4, Farmer_Id );
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

        response.sendRedirect( "Seller" );
    }

}
