package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;

public class AdminUnfreezing {
	public int adminUnfreezing()throws SQLException{
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------����˻�--------");
		System.out.println("��������Ҫ���н���������˺ţ�");
		String adminAnum = userInput.nextLine();
		System.out.println("������˺������롰1����");
		String usernewquanxian = userInput.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�����
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			// 4.����sql���
			//String sql = "select count(*) from user where Num = ?";
			String sql = "update admin set quanxian=? where anum = ?";
			// ��ȡ��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.setString(1, usernewquanxian);
		    ps.setString(2, adminAnum);
			 //ִ��sql���
		    int res = ps.executeUpdate();

			//�ж�
		    if(res==1&&usernewquanxian.equals("1")){
					System.out.println("����ɹ�");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else if(res!=1&&usernewquanxian.equals("1")){
					System.err.println("�˺Ż��������ⶳʧ�ܣ��뷵������");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else if(res==1){
					System.err.println("���ֻ�����루 1�����ʧ�ܣ��뷵������");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}else{
					System.err.println("�˺Ż�������󣬽��ֻ�����루 1�����ʧ�ܣ��뷵������");
					PresidentManagement presidentManagement=new PresidentManagement();
					presidentManagement.presidentManagement();
				}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
