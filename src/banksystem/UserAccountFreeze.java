package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class UserAccountFreeze {
	public int userAccountFreeze()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------冻结账户--------");
		System.out.println("请输入您要进行冻结操作的账号：");
		String userNum = userInput.nextLine();
		System.out.println("冻结该账号请输入“0”：");
		String usernewquanxian = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update user set quanxian=? where Num = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, usernewquanxian);
		    ps.setString(2, userNum);
			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1&&usernewquanxian.equals("0")){
					System.out.println("冻结成功");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else if(res!=1&&usernewquanxian.equals("0")){
					System.err.println("账号或密码错误冻结失败，请返回重试");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else if(res==1){
					System.err.println("冻结只能输入（ 0）冻结失败，请返回重试");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else{
					System.err.println("账号或密码错误，冻结只能输入（ 0）冻结失败，请返回重试");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
