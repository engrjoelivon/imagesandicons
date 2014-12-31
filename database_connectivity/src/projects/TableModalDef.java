package projects;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import project_modals.Course;
import project_modals.Courses;


public class TableModalDef extends AbstractTableModel {
	
	
	
	private String values[][]=new String[12][8];
	private String[] colNames = {"TIME","MONDAY",  "TUESDAY", "WEDNESDAY","THUSDAY ", "FRIDAY","SATUDAY","SUNDAY"};

	private String [] tableKeys;
	
	private Course courses;
	private static final long serialVersionUID = 1L;
public TableModalDef(ResultSet resSet2)
{int count=0;
 int outCount=0;
	try {
		while(resSet2.next())
		{   
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			values[outCount][count]=	resSet2.getString(++count);
			outCount++; count=0;
			
		}
		resSet2.close();
	} catch (SQLException e) {
		
		
	}
	
}
	

public TableModalDef(String[] tableKeys, Course courses) {
	this.tableKeys=tableKeys;
	this.courses=courses;
}

public String getColumnName(int column) {
		
		return colNames[column];
	}


	@Override
	public int getRowCount() {
		//tableKeys.length-1;
		//System.out.print(tableKeys.length);
		return tableKeys.length-1 ;
	}

	@Override
	public int getColumnCount() {
		
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
		
		int a=0;
		
		switch(columnIndex)
		{
		
		case 0:{  return tableKeys[rowIndex]  ;  }
		case 1:{ a++;      String mon []=   courses.getMon().getTimeofDays(); 
		return mon[rowIndex];
		}
		case 2:{  a++; String tues []=   courses.getTues().getTimeofDays(); 
		return tues[rowIndex];}
		case 3:{ a++; String wed []=   courses.getWed().getTimeofDays(); 
		return wed[rowIndex];}
		case 4:{ a++; String thur []=   courses.getThus().getTimeofDays(); 
		return thur[rowIndex];}
		
		case 5:{ a++;  String friday []=   courses.getFri().getTimeofDays(); 
		return friday[rowIndex];}
		case 6:{ a++; String sat []=   courses.getSat().getTimeofDays(); 
		return sat[rowIndex];}
		case 7:{ a++; String sun []=   courses.getSun().getTimeofDays(); 
		return sun[rowIndex]; }
		
		
		}
		
		
		/*
		 * String []val=values[rowIndex];
		
		int a=0;
		switch(columnIndex)
		{
		case 0:{ a++; return val[columnIndex];}
		case 1:{ a++; return val[columnIndex];}
		case 2:{ a++; return val[columnIndex];}
		case 3:{ a++; return val[columnIndex];}
		case 4:{ a++; return val[columnIndex];}
		
		case 5:{ a++; return val[columnIndex];}
		case 6:{ a++; return val[columnIndex];}
		case 7:{ a++; return val[columnIndex];}
		
		 
		}
		*/
		return null;
	}
    

	public void setTableCourses(Course course) 
	{
		this.courses=course;
		
	}
public String getRow4Update(int row)
{
	
return "";
}
public String getCol4Update(int column)
{
	
	return "";
}
    
}
