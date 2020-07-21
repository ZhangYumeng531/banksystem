package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class PrsidentChangePassword {

	public int prsidentChangePassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner adminInput = new Scanner(System.in);
		System.out.println("---------修改密码--------");
		System.out.println("请输入您要进行修改密码的账号：");
		String prsidentBnum = adminInput.nextLine();
		System.out.println("请输入新密码：");
		String prsidentnewpassword = adminInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update boss set bpassword=? where bnum = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, prsidentnewpassword);
		    ps.setString(2, prsidentBnum);
			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1){
					System.out.println("行长密码修改成功");
					PresidentSystem presidentSystem = new PresidentSystem();
					presidentSystem.presidentSystem();						
				}else{
					System.err.println("行长密码修改失败");
					PresidentSystem presidentSystem = new PresidentSystem();
					presidentSystem.presidentSystem();				
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

