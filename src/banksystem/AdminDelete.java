package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminDelete {

	public int adminDelete() throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------ɾ������Ա--------");
		System.out.println("��������Ҫ����ɾ���Ĺ���Ա�˺ţ�");
		String adminAnum = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			String sql = "delete from admin  where anum = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, adminAnum);

			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1){
					System.out.println("ɾ������Ա�ɹ�");
					AdminManagement adminManagement = new AdminManagement();
					 adminManagement.adminManagement();
				}else{
					System.err.println("ɾ������Աʧ��,�����²�����");
					AdminManagement adminManagement = new AdminManagement();
					 adminManagement.adminManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		}
	



}
