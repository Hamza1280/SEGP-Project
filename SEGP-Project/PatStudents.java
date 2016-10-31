import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PatStudents extends JFrame implements ActionListener{
	public String[] columns={"UOB#","Name","Father Name","PAT","Year","E-mail","Contact No."};
	public int nr;
	public JButton jb;
	public String email=null;
	public PatStudents(String email){
		this.email=email;
		new PatStudents();
	}
	public PatStudents(){
		Database d=new Database();
		JPanel jp=new JPanel();
		jb=new JButton("Back");
		jb.addActionListener(this);
		jp.add(jb);
		JOptionPane jop=new JOptionPane();
		email=jop.showInputDialog("Enter your email");
		System.out.println(email);
		d.searchStudents(email);
		JTable jt=new JTable(d.data,columns);
		jt.setPreferredScrollableViewportSize(new Dimension(500, 50));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp=new JScrollPane(jt);
		jp.add(jsp);
		setBounds(100, 100, 520, 300);
		add(jp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==jb){
			setVisible(false);
			Pat p=new Pat();
			p.frame.setVisible(true);
		}
	}
}