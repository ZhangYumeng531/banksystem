package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentLogin {
	
		public void presidentLogin(String bnum,String bpassword) throws SQLException {
			
			Scanner presidentInput = new Scanner(System.in);
			President president = new President();
			System.out.println("1��ӭ�������Ա��¼");
			
			System.out.println("�������˺ţ�");
			String presidentBnum = presidentInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//���ݿ�����
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.����sql���
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from boss where bnum=?";
				// ��ȡ��ȡsql���Ķ���
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, presidentBnum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("�������������룺");
					String presidentBpassword = presidentInput.nextLine();
					if(res.getString(3).equals(presidentBpassword)){
						System.out.println("8��½�ɹ�");
						PresidentManagement presidentManagement=new PresidentManagement();
						presidentManagement.presidentManagement();
					
					}else{
						System.err.println("������������µ�¼;");
						PresidentSystem presidentSystem = new PresidentSystem();
						presidentSystem.presidentSystem();						
					}
					
					}else{
						System.err.println("���˺Ų����ڣ�������һ��");
						PresidentSystem presidentSystem = new PresidentSystem();
						presidentSystem.presidentSystem();		
					}
			//con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			}
}