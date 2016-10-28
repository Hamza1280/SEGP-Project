import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	private String designation=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(51, 77, 58, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(149, 74, 138, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 110, 71, 14);
		panel.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 107, 138, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				designation=db.login(textField.getText(),textField_1.getText());
				try{
					if(designation.equals("registrar")){
						System.out.println("Registrar");
						Registrar r=new Registrar();
						r.frame.setVisible(true);
						frame.setVisible(false);
						
					}else if(designation.equals("pat")){
						System.out.println("Pat");
					}else if(designation.equals("student")){
						System.out.println("student");
						Student st=new Student();
						st.frame.setVisible(true);
						frame.setVisible(false);
						
					}
				}
				catch(Exception ex){
					JOptionPane jop=new JOptionPane();
					jop.showMessageDialog(null,"Wrong Input");
					textField.setText("");
					textField_1.setText("");
				}
			}
		});
		btnLogin.setBounds(173, 153, 89, 23);
		panel.add(btnLogin);
	}
}