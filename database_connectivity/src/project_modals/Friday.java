package project_modals;

import java.io.Serializable;

public class Friday implements Serializable {
	private String [] timeofDay=new String[11];
	public Friday( String [] timeofDays)
	{
		this.setTimeofDays(timeofDays);
	}
	public String [] getTimeofDays() {
		return timeofDay;
	}
	public void setTimeofDays(String [] timeofDays) {
		this.timeofDay = timeofDays;
	}

}
