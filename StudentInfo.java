import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StudentInfo implements ActionListener{

	public JFrame frame;
	public JButton btnEditInfo;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JButton btnBack;
	private JLabel lblEmail;
	public JTextField textField_6;
	public JPanel panel;
   
	public StudentInfo(String s1,String s2,String s3,String s4,String s5,String s6,String s7)
	{		
		frame=new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
	//	frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		JLabel lblUob = new JLabel("UOB");
		lblUob.setBounds(42, 45, 46, 14);
		panel.add(lblUob);
		
		textField = new JTextField();
		textField.setBounds(141, 42, 134, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(s1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(42, 76, 46, 14);
		panel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 73, 134, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(s2);
		
		JLabel lblNewLabel = new JLabel("PAT");
		lblNewLabel.setBounds(42, 138, 46, 14);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 135, 134, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(s3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 104, 134, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(s4);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(42, 107, 89, 14);
		panel.add(lblFatherName);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setBounds(42, 169, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 166, 134, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(s5);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(42, 232, 89, 14);
		panel.add(lblContactNumber);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 197, 134, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(s6);
		
		btnEditInfo = new JButton("Edit Info");
		btnEditInfo.setBounds(310, 228, 89, 23);
		btnEditInfo.addActionListener(this);
		panel.add(btnEditInfo);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(42, 200, 46, 14);
		panel.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setBounds(141, 229, 134, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);	
		textField_6.setText(s7);
		frame.add(panel);
//		frame.setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo window = new StudentInfo();
				//	window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInfo() 
	{
		initialize();
	}
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
//		
//		btnBack = new JButton("Back");
//		btnBack.setBounds(10, 11, 89, 23);
//		btnBack.addActionListener(this);
//		panel.add(btnBack);
//		
//		JLabel lblUob = new JLabel("UOB");
//		lblUob.setBounds(42, 45, 46, 14);
//		panel.add(lblUob);
//		
//		textField = new JTextField();
//		textField.setBounds(141, 42, 134, 20);
//		panel.add(textField);
//		textField.setColumns(10);
//		
//		
//		JLabel lblName = new JLabel("Name");
//lblName.setBounds(42, 76, 46, 14);
//		panel.add(lblName);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(141, 73, 134, 20);
//		panel.add(textField_1);
//		textField_1.setColumns(10);
//		
//		
//		JLabel lblNewLabel = new JLabel("PAT");
//		lblNewLabel.setBounds(42, 138, 46, 14);
//		panel.add(lblNewLabel);
//		
//		textField_2 = new JTextField();
//		textField_2.setBounds(141, 135, 134, 20);
//		panel.add(textField_2);
//		textField_2.setColumns(10);
//		
//		
//		textField_3 = new JTextField();
//		textField_3.setBounds(141, 104, 134, 20);
//		panel.add(textField_3);
//		textField_3.setColumns(10);
//		
//		
//		JLabel lblFatherName = new JLabel("Father Name");
//		lblFatherName.setBounds(42, 107, 89, 14);
//		panel.add(lblFatherName);
//		
//		JLabel lblNewLabel_1 = new JLabel("Year");
//		lblNewLabel_1.setBounds(42, 169, 46, 14);
//		panel.add(lblNewLabel_1);
//		
//		textField_4 = new JTextField();
//		textField_4.setBounds(141, 166, 134, 20);
//		panel.add(textField_4);
//		textField_4.setColumns(10);
//		
//		
//		JLabel lblContactNumber = new JLabel("Contact Number");
//		lblContactNumber.setBounds(42, 232, 89, 14);
//		panel.add(lblContactNumber);
//		
//		textField_5 = new JTextField();
//		textField_5.setBounds(141, 197, 134, 20);
//		panel.add(textField_5);
//		textField_5.setColumns(10);
//	
//		
//		btnEditInfo = new JButton("Edit Info");
//		btnEditInfo.setBounds(310, 228, 89, 23);
//		btnEditInfo.addActionListener(this);
//		panel.add(btnEditInfo);
//		
//		lblEmail = new JLabel("Email");
//		lblEmail.setBounds(42, 200, 46, 14);
//		panel.add(lblEmail);
//		
//		textField_6 = new JTextField();
//		textField_6.setBounds(141, 229, 134, 20);
//		panel.add(textField_6);
//		textField_6.setColumns(10);	
//
//		frame.add(panel);
//		frame.setVisible(true);
//		
//		
//	}

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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		JLabel lblUob = new JLabel("UOB");
		lblUob.setBounds(42, 45, 46, 14);
		panel.add(lblUob);
		
		textField = new JTextField();
		textField.setBounds(141, 42, 134, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(42, 76, 46, 14);
		panel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 73, 134, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PAT");
		lblNewLabel.setBounds(42, 138, 46, 14);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 135, 134, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 104, 134, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(42, 107, 89, 14);
		panel.add(lblFatherName);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setBounds(42, 169, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 166, 134, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(42, 232, 89, 14);
		panel.add(lblContactNumber);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 197, 134, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		btnEditInfo = new JButton("Edit Info");
		btnEditInfo.setBounds(310, 228, 89, 23);
		btnEditInfo.addActionListener(this);
		panel.add(btnEditInfo);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(42, 200, 46, 14);
		panel.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setBounds(141, 229, 134, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnEditInfo){
			Database d=new Database();
			System.out.println(textField_6.getText()+" "+textField.getText());
			d.editInfo(textField_6.getText(),textField.getText());
			JOptionPane jop=new JOptionPane();
			jop.showMessageDialog(null, "Your Contact number has been updated");
		}else if(e.getSource()==btnBack){
			frame.setVisible(false);
			Student st=new Student();
			st.frame.setVisible(true);
		}
	}
}