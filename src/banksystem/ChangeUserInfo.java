package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangeUserInfo {
	public void changeUserInfo() throws SQLException{
		System.out.println("*****************************");
		System.out.println("��ӭ�����û��޸�");
		System.out.println("�û�����������1");
		System.out.println("�û��ⶳ������2");
		System.out.println("�û��޸��ֻ���������3");
		System.out.println("����������quit");
	    Scanner adminInput = new Scanner(System.in);
		String adminChange=adminInput.nextLine();
		System.out.println("*****************************");
		 if(adminChange.equals("1")) {
			 //�û�����
			 UserAccountFreeze userAccountFreeze=new UserAccountFreeze();
			 userAccountFreeze.userAccountFreeze();
			
		 }else if(adminChange.equals("2")) {
			 //�û��ⶳ
			 UserAccountUnfreezing userAccountUnfreezing=new UserAccountUnfreezing();
			 userAccountUnfreezing.userAccountUnfreezing();
		 }else if(adminChange.equals("3")) {
			 //�޸��û��ֻ���
			 ChangeUserPhone changeAdminPhone=new ChangeUserPhone();
			 ChangeUserPhone.changeUserPhone();
			
		 }else if(adminChange.equals("quit")) {
			 //�����ʼҳ��
			 AdminManagement adminManagement = new AdminManagement();
			 adminManagement.adminManagement();
		 }else {
			 System.err.println("��������ȷ������");
			 changeUserInfo();
		 }
		
	}

}
