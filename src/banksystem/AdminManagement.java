package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminManagement {
	public void adminManagement() throws SQLException {
		Scanner adminInput = new Scanner(System.in);
		 System.out.println("�޸��û���Ϣ������1");
		 System.out.println("�鿴�û���Ϣ������2");
		 System.out.println("�鿴��������Ա��Ϣ������3");
		 System.out.println("�޸Ĺ���Ա��Ϣ������4");
		 System.out.println("������һ��������quit");
		 String adminChange = adminInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //�޸��û���Ϣ
			 ChangeUserInfo changeUserInfo=new ChangeUserInfo();
			 changeUserInfo.changeUserInfo();
			
		 }else if(adminChange.equals("2")) {
			 //�鿴�û���Ϣ
			 SearchUserInfo searchUserInfo=new SearchUserInfo();
			 searchUserInfo.searchUserInfo(adminChange);
		 }else if(adminChange.equals("3")) {
			 //�鿴��������Ա��Ϣ
			 SearchAdminInfo searchAdminInfo=new SearchAdminInfo();
			 searchAdminInfo.searchAdminInfo(adminChange);
		 }else if(adminChange.equals("4")) {
			 //�޸Ĺ���Ա��Ϣ
			 ChangeAdminPhone changeAdminPhone=new ChangeAdminPhone();
			 changeAdminPhone.changeAdminPhone();
		 }else if(adminChange.equals("quit")) {
			 //�����ʼҳ��
			 AdminSystem adminSystem = new AdminSystem();
			 adminSystem.adminSystem();
		 }else {
			 System.err.println("��������ȷ������");
			 adminManagement();
		 }
	    }

}
