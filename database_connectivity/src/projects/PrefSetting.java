package projects;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PrefSetting extends JDialog implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	private JLabel namelabel;
	private JLabel passwordlabel;
	private JLabel emailLabel;
	private JTextField nameField;
	private JPasswordField jPF ;
	private JTextField emailField;
	private JButton saveButton;
	private JButton cancelbutton;
	private prefsListener prefsListener;
	private String  email;
	private String  password;
	private String  username;
	

public PrefSetting (JFrame parent)
{ 
	super(parent," ",false);
	namelabel=new JLabel("Username");
	passwordlabel=new JLabel("Password");
	emailLabel=new JLabel("Email");
	nameField=new JTextField (13);
	emailField=new JTextField (13);
	jPF=new JPasswordField( 13);
	
	saveButton=new JButton("Save");
	cancelbutton=new JButton("Cancel");
	cancelbutton.addActionListener(this);
	saveButton.addActionListener(this);
	setLayout();
	
}
public void setLayout()
{   setSize(new Dimension(300, 400));
    setLocationRelativeTo(this);
   // setLocation(250, 200);
	int countx=0;
    int county=0;
	GridBagLayout gb=new GridBagLayout();
	setLayout(gb);
	GridBagConstraints gc=new GridBagConstraints();
	gc.gridx=countx++;
	gc.gridy=county++;
	gc.weightx=1;
	gc.weighty=0.5;
	add(namelabel,gc);
	
	gc.gridx=countx++;
	add(nameField,gc);
	
 ////////next row////////
	gc.gridx=0;
	gc.gridy=county++;
	add(passwordlabel,gc);
	
	gc.gridx=1;
	add(jPF,gc);
	
	
////////next row////////
	gc.gridx=0;
	gc.gridy=county++;
	add(emailLabel,gc);
	
	gc.gridx=1;
	add(emailField,gc);
	
////////next row////////
	gc.weighty=1.5;
	gc.gridx=0;
	gc.gridy=county++;
	add(saveButton,gc);
	
	gc.gridx=1;
	add(cancelbutton,gc);
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==cancelbutton)
	{   this.setVisible(false);  }
	else //if(e.getSource()==saveButton)
	{   email= emailField.getText();
	    username=emailField.getText();
	    password= new String(jPF.getPassword());
	   
	   if(prefsListener != null)
	   { prefsListener.setPreferences(username, password,email );}
	   this.setVisible(false);
	 }
}

public void setPrefs(prefsListener prefsListener) {
	
	this.prefsListener=prefsListener;
}

public void checkPrefs()
{
	System.out.println(email);

}
}
