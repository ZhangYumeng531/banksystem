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
			System.out.println("欢迎进入管理员登录");
			System.out.println("请输入账号："); 
			admin.setAnum(adminInput.nextLine().trim());
			int num=0;
			while(admin.getAnum().equals("")) {
				if(num>2){
					//跳回首页
					System.out.println("您输入次数过多，即将跳回首页");
					AdminSystem adminSystem = new AdminSystem();
					adminSystem.adminSystem();
				}
				System.err.println("您输入账号为空，请重新输入：");
				admin.setAnum(adminInput.nextLine().trim()); 
				num++;
			}
		 
			System.out.println("请输入密码：");
			admin.setApassword(adminInput.nextLine().trim());
			while(admin.getApassword().equals("")) {			
				System.err.println("您输入密码为空，请重新输入：");
				admin.setApassword(adminInput.nextLine().trim()); 
			}
			while(admin.getApassword().length() != 6) {
				System.err.println("您输入密码不符合6位,请重新输入：");
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
							System.out.println("登陆成功");
							AdminManagement adminManagement=new AdminManagement();
							adminManagement.adminManagement();
						
						}else{
							System.err.println("账号或密码错误即将返回首页！");	
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
