package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminSystem {
	/*public void adminSystem(){
		System.out.println("*****************************");
		System.out.println("��ӭ����Ա��");
		System.out.println("��½������1");
		System.out.println("�һ�����������2");
		System.out.println("����������quit");
	    Scanner adminInput = new Scanner(System.in);
		String adminChange=adminInput.nextLine();
		System.out.println("*****************************");
		if(adminChange.equals(1)){
			System.out.println("��ӭ��½");
		}if(adminChange.equals(2)){
			System.out.println("��ӭ�����һ�����");
		}if(adminChange.equals("quit")){
			System.out.println("������һ��");
			Main main =new Main();
		}
	}*/
	public void adminSystem() throws SQLException {
		Scanner adminInput = new Scanner(System.in);
		 System.out.println("��¼������1");
		 System.out.println("�һ�����������2");
		 System.out.println("�޸�����������3");
		 //System.out.println("�������Ա����������4");
		 System.out.println("������һ��������quit");
		 String adminChange = adminInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //�û���¼
			 UserLogin userLogin = new UserLogin();
			 userLogin.userLogin();
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
