package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class UserFindPassword {
	public int userFindPassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner adminInput = new Scanner(System.in);
		System.out.println("---------�һ�����--------");
		System.out.println("��������Ҫ�����һ�������˺ţ�");
		String userNum = adminInput.nextLine();
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
				System.out.println("����Ϊ��"+res.getString(3)+"  �����µ�¼");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
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
		return 0;
	}

}
