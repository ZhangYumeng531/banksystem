package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTransferaccounts {

	public void userTransferaccounts() throws SQLException {
		// TODO Auto-generated method stub
		 System.out.println("----------��ӭ�鿴ת�˼�¼------------");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				String sql="select *from zz";
				System.out.println(sql);
				Statement st = con.createStatement();
				
				ResultSet res = st.executeQuery(sql);
				System.out.println(res);
				
				while(res.next()) {
				System.out.println("�˺ţ�"+res.getString(1)+" ������"+res.getString(2)+ " Ŀ���˺ţ�"+res.getString(3)+ " ����"+res.getString(4)+ " ���"+res.getString(5));
				}
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}