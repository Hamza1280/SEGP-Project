import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Pat implements ActionListener{

	private JFrame frame;
	public JButton btnLogout;
	public JButton btnListOfStudents;
	public JButton btnNewButton;
	public JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pat window = new Pat();
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
	public Pat() {
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
		
		btnListOfStudents = new JButton("List of Students");
		btnListOfStudents.setBounds(132, 49, 152, 30);
		btnListOfStudents.addActionListener(this);
		panel.add(btnListOfStudents);
		
		btnNewButton = new JButton("Edit Info");
		btnNewButton.setBounds(132, 102, 152, 30);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.setBounds(132, 158, 152, 30);
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnLogout){
			Login l=new Login();
			l.frame.setVisible(true);
			frame.setVisible(false);
		}else if(e.getSource()==btnListOfStudents){
			
		}else if(e.getSource()==btnNewButton){
			
		}else if(e.getSource()==btnNewButton_1){
			PatCP pc=new PatCP();
			pc.frame.setVisible(true);
			frame.setVisible(false);
		}
	}
}
