package project_modals;
import java.sql.*;
public class Database {
private Connection conn;

private Courses course;
private String values [][];

private PreparedStatement pstmt;
private final String DB_REG="com.mysql.jdbc.Driver";
private final String USER="root";
private final String PASS="nawoitomo27";
String sql;

public void insertValuestoTable()
{
	////register db////
try {
	Class.forName(DB_REG);
} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
}
  /////connect to db/////
try {
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/example", USER, PASS);
} catch (SQLException e) {
	
	e.printStackTrace();
}
////write to db//////
try {
	int count=1;
	 sql="insert into studyguide(id,Monday,tuesday,wednesday,thursday,friday,saturday,sunday)values(?,?,?,?,?,?,?,?)";
	course=new Courses();
	values=course.values();
	pstmt=conn.prepareStatement(sql);
	for(String [] a:values)
	{  for(String ab:a) 
	{   pstmt.setString(count++, ab);                 }    break;                           }
	
	pstmt.executeUpdate();
	
	
} catch (SQLException e) {
	
	e.printStackTrace();
}

}
////select datas from database/////
   public ResultSet  getValuesFromDb()
{
	ResultSet rSet=null;   
	   try {
	Class.forName(DB_REG);
} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
}
  /////connect to db/////
try {
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/example", USER, PASS);
} catch (SQLException e) {
	
	e.printStackTrace();
}
sql="select * from studyguide ";
try {
	pstmt=conn.prepareStatement(sql);
	rSet= pstmt.executeQuery();
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return rSet;
	

}
   //update a db///
public void upDateDb(String column, String id, String text)
{
	try {
		Class.forName(DB_REG);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	  /////connect to db/////
	try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/example", USER, PASS);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	sql="UPDATE studyguide SET "+ column +" = ? where id = ?";
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, text);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    

public static void main(String [] args)
{
	
new Database().getValuesFromDb();

}
}
