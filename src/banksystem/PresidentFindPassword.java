package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class PresidentFindPassword {
	public int presidentFindPassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner presidentInput = new Scanner(System.in);
		System.out.println("---------�һ�����--------");
		System.out.println("��������Ҫ�����һ�������˺ţ�");
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
				System.out.println("����Ϊ��"+res.getString(3)+"  �����µ�¼");
				PresidentSystem presidentSystem = new PresidentSystem();
				presidentSystem.presidentSystem();						
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
		return 0;
	}

}

