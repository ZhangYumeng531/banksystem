package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class ChangeUserPhone {

	public static int changeUserPhone() throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------�޸��û��ֻ���--------");
		System.out.println("��������Ҫ�����޸ĵ��˺ţ�");
		String userNum = userInput.nextLine();
		System.out.println("���������ֻ��ţ�");
		String usernewtelephone = userInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update user set telephone=? where Num = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, usernewtelephone);
		    ps.setString(2, userNum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1){
					System.out.println("�ɹ�");
				}else{
					System.out.println("ʧ��");
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
