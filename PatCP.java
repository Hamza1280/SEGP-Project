import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PatCP implements ActionListener{

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;
	private JButton btnSubmit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCP window = new StudentCP();
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
	public PatCP() {
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
		btnBack.setBounds(10, 11, 79, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(71, 61, 88, 23);
		panel.add(lblOldPassword);
		
		textField = new JTextField();
		textField.setBounds(169, 62, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(71, 107, 79, 14);
		panel.add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 104, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(71, 156, 94, 14);
		panel.add(lblConfirmPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 153, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(251, 206, 89, 23);
		btnSubmit.addActionListener(this);
		panel.add(btnSubmit);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBack){
			frame.setVisible(false);
			Student st=new Student();
			st.frame.setVisible(true);
		}else if(e.getSource()==btnSubmit){
			Database d=new Database();
			//Login l=new Login();
			if(d.checkpassword(textField.getText())){
				if(textField_1.getText().equals(textField_2.getText())){
					d.changepassword(textField.getText(),textField_1.getText());
					JOptionPane jop=new JOptionPane();
					jop.showMessageDialog(null,"Password has been changed!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				else{
					JOptionPane jop=new JOptionPane();
					jop.showMessageDialog(null,"Password doesn't match!");
					textField_1.setText("");
					textField_2.setText("");
				}
			}else if(textField.getText().equals("") &&textField_1.getText().equals("")&&textField_2.getText().equals("")){
				JOptionPane jop=new JOptionPane();
				jop.showMessageDialog(null,"Empty Field(s)");
			}
			else{
				JOptionPane jop=new JOptionPane();
				jop.showMessageDialog(null,"OldPassword is Incorrect!");
				textField.setText("");
			}
		}
	}
}