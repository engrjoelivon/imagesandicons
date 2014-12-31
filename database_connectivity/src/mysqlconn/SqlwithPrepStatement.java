package mysqlconn;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class SqlwithPrepStatement {
private static PreparedStatement pstmt;
private static String sql;
private static int count=1;
private static Connection conn;

public static void createTable(Connection con) throws ClassNotFoundException, SQLException{ 
	//making a prepared statement object//
	sql="create table country(id INT primary key,country VARCHAR(45) not null,capital VARCHAR(45) not null)";
	pstmt=con.prepareStatement(sql);
    pstmt.execute();
    closeTable();
}
public static void insert2Table(Connection con) throws ClassNotFoundException, SQLException{ 
conn=con;
	
sql="insert into country  (id,country,capital) values(?,?,?)";//the question mark represent parameters that should be passed in.
pstmt=con.prepareStatement(sql)	;
pstmt.setInt(count++, 3); //count represent the question mark index eg count here being the first will represent id 
pstmt.setString(count++,"canada");
pstmt.setString(count++,"Toronto");
pstmt.executeUpdate();
closeTable();//this method closes the db and the statement

}

private static void closeTable() throws SQLException
{  if(conn != null)
{
	conn.close();
	pstmt.close();
  System.out.println("tables succesfully closed");
}
	
}

}
