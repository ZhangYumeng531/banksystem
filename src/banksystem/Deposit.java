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
		System.out.println("---------���--------");
		System.out.println("��������Ҫ���д����˺ţ�");
		String userNum = userInput.nextLine();
		System.out.println("���������");
		BigDecimal usernewbalance = userInput.nextBigDecimal();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update user set balance=balance+? where Num = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setBigDecimal(1, usernewbalance);
		    ps.setString(2, userNum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1){
		    
					System.out.println("���ɹ�");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else{
					System.err.println("���ʧ��,�����½��ף�");
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
