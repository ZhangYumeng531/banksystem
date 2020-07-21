package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class AdminFindPassword {
	public int adminFindPassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner adminInput = new Scanner(System.in);
		System.out.println("---------找回密码--------");
		System.out.println("请输入您要进行找回密码的账号：");
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
				System.out.println("密码："+res.getString(3));
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
		return 0;
	}

}
