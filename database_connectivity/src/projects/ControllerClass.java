package projects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.prefs.Preferences;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import project_controller_interface.FrontBackConnector;
import project_modals.Course;
import project_modals.Friday;
import project_modals.Monday;
import project_modals.Saturday;
import project_modals.Sunday;
import project_modals.Thursday;
import project_modals.Tuesday;
import project_modals.Wednesday;

public class ControllerClass extends JFrame {

	private static final long serialVersionUID = -4389617745474362799L;
public FrontBackConnector fBC;
public ResultSet resSet;
private TableHolder tableHolder;
private PrefSetting prefSetting;
private Course course;
private Preferences pref;
	public static void main(String[] args) {
		new ControllerClass();
	}

	
public ControllerClass() {
		
		prefSetting=new PrefSetting(this);
		pref=Preferences.userRoot().node(getClass().getName());
		prefSetting.checkPrefs();
		System.out.println("user " +pref.get("user", "username") +  " password "+ pref.get("pass", "password") );
		prefSetting.setPrefs(new prefsListener() {
			
			@Override
			public void setPreferences(String username, String password, String Email) {
				pref.put("user", username);
				pref.put("pass", password);
				pref.put("mail", Email);
				
				System.out.println("listener " +pref.get("user", "hello"));
			}
		});
		fBC=new FrontBackConnector();
		fBC.createFirstDatas();
		course=fBC.createCourseDatas();
		tableHolder=new TableHolder(fBC.createFirstDatas(),fBC.createCourseDatas());
		
		tableHolder.setUpdate(new UpdateInterface() {
			@Override
			public Course updateTable(int rowP, int colP, String text) {
				String  [] time=null;
				if(colP==1) 
					{time=course.getMon().getTimeofDays(); time[rowP]=text;course.setMon(new Monday(time));}
				else if(colP==2)
                 {time=course.getTues().getTimeofDays(); time[rowP]=text;course.setTues(new Tuesday(time));}
				else if(colP==3) 
					{time=course.getWed().getTimeofDays();  time[rowP]=text;  course.setWed(new Wednesday(time));}
				else if(colP==4) 
				{	time=course.getThus().getTimeofDays();  time[rowP]=text; course.setThus(new Thursday(time));}
				else if(colP==5)
                  {time=course.getFri().getTimeofDays();  time[rowP]=text;course.setFri(new Friday(time));}
				else if(colP==6)
				 {time=course.getSat().getTimeofDays();  time[rowP]=text;course.setSat(new Saturday(time));}
				else if(colP==7) 
				 {time=course.getSun().getTimeofDays();  time[rowP]=text;course.setSun(new Sunday(time));}
				
				fBC.updatedb(course);
				 
				
				return course;
			}
		});
		setTitle("StudyGuide");
/////instead of setting the defaultcloseoperation to close on exit i used do nothing,i overrided the windowListener,to determine what happenes when the close button is clicked///		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("i am closing");
			    dispose();
				System.gc();
				
				
			}
			
		});
		setJMenuBar(myJMenuBar());
		setLayout(new BorderLayout());
		
		//setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(800,480));
		
		setLocation(350, 250);
		
		add(tableHolder,BorderLayout.CENTER);
		//add(tP, BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
public JMenuBar myJMenuBar()
{
	
JMenuBar menubar=new JMenuBar();
JMenu settingMenu=new JMenu("TimeManager");
JMenuItem AboutUs=new JMenuItem("About us");
JMenuItem pref=new JMenuItem("Preference");
pref.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		prefSetting.setVisible(true);
		
	}
});
JMenuItem Quit=new JMenuItem("Quit");
Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

settingMenu.add(AboutUs);

settingMenu.addSeparator();
settingMenu.add(pref);
settingMenu.addSeparator();
settingMenu.add(Quit);

menubar.add(settingMenu);

return menubar;

}

}
