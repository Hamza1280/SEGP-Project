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
	public JButton jbsort;
	public JButton jbpdf;
	public RegistrarPAT(){
		setTitle("Personal Academic Tutoring System");
		Database d=new Database();
		JPanel jp=new JPanel();
		jb=new JButton("Back");
		jb.addActionListener(this);
		jp.add(jb);
		jbsort=new JButton("Sort");
		jbsort.addActionListener(this);
		jp.add(jbsort);
		jbpdf=new JButton("Create PDF File");
		jbpdf.addActionListener(this);
		jp.add(jbpdf);
		d.Search("pats","random");
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
	public RegistrarPAT(String sort){
		setTitle("Personal Academic Tutoring System");
		Database d=new Database();
		JPanel jp=new JPanel();
		jb=new JButton("Back");
		jb.addActionListener(this);
		jp.add(jb);
		jbsort=new JButton("Sort");
		jbsort.addActionListener(this);
		jp.add(jbsort);
		jbpdf=new JButton("Create PDF File");
		jbpdf.addActionListener(this);
		jp.add(jbpdf);
		d.Search("pats",sort);
		JTable jt=new JTable(d.data,columns);
		jt.setPreferredScrollableViewportSize(new Dimension(500, 50));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp=new JScrollPane(jt);
		jp.add(jsp);
		setBounds(100, 100, 520, 300);
		add(jp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==jb){
			setVisible(false);
			Registrar r=new Registrar();
			r.frame.setVisible(true);
		}
		else if(e.getSource()==jbsort){
			setVisible(false);
			new RegistrarPAT("sort");
		}
		else if(e.getSource()==jbpdf){
			Pdf p=new Pdf(); 
			try{
				p.pdf("pats","Pat");
			}catch(Exception ex){
				
			}
		
		}
	}
}