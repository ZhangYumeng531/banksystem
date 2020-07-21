package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.math.BigDecimal;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class Deposit {
	public void deposit() throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------存款--------");
		System.out.println("请输入您要进行存款的账号：");
		String userNum = userInput.nextLine();
		System.out.println("请输入存款金额：");
		BigDecimal usernewbalance = userInput.nextBigDecimal();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.定义sql语句
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update user set balance=balance+? where Num = ?";
			// 获取获取sql语句的对象
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setBigDecimal(1, usernewbalance);
		    ps.setString(2, userNum);
			 //执行sql语句
		    int res = ps.executeUpdate();

			//判断
		    if(res==1){
		    
					System.out.println("存款成功");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else{
					System.err.println("存款失败,请重新交易：");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return 0;
	}

}
