package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserDelete {

	public int userDelete() throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------注销账号--------");
		System.out.println("请输入您要进行注销账号：");
		String userNum = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			String sql = "delete from user  where Num = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, userNum);

			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1){
					System.out.println("销户成功：");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else{
					System.out.println("销户失败，请重新操作：");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		}
	



}

