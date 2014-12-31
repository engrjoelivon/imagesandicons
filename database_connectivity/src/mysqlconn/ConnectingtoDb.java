package mysqlconn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectingtoDb {
	private static Connection con;

public static Connection doConnection(){
   //step2   Register the jdbc to memory////
try {
	Class.forName("com.mysql.jdbc.Driver");
	
	
	
} catch (ClassNotFoundException e) {

	System.out.println("could not regster driver");
	
}
  ////Step 3 exterblish a connection to jdbc,the get connection method is overloaded//////////////
try {
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "nawoitomo27");
	
	
	con.createStatement();
	
} catch (SQLException e) {

	e.printStackTrace();
}

System.out.println("connection succesful");
/////step4////////////



return con;
}
	


}
