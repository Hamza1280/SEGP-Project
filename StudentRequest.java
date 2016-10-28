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
import javax.swing.JTextArea;

public class StudentRequest implements ActionListener{

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JButton btnBack;
	public JButton btnSubmit;
	public JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRequest window = new StudentRequest();
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
	public StudentRequest() {
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
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 70, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		JLabel lblUob = new JLabel("Uob");
		lblUob.setBounds(68, 43, 46, 14);
		panel.add(lblUob);
		
		textField = new JTextField();
		textField.setBounds(153, 40, 125, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(68, 68, 46, 14);
		panel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 65, 125, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(68, 93, 46, 14);
		panel.add(lblYear);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 90, 125, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Current PAT");
		lblNewLabel.setBounds(68, 118, 77, 14);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(153, 115, 125, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(68, 143, 46, 14);
		panel.add(lblReason);
		
		textArea = new JTextArea();
		textArea.setBounds(153, 138, 246, 81);
		panel.add(textArea);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(310, 230, 89, 23);
		btnSubmit.addActionListener(this);
		panel.add(btnSubmit);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBack){
			frame.setVisible(false);
			Student s=new Student();
			s.frame.setVisible(true);
		}else if(e.getSource()==btnSubmit){
			Database d=new Database();
			d.studentRequest(textField.getText(),textField_1.getText(),textField_2.getText(), textField_3.getText(),textArea.getText());
			JOptionPane jop =new JOptionPane();
			jop.showMessageDialog(null, "Your Request has been submitted!");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textArea.setText("");
			
		}
		
	}
}