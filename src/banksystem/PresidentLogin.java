package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentLogin {
	
		public void presidentLogin(String bnum,String bpassword) throws SQLException {
			
			Scanner presidentInput = new Scanner(System.in);
			President president = new President();
			System.out.println("1欢迎进入管理员登录");
			
			System.out.println("请输入账号：");
			String presidentBnum = presidentInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//数据库连接
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.定义sql语句
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from boss where bnum=?";
				// 获取获取sql语句的对象
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, presidentBnum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("请输入密码密码：");
					String presidentBpassword = presidentInput.nextLine();
					if(res.getString(3).equals(presidentBpassword)){
						System.out.println("8登陆成功");
						PresidentManagement presidentManagement=new PresidentManagement();
						presidentManagement.presidentManagement();
					
					}else{
						System.err.println("密码错误，请重新登录;");
						PresidentSystem presidentSystem = new PresidentSystem();
						presidentSystem.presidentSystem();						
					}
					
					}else{
						System.err.println("该账号不存在，返回上一级");
						PresidentSystem presidentSystem = new PresidentSystem();
						presidentSystem.presidentSystem();		
					}
			//con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			}
}