package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class ReportLoss {
	public int reportLoss()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------��ʧ--------");
		System.out.println("�����������˺ţ�");
		String userNum = userInput.nextLine();
		System.out.println("����ʧ�����롰0����");
		String usernewquanxian = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update user set quanxian=? where Num = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, usernewquanxian);
		    ps.setString(2, userNum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1&&usernewquanxian.equals("0")){
					System.out.println("��ʧ�ɹ�");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else if(res!=1&&usernewquanxian.equals("0")){
					System.err.println("�˺Ż���������ʧʧ�ܣ��뷵������");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else if(res==1){
					System.err.println("��ʧֻ�����루 0����ʧʧ�ܣ��뷵������");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}else{
					System.err.println("�˺Ż�������󣬹�ʧֻ�����루 0����ʧʧ�ܣ��뷵������");
					UserManagement userManagement=new UserManagement();
					userManagement.userManagement();
				}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
