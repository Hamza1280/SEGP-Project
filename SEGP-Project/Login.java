import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class Login {

	public JFrame frame;
	public JTextField textField;
	private String designation=null;
	private JPasswordField passwordField;
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
		frame.setTitle("Personal Academic Tutoring System");
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 491, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 475, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(271, 90, 58, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(271, 104, 138, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(271, 135, 71, 14);
		panel.add(lblPassword);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				designation=db.login(textField.getText(),passwordField.getText());
				try{
					if(designation.equals("registrar")){
						System.out.println("Registrar");
						Registrar r=new Registrar();
						r.frame.setVisible(true);
						frame.setVisible(false);
						
					}else if(designation.equals("pat")){
						System.out.println("Pat");
						Pat p=new Pat();
						p.frame.setVisible(true);
						frame.setVisible(false);
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
					passwordField.setText("");
				}
			}
		});
		btnLogin.setBounds(298, 181, 89, 22);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(271, 148, 138, 22);
		panel.add(passwordField);
		
		JLabel lblThisIsPersonal = new JLabel("this is Personal academoic tutoring system");
		lblThisIsPersonal.setIcon(new ImageIcon("C:\\Users\\Waleed\\Desktop\\logo.jpg"));
		lblThisIsPersonal.setBounds(0, 0, 245, 138);
		panel.add(lblThisIsPersonal);
	}
}