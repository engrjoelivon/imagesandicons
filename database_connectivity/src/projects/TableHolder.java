package projects;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JOptionPane;

import project_modals.Course;
import project_modals.StudyTable;
import project_modals.Courses;;


public class TableHolder extends JPanel implements ActionListener{
	private JTable table;
	private TableModalDef tMD;
	private JPopupMenu popmenu;
	private JMenuItem addCourse;
	private JMenuItem remCourse;
	private String [] tableKeys;
	private Courses course;
	private Course courses;

	private UpdateInterface updateInterface;
 


	/**
	 * Create the panel.
	 * @param resSet2 
	 */
	public TableHolder(String [] tableKeys,  Course courses) {
		
		this.tableKeys=tableKeys;
		this.courses=courses;
		tMD=new TableModalDef(tableKeys,courses);
		course=new Courses();
	   
		
		runMenu();
		table = new JTable(tMD);
		table.setRowHeight(37);
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				//super.mouseClicked(e);
				if(e.getButton()==MouseEvent.BUTTON3)
				{ popmenu.show(table, e.getX(), e.getY());                       }
				
				
			}

			
			
			
			
			
		});
		
		setLayout(new BorderLayout());
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Serif", Font.BOLD, 18));
		//table.setBackground(new Color(255, 250,205));
		table.setBackground(Color.GRAY);
		table.setMinimumSize(new Dimension(800,400));
		setMinimumSize(new Dimension(800,400));
		add(new JScrollPane(table),BorderLayout.CENTER);
		
		
		setBackground(Color.GRAY);
		

	}
   
public void runMenu(){
	popmenu=new JPopupMenu();
    addCourse=new JMenuItem("Add Course");
    remCourse=new JMenuItem("Remove Course");	
	addCourse.addActionListener(this);
	remCourse.addActionListener(this);
	popmenu.add(addCourse);
	popmenu.addSeparator();
	popmenu.add(remCourse);
	
}
public void actionPerformed(ActionEvent e) {
	//addCourse=(JMenuItem)e.getSource();
	if(e.getSource()==addCourse)
	{ String row=null;
	  String col=null;
		int outer= table.getSelectedRow();
		int inner=table.getSelectedColumn();
	    if(outer==0)
	    {row="seven";}
	    else if(outer==1)
	    {row="eight";}
	    else if(outer==2)
	    {row="nine";}
	    else if(outer==3)
	    {row="ten";}
	    else if(outer==4)
	    {row="eleven";}
	    else if(outer==5)
	    {row="twelve";}
	    else if(outer==6)
	    {row="one";}
	    else if(outer==7)
	    {row="two";}
	    else if(outer==8)
	    {row="three";}
	    else if(outer==9)
	    {row="four";}
	    else if(outer==10)
	    {row="five";}
	    else if(outer==11)
	    {row="six";}
	    
	    
	    if(inner==0)col="Monday";
	    else if(inner==1)col="tuesday";
	    else if(inner==2)col="wednesday";
	    else if(inner==3)col="thursday";
	    else if(inner==4)col="friday";
	    else if(inner==5)col="satuday";
	    else if(inner==6)col="sunday";
	   
	    
		
		
String message=JOptionPane.showInputDialog(this, "Enter course here"," ",JOptionPane.QUESTION_MESSAGE);  System.out.println(message);                        
	//course.setCourses(outer, inner, message); 
	//System.out.println("column selected = "+ inner +" row = "+ outer );
	if(updateInterface != null && row != null  && col != null )
	{                             
		System.out.println("update not equal to null");
	  tMD.setTableCourses(updateInterface.updateTable(outer, inner, message));
		
	}
	}
	
	//tMD.fireTableDataChanged();
	}
	

		
		

public void setUpdate(UpdateInterface updateInterface) {
this.updateInterface=updateInterface;
	
}
public void createNewT(String[] strings) {
	
	
}
  
   
}
