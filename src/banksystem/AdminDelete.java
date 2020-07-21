package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminDelete {

	public int adminDelete() throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------删除管理员--------");
		System.out.println("请输入您要进行删除的管理员账号：");
		String adminAnum = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			String sql = "delete from admin  where anum = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, adminAnum);

			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1){
					System.out.println("删除管理员成功");
					AdminManagement adminManagement = new AdminManagement();
					 adminManagement.adminManagement();
				}else{
					System.err.println("删除管理员失败,请重新操作：");
					AdminManagement adminManagement = new AdminManagement();
					 adminManagement.adminManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		}
	



}
