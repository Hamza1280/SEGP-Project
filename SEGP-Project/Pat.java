import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;

public class Pat implements ActionListener{

	public JFrame frame;
	public JButton btnLogout;
	public JButton btnListOfStudents;
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
		frame.setTitle("Personal Academic Tutoring System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(335, 11, 89, 23);
		btnLogout.addActionListener(this);
		panel.add(btnLogout);
		
		btnListOfStudents = new JButton("List of Students");
		btnListOfStudents.setBounds(132, 75, 152, 30);
		btnListOfStudents.addActionListener(this);
		panel.add(btnListOfStudents);
		
		btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.setBounds(132, 135, 152, 30);
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
			PatStudents ps=new PatStudents();
			ps.setVisible(true);
			frame.setVisible(false);
		}else if(e.getSource()==btnNewButton_1){
			PatCP pc=new PatCP();
			pc.frame.setVisible(true);
			frame.setVisible(false);
		}
	}
}