package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchAdminInfo {

	public void searchAdminInfo(String adminChange) throws SQLException {
		// TODO Auto-generated method stub
		 System.out.println("----------��ӭ�鿴�û���Ϣ------------");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				String sql="select *from admin";
				System.out.println(sql);
				Statement st = con.createStatement();
				
				ResultSet res = st.executeQuery(sql);
				System.out.println(res);
				
				while(res.next()) {
				System.out.println("�˺ţ�"+res.getString(1)+"\t\t ������"+res.getString(2)+ "\t\t �绰��"+res.getString(4)+ " \t\tȨ��(0Ϊ�����ã�1Ϊ����״̬)"+res.getString(5));
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
