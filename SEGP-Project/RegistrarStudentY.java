import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

public class RegistrarStudentY implements ActionListener{

	public JFrame frame;
	public JButton btnYear;
	public JButton btnAllStudents;
	public JButton btnYear_1;
	public JButton btnYear_2;
	public JButton btnYear_3;
	public JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarStudentY window = new RegistrarStudentY();
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
	public RegistrarStudentY() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setTitle("Personal Academic Tutoring System");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnYear = new JButton("Year 2014");
		btnYear.setBounds(135, 68, 128, 23);
		btnYear.addActionListener(this);
		frame.getContentPane().add(btnYear);
		
		btnAllStudents = new JButton("All Students");
		btnAllStudents.setBounds(135, 34, 128, 23);
		btnAllStudents.addActionListener(this);
		frame.getContentPane().add(btnAllStudents);
		
		btnYear_1 = new JButton("Year 2015");
		btnYear_1.setBounds(135, 102, 128, 23);
		btnYear_1.addActionListener(this);
		frame.getContentPane().add(btnYear_1);
		
		btnYear_2 = new JButton("Year 2016");
		btnYear_2.setBounds(135, 136, 128, 23);
		btnYear_2.addActionListener(this);
		frame.getContentPane().add(btnYear_2);
		
		btnYear_3 = new JButton("Year 2017");
		btnYear_3.setBounds(135, 170, 128, 23);
		btnYear_3.addActionListener(this);
		frame.getContentPane().add(btnYear_3);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(335, 11, 89, 23);
		btnBack.addActionListener(this);
		frame.getContentPane().add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBack){
			frame.setVisible(false);
			Registrar r=new Registrar();
			r.frame.setVisible(true);
		}else if(e.getSource()==btnAllStudents){
			frame.setVisible(false);
			RegistrarStudent rs=new RegistrarStudent();
			rs.setVisible(true);
		}else if(e.getSource()==btnYear){
			frame.setVisible(false);
			RegistrarStudenty1 rs1=new RegistrarStudenty1("2014");
			rs1.setVisible(true);
		}else if(e.getSource()==btnYear_1){
			frame.setVisible(false);
			RegistrarStudenty1 rs1=new RegistrarStudenty1("2015");
			rs1.setVisible(true);
		}else if(e.getSource()==btnYear_2){
			frame.setVisible(false);
			RegistrarStudenty1 rs1=new RegistrarStudenty1("2016");
			rs1.setVisible(true);
		}else if(e.getSource()==btnYear_3){
			frame.setVisible(false);
			RegistrarStudenty1 rs1=new RegistrarStudenty1("2017");
			rs1.setVisible(true);
		}
	}
}
