import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

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
		frame.setBounds(100, 100, 489, 300);
		frame.setTitle("Personal Academic Tutoring System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnRequests = new JButton("Change PAT Requests");
		btnRequests.setBounds(157, 46, 178, 23);
		btnRequests.addActionListener(this);
		panel.add(btnRequests);
		
		btnPats = new JButton("List of PAT's");
		btnPats.setBounds(157, 92, 178, 23);
		btnPats.addActionListener(this);
		panel.add(btnPats);
		
		btnStudents = new JButton("List of Students");
		btnStudents.setBounds(157, 135, 178, 23);
		btnStudents.addActionListener(this);
		panel.add(btnStudents);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(157, 180, 178, 23);
		btnChangePassword.addActionListener(this);
		panel.add(btnChangePassword);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(364, 11, 99, 23);
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
				
				RegistrarStudentY rsy=new RegistrarStudentY();
				rsy.frame.setVisible(true);
			}catch(Exception ex){
				ex.printStackTrace();
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