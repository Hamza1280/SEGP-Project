import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.w3c.dom.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.text.*;
public class Database {
	private String path="jdbc:mysql://localhost/pat";
	private Connection con=null;
	private Statement st=null;
	private ResultSet rs=null;
	private int totalrows=0;
	public int count=0;
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
	public void Search(String table,String sort){
		try{
			Database d=new Database();
			totalrows=d.numrows(table);
			if(table.equals("pats")&& sort.equals("random")){
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
			}else if(table.equals("pats")&& sort.equals("sort")){
				data=new String[totalrows][4];
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+" order by name;");
				while(rs.next()){
					data[row][0]=rs.getString(1);
					data[row][1]=rs.getString(2);
					data[row][2]=rs.getString(3);
					data[row][3]=rs.getString(4);
					row++;
				}
			}else if(table.equals("students") && sort.equals("sort")){
				data=new String[totalrows][7];
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+" order by name;");
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
			else if(table.equals("students") && sort.equals("random")){
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
				data=new String[totalrows][6];
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
				
				/*for(int i =0 ; i<2;i++)
				{
					for(int t=0;t<5;t++)
					{
						System.out.println(data[i][t]);
					}
				}*/
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showrelevantdata(int t)
	{
		
		totalrows=numrows("reason");
		String table = "reason";
		data=new String[totalrows][5];
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	//	System.out.println(data[t][1]);
		RegistrarRequest rr= new RegistrarRequest();
		rr.recievedvalue(data[t][0],data[t][3],data[t][4]);
		
		
		
		 
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
	public void studentRequest(String uob,String name,String year,String cpat,String npat,String reason){
		try{con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		st.executeUpdate("insert into reason values('"+uob+"','"+name+"','"+year+"','"+cpat+"','"+npat+"','"+reason+"')");
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
	public void searchStudents(String email){
		try{
			data=new String[totalrows][7];
			con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		rs=st.executeQuery("select name from pats where email='"+email+"';");
		String pat=null;
		while(rs.next()){
		pat=rs.getString(1);
		System.out.println(pat);
		}
		System.out.println(pat);
		rs=st.executeQuery("select * from students where pat='"+pat+"';");
		while(rs.next()){
			count++;
		}
		data=new String[count][7];
		rs=st.executeQuery("select * from students where pat='"+pat+"';");
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
		
		}catch(SQLException ex){
			
		}
	}
	public void sort(){
		numrows("students");
		data=new String[count][7];
		try{
		con=DriverManager.getConnection(path,"root","");
		st=con.createStatement();
		rs=st.executeQuery("select * from students order by name;");
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
		}catch(SQLException ex){
			
		}
	}
	public void SearchYear(String year,String sort){
		Database d=new Database();
		String table="students";
		totalrows=d.numrows(table);
		if(table.equals("students") && sort.equals("sort")){
			data=new String[totalrows][7];
			try {
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+" where year='"+year+"' order by name;");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(table.equals("students") && sort.equals("random")){
			data=new String[totalrows][7];
			try {
				con=DriverManager.getConnection(path,"root","");
				st=con.createStatement();
				rs=st.executeQuery("select * from "+table+" where year='"+year+"';");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(String uob){
		try {
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			st.executeUpdate("delete from reason where uob='"+uob+"';");
		}catch(Exception ex){
			
		}
	}
	public void changePat(String npat,String cpat){
		try {
			con=DriverManager.getConnection(path,"root","");
			st=con.createStatement();
			st.executeUpdate("update students set pat='"+npat+"' where pat='"+cpat+"';");
		}catch(Exception ex){
			
		}
	}
}