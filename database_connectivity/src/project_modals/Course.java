package project_modals;

import java.io.Serializable;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
private Monday mon;
private Tuesday tues;
private Wednesday wed;
private Thursday thus;
private Friday fri;
private Saturday sat;
private Sunday sun;

public Course(Monday mon,Tuesday tues,Wednesday wed,Thursday thus,Friday fri,Saturday sat,Sunday sun)
{
	this.mon=mon;
	this.tues=tues;
	this.wed=wed;
	this.thus=thus;
	this.fri=fri;
	this.sat=sat;
	this.sun=sun;

}

public Monday getMon() {
	return mon;
}

public void setMon(Monday mon) {
	this.mon = mon;
}

public Tuesday getTues() {
	return tues;
}

public void setTues(Tuesday tues) {
	this.tues = tues;
}

public Wednesday getWed() {
	return wed;
}

public void setWed(Wednesday wed) {
	this.wed = wed;
}

public Friday getFri() {
	return fri;
}

public void setFri(Friday fri) {
	this.fri = fri;
}

public Thursday getThus() {
	return thus;
}

public void setThus(Thursday thus) {
	this.thus = thus;
}

public Saturday getSat() {
	return sat;
}

public void setSat(Saturday sat) {
	this.sat = sat;
}

public Sunday getSun() {
	return sun;
}

public void setSun(Sunday sun) {
	this.sun = sun;
}

}
