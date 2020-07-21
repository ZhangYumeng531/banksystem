package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;
public class ChangeAdminPhone {
	public void changeAdminPhone()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------修改管理员手机号--------");
		System.out.println("请输入您要进行修改密码的账号：");
		String adminAnum = userInput.nextLine();
		System.out.println("请输入新手机号：");
		String adminnewphone = userInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update admin set atelephone=? where anum = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, adminnewphone);
		    ps.setString(2, adminAnum);
			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1){
					System.out.println("修改管理员手机号成功");
					AdminManagement adminManagement=new AdminManagement();
					adminManagement.adminManagement();
				}else{
					System.out.println("修改管理员手机号失败，请重新进入修改界面");
					AdminManagement adminManagement=new AdminManagement();
					adminManagement.adminManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
