package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
		public void userLogin(String num,String password) throws SQLException {
			
			Scanner userInput = new Scanner(System.in);
			Admin user = new Admin();
			System.out.println("1��ӭ�������Ա��¼");
			
			System.out.println("�������˺ţ�");
			String userNum = userInput.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//���ݿ�����
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
				// 4.����sql���
				//String sql = "select count(*) from user where Num = ?";
				String sql = "select *from user where Num=?";
				// ��ȡ��ȡsql���Ķ���
				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
				st.setString(1, userNum);
				ResultSet res =st.executeQuery();
				if(res.next()){
					System.out.println("���������룺");
					String userPassword = userInput.nextLine();
					if(res.getString(3).equals(userPassword)){
						if(res.getString(6).equals("1")){
							System.out.println("8��½�ɹ�");
							UserManagement userManagement=new UserManagement();
							userManagement.userManagement();
						}else{
							System.err.println("���˺��ѱ�������ʧ�޷���¼������������һ��");
							UserSystem userSystem = new UserSystem();
							userSystem.userSystem();	
						}
						
					}
					}else{
						System.err.println("���˺Ų����ڣ�������һ��");
						UserSystem userSystem = new UserSystem();
						userSystem.userSystem();				
						
					}
			//con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
		

}