package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;
public class ChangeAdminPhone {
	public void changeAdminPhone()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------�޸Ĺ���Ա�ֻ���--------");
		System.out.println("��������Ҫ�����޸�������˺ţ�");
		String adminAnum = userInput.nextLine();
		System.out.println("���������ֻ��ţ�");
		String adminnewphone = userInput.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update admin set atelephone=? where anum = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, adminnewphone);
		    ps.setString(2, adminAnum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1){
					System.out.println("�޸Ĺ���Ա�ֻ��ųɹ�");
					AdminManagement adminManagement=new AdminManagement();
					adminManagement.adminManagement();
				}else{
					System.out.println("�޸Ĺ���Ա�ֻ���ʧ�ܣ������½����޸Ľ���");
					AdminManagement adminManagement=new AdminManagement();
					adminManagement.adminManagement();
				}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
