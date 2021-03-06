package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class AdminFreeze {
	public int adminFreeze()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------禁用管理员--------");
		System.out.println("请输入您要进行禁用操作的账号：");
		String adminAnum = userInput.nextLine();
		System.out.println("禁用该账号请输入“0”：");
		String adminnewquanxian = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update admin set quanxian=? where anum = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, adminnewquanxian);
		    ps.setString(2, adminAnum);
			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1&&adminnewquanxian.equals("0")){
					System.out.println("禁用成功");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else if(res!=1&&adminnewquanxian.equals("0")){
					System.err.println("账号或密码错误禁用失败，请返回重试");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else if(res==1){
					System.err.println("禁用只能输入（ 0）禁用失败，请返回重试");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else{
					System.err.println("账号或密码错误，禁用只能输入（ 0）禁用失败，请返回重试");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}