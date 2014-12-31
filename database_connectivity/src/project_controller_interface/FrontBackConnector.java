package project_controller_interface;

import project_modals.Course;
import project_modals.Courses;
import project_modals.DataB;
import project_modals.Database;
import project_modals.StudyTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FrontBackConnector {
private Courses course;
private Database db;
private DataB dataB;
public FrontBackConnector()
{
	db=new Database();	
	dataB=new DataB();
}
public List<StudyTable>  getDataAtStartUp(){
	
	
	return new ArrayList<StudyTable>();
}
public void updateTable()
{
	course=new Courses();
	course.values();

}
public  ResultSet  loadStartup() {
	
	return db.getValuesFromDb();
}
public void updatedb(String column, String id, String text)
{
	db.upDateDb(column,  id, text);

}
public String [] createFirstDatas() {
	
	return dataB.createStudyT();
}
public Course createCourseDatas() {
	// TODO Auto-generated method stub
	return dataB.readCourse();
}
public Course getdbCourse() {
	
	return dataB.getPresentCourse();
}
public void updatedb(Course course2) {
	dataB.saveCourse(course2);
	
}

}
