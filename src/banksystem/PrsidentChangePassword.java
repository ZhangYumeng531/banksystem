package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class PrsidentChangePassword {

	public int prsidentChangePassword() throws SQLException{
		// TODO Auto-generated method stub
		Scanner adminInput = new Scanner(System.in);
		System.out.println("---------�޸�����--------");
		System.out.println("��������Ҫ�����޸�������˺ţ�");
		String prsidentBnum = adminInput.nextLine();
		System.out.println("�����������룺");
		String prsidentnewpassword = adminInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update boss set bpassword=? where bnum = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, prsidentnewpassword);
		    ps.setString(2, prsidentBnum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1){
					System.out.println("�г������޸ĳɹ�");
					PresidentSystem presidentSystem = new PresidentSystem();
					presidentSystem.presidentSystem();						
				}else{
					System.err.println("�г������޸�ʧ��");
					PresidentSystem presidentSystem = new PresidentSystem();
					presidentSystem.presidentSystem();				
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

