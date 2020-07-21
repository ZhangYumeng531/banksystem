package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
		public void userLogin(String num,String password) throws SQLException {
			
			Scanner userInput = new Scanner(System.in);
			Admin user = new Admin();
			System.out.println("1欢迎进入管理员登录");
			
			System.out.println("请输入账号：");
			String userNum = userInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//数据库连接
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.定义sql语句
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from user where Num=?";
				// 获取获取sql语句的对象
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, userNum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("请输入密码：");
					String userPassword = userInput.nextLine();
					if(res.getString(3).equals(userPassword)){
						if(res.getString(6).equals("1")){
							System.out.println("8登陆成功");
							UserManagement userManagement=new UserManagement();
							userManagement.userManagement();
						}else{
							System.err.println("该账号已被冻结或挂失无法登录，即将返回上一级");
							UserSystem userSystem = new UserSystem();
							userSystem.userSystem();	
						}
						
					}
					}else{
						System.err.println("该账号不存在，返回上一级");
						UserSystem userSystem = new UserSystem();
						userSystem.userSystem();				
						
					}
			//con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
		

}