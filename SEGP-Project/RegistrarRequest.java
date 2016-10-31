import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegistrarRequest extends JFrame implements ActionListener{
	public String[] columns={"UOB#","Name","Year","Current PAT","New Pat","Reason"};
	public String receiveduob=null;
	public int nr; 
	public JButton jb;
	public JButton jbapprove;
	public JButton jbdelete;
	public int index=0;
	public String npat=null;
	public String cpat=null;
	JTable jt;
	public String uob=""; 
	public RegistrarRequest(){
		Database d=new Database();
		JPanel jp=new JPanel();
		setTitle("Personal Academic Tutoring System");
		jb=new JButton("Back");
		jb.addActionListener(this);
		jp.add(jb);
		
		jbapprove=new JButton("Approve");
		jbapprove.addActionListener(this);
		jp.add(jbapprove);
		
		jbdelete=new JButton("Delete");
		jbdelete.addActionListener(this);
		jp.add(jbdelete);
		
		d.Search("reason","");
		jt=new JTable(d.data,columns);
		jt.setPreferredScrollableViewportSize(new Dimension(500, 50));
		jt.setFillsViewportHeight(true);
		jt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				Database d=new Database();
				index=jt.getSelectedRow();
				d.showrelevantdata(index);
			}
		});
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
			Registrar r=new Registrar();
			r.frame.setVisible(true);
		}
		else if(e.getSource()==jbapprove){
			Database d=new Database();
			d.delete(receiveduob);
			d.changePat(npat,cpat);
			JOptionPane jop=new JOptionPane();
			jop.showMessageDialog(null,"Request has been accepted!");
		}else if(e.getSource()==jbdelete){
			Database d=new Database();
			d.delete(receiveduob);
			JOptionPane jop=new JOptionPane();
			jop.showMessageDialog(null,"Request has been deleted!");
		}
	}
	
	public void recievedvalue(String uob,String cpat,String npat)
	{
		receiveduob=uob;
		this.cpat=cpat;
		this.npat=npat;
	}
}