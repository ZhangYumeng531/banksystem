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
			System.out.println("1欢迎进入管理员登录");
			
			System.out.println("请输入账号：");
			String adminAnum = adminInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//数据库连接
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.定义sql语句
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from admin where anum=?";
				// 获取获取sql语句的对象
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, adminAnum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("请输入密码密码：");
					String adminApassword = adminInput.nextLine();
					if(res.getString(3).equals(adminApassword)){
						System.out.println("8登陆成功");
						AdminManagement adminManagement=new AdminManagement();
						adminManagement.adminManagement();
					
					}else{
						System.err.println("密码错误，请重新登录;");
						AdminSystem adminSystem = new AdminSystem();
						adminSystem.adminSystem();						
					}
					
					}else{
						System.err.println("该账号不存在，返回上一级");
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
