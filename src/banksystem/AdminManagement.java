package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminManagement {
	public void adminManagement() throws SQLException {
		Scanner adminInput = new Scanner(System.in);
		 System.out.println("�޸��û���Ϣ������1");
		 System.out.println("�鿴�û���Ϣ������2");
		 System.out.println("�˻�����������3");
		 System.out.println("�˻��ⶳ������4");
		 System.out.println("�鿴��������Ա��Ϣ������5");
		 System.out.println("�޸Ĺ���Ա��Ϣ������6");
		 System.out.println("������һ��������quit");
		 String adminChange = adminInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //�޸��û���Ϣ
			
		 }else if(adminChange.equals("2")) {
			 //�鿴�û���Ϣ
			 
		 }else if(adminChange.equals("3")) {
			 //�˻�����
			
		 }else if(adminChange.equals("4")) {
			 //�˻��ⶳ
			 
		 }else if(adminChange.equals("5")) {
			 //�鿴��������Ա��Ϣ
			 
		 }else if(adminChange.equals("6")) {
			 //�޸Ĺ���Ա��Ϣ
			 
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
