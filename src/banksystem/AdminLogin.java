package banksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	
		public void adminLogin(String anum,String apassword) throws SQLException {
			
			Scanner adminInput = new Scanner(System.in);
			Admin admin = new Admin();
			System.out.println("1��ӭ�������Ա��¼");
			
			System.out.println("�������˺ţ�");
			String adminAnum = adminInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//���ݿ�����
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.����sql���
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from admin where anum=?";
				// ��ȡ��ȡsql���Ķ���
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, adminAnum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("�������������룺");
					String adminApassword = adminInput.nextLine();
					if(res.getString(3).equals(adminApassword)){
						System.out.println("8��½�ɹ�");
						AdminManagement adminManagement=new AdminManagement();
						adminManagement.adminManagement();
					
					}else{
						System.err.println("������������µ�¼;");
						AdminSystem adminSystem = new AdminSystem();
						adminSystem.adminSystem();						
					}
					
					}else{
						System.err.println("���˺Ų����ڣ�������һ��");
						AdminSystem adminSystem = new AdminSystem();
						adminSystem.adminSystem();						
						
					}
			//con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			}
}
