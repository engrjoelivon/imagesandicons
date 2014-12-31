package mysqlconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass {
public static Connection con;
private static ResultSet res;

public static  void main(String []args)
{
	con=ConnectingtoDb.doConnection();
	//DatafromTable();
	//data2table();
	//usingprepStat();
	try {
		//SqlwithPrepStatement.createTable(con);
		SqlwithPrepStatement.insert2Table(con);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
public static void DatafromTable()
{
	try {
		InteractWithDb.validateTable(con);
		res=InteractWithDb.getDataTable(con);
		while(res.next())
		{
			
			System.out.print(res.getInt("id")+" ");
			System.out.print(res.getInt("age")+" ");
			System.out.print(res.getString("first")+" ");
			System.out.print(res.getString("last")+" ");
			System.out.println("");
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
      finally{
    	  
    	  try {
			
			res.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
      }
}
public static void data2table()
{
	try {
	System.out.println(	InteractWithDb.setDataTable(con));
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally{
  	  
  	  try {
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
    }
}
public static void usingprepStat(){
	try {
		InteractWithDb.getDataWPrepStatment(con);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}}
