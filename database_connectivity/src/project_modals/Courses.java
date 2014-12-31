package project_modals;

public class Courses {
public static String StudyGuide[][];
public int outer=0;
public int inner=0;
public Courses()
{
	String course[][]=new String[12][8];
	for(String value[]:course)
	{
	 
	 for(String a:value)
	 {
		 course[outer][inner]="  ";
		 
		inner++;
		if(inner==8)
		{inner=0;  break;}
	 }	
	 outer++;
	 if(outer==12)
		{break;}
	}
StudyGuide=course;	
}
public void setCourses(int outer ,int inner,String val)
{
	
	StudyGuide[outer][inner]=val;
}
public static void main(String [] args)
{
Courses co= new Courses();
co.setCourses(5, 3, "new Value");
 //System.out.println(StudyGuide[11][7] + "size is "+ StudyGuide.length);
 System.out.println(co.values()[5][3]);
}
public int getSize()
{
	
return StudyGuide.length;
}
public String[][] values()
{
	

return StudyGuide;
}
}
