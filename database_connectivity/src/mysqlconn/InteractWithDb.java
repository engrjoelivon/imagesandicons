package mysqlconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class InteractWithDb {
private static Statement stmt;
public static void validateTable(Connection con) throws SQLException
{
/*
 * the execute method uses a connecion object statement to call the execute method,the first example returns a boolean,validating
 * if a result set can be returned
 * 
 * */

stmt=con.createStatement();	
if(stmt.execute("SELECT * FROM Employees"))
	{System.out.println("pure");}
}
public static ResultSet getDataTable(Connection con) throws SQLException{
	/*
	 * the executequery is called by a statement this returns rows from the table 
	 * 
	 * */
ResultSet res=stmt.executeQuery("SELECT * FROM Employees");
return res;
}
public static int  setDataTable(Connection con) throws SQLException
{
	stmt=con.createStatement();
	int res=stmt.executeUpdate("UPDATE Employees set age=100 WHERE id=5");

return res;
}
         /////Using Prepared Statement//////////
public static void getDataWPrepStatment(Connection con) throws SQLException{
	PreparedStatement pstmt=null;
	String sql="UPDATE Employees set age=? WHERE id=?";
	pstmt=con.prepareStatement(sql);
	pstmt.setInt(1, 100);
	pstmt.setInt(2, 200);
	
	int rows = pstmt.executeUpdate();
    System.out.println(rows);
}



}