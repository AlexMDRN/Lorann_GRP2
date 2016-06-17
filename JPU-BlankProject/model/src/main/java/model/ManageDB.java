package model;

//The required package in order to use such databases
import java.sql.*;

public class ManageDB{
	
	
	public void manageDataBase(){
 
		   final String url = "jdbc:mysql://localhost/lorannmap?autoReconnect=true&useSSL=false";
		   final String user = "root";
		   final String password = "";
		   Connection connection = null;
		   
		   try{
		      //Be sure that our Driver is placed properly in our Path
		      Class.forName("com.mysql.jdbc.Driver");

		      //Create the link between our application and database
		      System.out.println("Connecting Lorann code to DataBase...");
		      connection = DriverManager.getConnection(url, user, password);

		      //Prepare the statement
		      System.out.println("Creating statement...");
		      CallableStatement stmt = connection.prepareCall("{call get_map_data(?, ?)}");
		      

		      //Set the parameters
		      stmt.setInt(1, 0);
		      stmt.registerOutParameter(2, Types.VARCHAR);
		      
		      //Actually execute the statement, thus calling it in our DataBase
		      stmt.execute();
		      
		      //Stock the result of our procedure in a java variable
		      String theMapString = stmt.getString(2);

		      System.out.println("Here's the map data : " + theMapString);
		      
		      //Clean-up our DataBase environment to ensure future uses will run smoothly
		      stmt.close();
		      connection.close();
		      
		   }catch(SQLException sqle){
		      //Handle errors from the Driver position
		      sqle.printStackTrace();
		   }catch(Exception e){
		      //Handle errors from Class.forName initialisation
		      e.printStackTrace();
		   }finally{
		      //Final clean-up
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException sqle){
		         sqle.printStackTrace();
		      }
		   }
		   System.out.println("Goodbye!");
	}
}
