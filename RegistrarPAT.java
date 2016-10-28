import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class RegistrarPAT extends JFrame implements ActionListener{
	public String[] columns={"Name","E-mail","Designation","Number of Students"};
	public int nr; 
	public JButton jb;
	public RegistrarPAT(){
		Database d=new Database();
		JPanel jp=new JPanel();
		jb=new JButton("Back");
		jb.addActionListener(this);
		jp.add(jb);
		d.Search("pats");
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
			Registrar r=new Registrar();
			r.frame.setVisible(true);
		}
	}
}