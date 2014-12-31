package frontend;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Toolbarexample extends JToolBar {

	/**
	 * Create the panel.
	 */
	public Toolbarexample() {
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Toolbarexample.class.getResource("/images/Cut24.gif")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Toolbarexample.class.getResource("/images/Delete24.gif")));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("cut");
		btnNewButton_2.setIcon(new ImageIcon(Toolbarexample.class.getResource("/images/Print16.gif")));
		add(btnNewButton_2);

	}

}
