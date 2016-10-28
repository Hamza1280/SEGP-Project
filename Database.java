import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Database {
	private String path="jdbc:mysql://localhost/pat";
	private Connection con=null;
	private Statement st=null;
	private ResultSet rs=null;
	private int totalrows=0;
	private int count=0;
	public int row=0;
	public String[][] data; 
	public String login(String email,String pass){
		try {
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			rs=st.executeQuery("select * from login;");
			while(rs.next()){
				if(rs.getString(1).equals(email)){
					if(rs.getString(2).equals(pass)){
						return rs.getString(3);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void changepassword(String oldpass,String newpass){
		try {
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			st.executeUpdate("update login set password='"+newpass+"' where password='"+oldpass+"';");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkpassword(String pass){
		try {
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			rs=st.executeQuery("select password from login;");
			while(rs.next()){
				if(pass.equals(rs.getString(1))){
					return true;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void Search(String table){
		try{
			Database d=new Database();
			totalrows=d.numrows(table);
			if(table.equals("pats")){
			data=new String[totalrows][4];
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			rs=st.executeQuery("select * from "+table+";");
			while(rs.next()){
				data[row][0]=rs.getString(1);
				data[row][1]=rs.getString(2);
				data[row][2]=rs.getString(3);
				data[row][3]=rs.getString(4);
				row++;
			}
			}else if(table.equals("students")){
				data=new String[totalrows][7];
			
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+";");
				while(rs.next()){
					data[row][0]=rs.getString(1);
					data[row][1]=rs.getString(2);
					data[row][2]=rs.getString(3);
					data[row][3]=rs.getString(4);
					data[row][4]=rs.getString(5);
					data[row][5]=rs.getString(6);
					data[row][6]=rs.getString(7);
					row++;
				}
			}
			else if(table.equals("reason")){
				data=new String[totalrows][5];
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+";");
				while(rs.next()){
					data[row][0]=rs.getString(1);
					data[row][1]=rs.getString(2);
					data[row][2]=rs.getString(3);
					data[row][3]=rs.getString(4);
					data[row][4]=rs.getString(5);
					row++;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int numrows(String table){
		try{con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		rs=st.executeQuery("select * from "+table+";");
		while(rs.next()){
			count++;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	}
	public void studentinfo(){
		try{
			StudentInfo si=new StudentInfo();
			JOptionPane jop=new JOptionPane();
			String uob=jop.showInputDialog("Enter UOB");
		con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		rs=st.executeQuery("select * from students where uob='"+uob+"';");
		while(rs.next()){
		StudentInfo s =new StudentInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		s.frame.setVisible(true);
		si.frame.setVisible(false);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void studentRequest(String uob,String name,String year,String cpat,String reason){
		try{con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		st.executeUpdate("insert into reason values('"+uob+"','"+name+"','"+year+"','"+cpat+"','"+reason+"')");
		}catch(SQLException ex){
			
		}
	}
	public void getReason(){
		try{
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			rs=st.executeQuery("select * from reason;");
			}catch(SQLException ex){
	
			}
	}
	public void editInfo(String cn,String uob){
		try{con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		st.executeUpdate("update students set contact='"+cn+"' where uob='"+uob+"';");
		}catch(SQLException ex){
		}
	}
}