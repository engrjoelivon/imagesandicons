package project_modals;

public class Time {
	private String [] timeofDay=new String[11];
	public Time( String [] timeofDays)
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
