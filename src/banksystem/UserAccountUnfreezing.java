package banksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class UserAccountUnfreezing {
	public int userAccountUnfreezing()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------�ⶳ�˻�--------");
		System.out.println("��������Ҫ���ж���������˺ţ�");
		String userNum = userInput.nextLine();
		System.out.println("������˺������롰1����");
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
		    if(res==1&&usernewquanxian.equals(1)){
					System.out.println("�ⶳ�ɹ�");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else if(res!=1&&usernewquanxian.equals(1)){
					System.err.println("�˺Ż��������ⶳʧ�ܣ��뷵������");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else if(res==1){
					System.err.println("�ⶳֻ�����루 1���ⶳʧ�ܣ��뷵������");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}else{
					System.err.println("�˺Ż�������󣬽ⶳֻ�����루 1���ⶳʧ�ܣ��뷵������");
					ChangeUserInfo changeUserInfo=new ChangeUserInfo();
					changeUserInfo.changeUserInfo();
				}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
