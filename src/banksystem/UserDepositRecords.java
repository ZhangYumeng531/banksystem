package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDepositRecords {

	public void userDepositRecords () throws SQLException{
		// TODO Auto-generated method stub
		 System.out.println("----------»¶Ó­²é¿´´æ¿î¼ÇÂ¼------------");
		 
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				String sql="select *from ck";
				//System.out.println(sql);
				Statement st = con.createStatement();
				
				ResultSet res = st.executeQuery(sql);
				System.out.println(res);
				while(res.next()) {
				System.out.println("ÕËºÅ£º"+res.getString(1)+"ÐÕÃû£º"+res.getString(2)+ "½ð¶î£º"+res.getString(3)+ "Óà¶î"+res.getString(4));
				}
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}

