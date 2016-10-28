import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student implements ActionListener{

	public JFrame frame;
	public JButton btnChangePassword;
	public JButton btnNewButton;
	public JButton btnChangePat;
	public JButton btnLogout;
	public Database d;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(335, 11, 89, 23);
		btnLogout.addActionListener(this);
		panel.add(btnLogout);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(141, 154, 140, 23);
		btnChangePassword.addActionListener(this);
		panel.add(btnChangePassword);
		
		btnNewButton = new JButton("Edit Info");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(141, 108, 140, 23);
		panel.add(btnNewButton);
		
		btnChangePat = new JButton("Change PAT");
		btnChangePat.setBounds(141, 59, 140, 23);
		btnChangePat.addActionListener(this);
		panel.add(btnChangePat);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogout){
			Login l=new Login();
			l.frame.setVisible(true);
			frame.setVisible(false);
			
		}else if(e.getSource()==btnChangePassword){
			StudentCP scp=new StudentCP();
			scp.frame.setVisible(true);
			frame.setVisible(false);
			
		}else if(e.getSource()==btnChangePat){
			StudentRequest sr=new StudentRequest();
			sr.frame.setVisible(true);
			frame.setVisible(false);	
		}
		else if (e.getSource()==btnNewButton)
		{
			frame.setVisible(false);
			d=new Database();
			d.studentinfo();
		}
	}
}