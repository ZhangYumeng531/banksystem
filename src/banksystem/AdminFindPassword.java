package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class AdminFindPassword {
	public int adminFindPassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner adminInput = new Scanner(System.in);
		System.out.println("---------�һ�����--------");
		System.out.println("��������Ҫ�����һ�������˺ţ�");
		String adminAnum = adminInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "select *from admin where anum=?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, adminAnum);
			ResultSet res =st.executeQuery();
			if(res.next()){
				System.out.println("���룺"+res.getString(3));
				}else{
					System.err.println("���˺Ų����ڣ�������һ��");
					AdminSystem adminSystem = new AdminSystem();
					adminSystem.adminSystem();
				}
		//con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
