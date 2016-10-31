import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegistrarStudenty1 extends JFrame implements ActionListener{
	public String[] columns={"UOB#","Name","Father Name","PAT","Year","E-mail","Contact No."};
	public int nr; 
	public JButton jb;
	public JButton jbsort;
	public JButton jbpdf;
	public Database d;
	public String year;
	public RegistrarStudenty1(String year){
		this.year=year;
		setTitle("Personal Academic Tutoring System");
		d=new Database();
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
		d.SearchYear(year, "random");
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
	public RegistrarStudenty1(String sort,String year){
		setTitle("Personal Academic Tutoring System");
		d=new Database();
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
		d.SearchYear(year, sort);
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
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			setVisible(false);
			RegistrarStudentY rs=new RegistrarStudentY();
			rs.frame.setVisible(true);
		}else if(e.getSource()==jbsort){
			setVisible(false);
			System.out.println("Year" +"" + year);
			new RegistrarStudenty1("sort",year);
		}
		else if(e.getSource()==jbpdf){
			Pdf p=new Pdf();
			try{
				p.pdf("students","Student");
			}catch(Exception ex){
				
			}
		}
	}
}