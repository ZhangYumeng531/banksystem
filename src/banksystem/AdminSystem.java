package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminSystem {
	public void adminSystem() throws SQLException {
		System.out.println("*****************************");
		System.out.println("��ӭ����Ա��");
		System.out.println("��½������1");
		System.out.println("�һ�����������2");
		System.out.println("����������quit");
	    Scanner adminInput = new Scanner(System.in);
		String adminChange=adminInput.nextLine();
		System.out.println("*****************************");
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //����Ա��¼
			 AdminLogin adminLogin = new AdminLogin();
			 adminLogin.adminLogin(adminChange, adminChange);
		 }else if(adminChange.equals("2")) {
			 //�һ�����
			 
		 }else if(adminChange.equals("3")) {
			 //�޸�����
			
		 }/*else if(adminChange.equals("4")) {
			 //�˻�����
			 UserManagement userManagement = new UserManagement();
			 userManagement.userManagement();
		 }*/else if(adminChange.equals("quit")) {
			 //�����ʼҳ��
			 Login login = new Login();
			 login.Login();
		 }else {
			 System.err.println("��������ȷ������");
			 adminSystem();
		 }
	    }

}
