package project_modals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataB {
private Time time;
private String [] setTime;
private Course presentCourse;;
public DataB(){
	
}
public static void main(String [] args)
{  new DataB().saveCourse(new DataB().formatTable());
	new DataB().readCourse();

}
public 	String [] createStudyT()
{ int count=0;
	setTime=new String[12];	
	setTime[count++]= " 7.00-9.00";
	setTime[count++]= " 9.00-11.00";
	setTime[count++]= " 11.00-1.00";
	setTime[count++]= " 1.00-3.00";
	setTime[count++]= " 3.00-5.00";
	setTime[count++]= " 5.00-7.00";
	setTime[count++]= " 7.00-9.00";
	setTime[count++]= " 11.00-1.00";
	setTime[count++]= " 1.00-3.00";
	setTime[count++]= " 3.00-5.00";
	setTime[count++]= " 5.00-7.00";
	
	setTime(new Time(setTime))	;
return setTime;
}

public 	Course formatTable()
{
	Course presentCourse=new Course(new Monday(new String[11]), new Tuesday(new String[11]), new Wednesday(new String[11]), 
			new Thursday(new String[11]), new Friday(new String[11]), new Saturday(new String[11]), new Sunday(new String[11]));
return presentCourse;
}


public Time getTime() {
	return time;
}
public void setTime(Time time) {
	this.time = time;
}
public Course getPresentCourse() {
	
	return presentCourse;
}

public void saveCourse(Course course)
{
	try {
		FileOutputStream fos=new FileOutputStream("../database_connectivity/SavedCourse/mycourse.txt");
		try {
			
			@SuppressWarnings("resource")
			ObjectOutputStream ooS=new ObjectOutputStream(fos);
			
			ooS.writeObject(course);
			ooS.flush();
			System.out.println("files created");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}}

public Course readCourse() 
{
	Course course=null;
	try {
		@SuppressWarnings("resource")
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("../database_connectivity/SavedCourse/mycourse.txt"));
		
		 course=	(Course) ois.readObject();
		
			
	
	}
	   catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return course;
	






}}
