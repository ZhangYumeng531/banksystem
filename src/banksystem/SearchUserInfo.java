package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchUserInfo {

	public void searchUserInfo(String adminChange) throws SQLException {
		// TODO Auto-generated method stub
		 System.out.println("----------欢迎查看用户信息------------");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				String sql="select *from user";
				System.out.println(sql);
				Statement st = con.createStatement();
				
				ResultSet res = st.executeQuery(sql);
				System.out.println(res);
				
				while(res.next()) {
				System.out.println("账号："+res.getString(1)+"\t\t 姓名："+res.getString(2)+ "\t\t 电话："+res.getString(4)+ " \t\t余额"+res.getString(5)+ " \t\t权限(0为冻结，1为正常状态)"+res.getString(6));
				}
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AdminManagement adminManagement=new AdminManagement();
			adminManagement.adminManagement();
	}

}