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
			System.out.println("��ӭ�������Ա��¼");
			System.out.println("�������˺ţ�"); 
			admin.setAnum(adminInput.nextLine().trim());
			int num=0;
			while(admin.getAnum().equals("")) {
				if(num>2){
					//������ҳ
					System.out.println("������������࣬����������ҳ");
					AdminSystem adminSystem = new AdminSystem();
					adminSystem.adminSystem();
				}
				System.err.println("�������˺�Ϊ�գ����������룺");
				admin.setAnum(adminInput.nextLine().trim()); 
				num++;
			}
		 
			System.out.println("���������룺");
			admin.setApassword(adminInput.nextLine().trim());
			while(admin.getApassword().equals("")) {			
				System.err.println("����������Ϊ�գ����������룺");
				admin.setApassword(adminInput.nextLine().trim()); 
			}
			while(admin.getApassword().length() != 6) {
				System.err.println("���������벻����6λ,���������룺");
				admin.setApassword(adminInput.nextLine().trim()); 
			}
			try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
					String sql="SELECT * FROM admin";
					PreparedStatement st = con.prepareStatement(sql);
					//st.setString(1, anum);
					ResultSet res =st.executeQuery();
					while(res.next()){
						if(res.getString(1).equals(anum)&&res.getString(3).equals(apassword)){
							System.out.println("��½�ɹ�");
							AdminManagement adminManagement=new AdminManagement();
							adminManagement.adminManagement();
						
						}else{
							System.err.println("�˺Ż�������󼴽�������ҳ��");	
							AdminSystem adminSystem = new AdminSystem();
							adminSystem.adminSystem();
						}
						
					}
					con.close();
						
				}catch(Exception e){
					e.printStackTrace();
				}
			
			 
			}
		

}
