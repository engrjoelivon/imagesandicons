package project_modals;

import java.io.Serializable;

public class Monday implements Serializable {
private String [] timeofDay=new String[11];
public Monday( String [] timeofDays)
{
	this.setTimeofDays(timeofDays);
}
public String [] getTimeofDays() {
	return timeofDay;
}
public void setTimeofDays(String [] timeofDays) {
	this.timeofDay = timeofDays;
}
public  String toString()
{
	
return "It is monday";
}

}
