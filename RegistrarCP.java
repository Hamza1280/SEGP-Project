import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrarCP implements ActionListener{

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnSubmit;
	private JButton btnBack;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCP window = new RegistrarCP();
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
	public RegistrarCP() {
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
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(74, 45, 81, 14);
		panel.add(lblOldPassword);
		
		textField = new JTextField();
		textField.setBounds(176, 42, 121, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(74, 76, 81, 14);
		panel.add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 76, 121, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(74, 113, 95, 14);
		panel.add(lblConfirmPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 110, 121, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(208, 170, 89, 23);
		btnSubmit.addActionListener(this);
		panel.add(btnSubmit);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 81, 23);
		btnBack.addActionListener(this);
		panel.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBack){
			frame.setVisible(false);
			Registrar r=new Registrar();
			r.frame.setVisible(true);
		}else if(e.getSource()==btnSubmit){
			Database d=new Database();
			Login l=new Login();
			if(d.checkpassword(textField.getText())){
				if(textField_1.getText().equals(textField_2.getText())&&!textField_2.getText().equals("")){
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