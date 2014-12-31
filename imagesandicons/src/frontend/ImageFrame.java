package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.net.URL;

public class ImageFrame extends JFrame {

	private JPanel contentPane;
	private JPanel menupanel;
	private Toolbarexample tbE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageFrame frame = new ImageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImageFrame() {
		tbE=new Toolbarexample();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COPY, InputEvent.ALT_GRAPH_MASK));
		mntmSave.setIcon(getImageIcon("/Users/engr/Documents/Swing/imagesandicons/src/images/Save16.gif"));
		mnFile.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		
		mnFile.add(mntmClose);
		
		JMenuItem mntmSaveAll = new JMenuItem("Save All");
		mnFile.add(mntmSaveAll);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setIcon(getImageIcon("/Users/engr/Documents/Swing/imagesandicons/src/images/Copy16.gif"));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnAboutUs = new JMenu("About us");
		menuBar.add(mnAboutUs);
		
		JMenuItem mntmHistory = new JMenuItem("History");
		mnAboutUs.add(mntmHistory);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		menupanel = new JPanel();
		menupanel.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		
		contentPane.add(menupanel, BorderLayout.NORTH);
		contentPane.add(tbE,BorderLayout.SOUTH);
	}
	public ImageIcon getImageIcon(String path)
	{
	 URL url=	getClass().getResource(path);
		if(url==null)
		{System.out.println("image not found");}
		ImageIcon im=new ImageIcon(path);
		return im;
	}

}
