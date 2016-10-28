import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrar implements ActionListener{

	public JFrame frame;
	private JButton btnChangePassword;
	private JButton btnStudents;
	private JButton btnPats;
	private JButton btnRequests;
	private JButton btnLogout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar window = new Registrar();
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
	public Registrar() {
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
		
		btnRequests = new JButton("Requests");
		btnRequests.setBounds(157, 39, 116, 23);
		btnRequests.addActionListener(this);
		panel.add(btnRequests);
		
		btnPats = new JButton("PAT's");
		btnPats.setBounds(157, 82, 116, 23);
		btnPats.addActionListener(this);
		panel.add(btnPats);
		
		btnStudents = new JButton("Students");
		btnStudents.setBounds(157, 127, 119, 23);
		btnStudents.addActionListener(this);
		panel.add(btnStudents);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(157, 172, 119, 23);
		btnChangePassword.addActionListener(this);
		panel.add(btnChangePassword);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(335, 11, 89, 23);
		btnLogout.addActionListener(this);
		panel.add(btnLogout);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnChangePassword){
			frame.setVisible(false);
			RegistrarCP rcp=new RegistrarCP();
			rcp.frame.setVisible(true);
		}else if(e.getSource()==btnStudents){
			frame.setVisible(false);
			try{
				RegistrarStudent rs=new RegistrarStudent();
				rs.setVisible(true);
				}catch(Exception ex){
					
				}
		}else if(e.getSource()==btnPats){
			frame.setVisible(false);
			try{
			RegistrarPAT rp=new RegistrarPAT();
			rp.setVisible(true);
			}catch(NullPointerException ex){
				
			}
		}else if(e.getSource()==btnRequests){
			RegistrarRequest rr=new RegistrarRequest();
			rr.setVisible(true);
			frame.setVisible(false);
		}else if(e.getSource()==btnLogout){
			frame.setVisible(false);
			Login l=new Login();
			l.frame.setVisible(true);
		}
	}
}