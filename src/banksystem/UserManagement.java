package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
	public void userManagement() throws SQLException {
		Scanner userInput = new Scanner(System.in);
		 System.out.println("���������1");
		 System.out.println("ȡ��������2");
		 System.out.println("ת��������3");
		 System.out.println("����ѯ������4");
		 System.out.println("�鿴ת�˼�¼������5");
		 System.out.println("�鿴����¼������6");
		 System.out.println("�鿴ȡ���¼������7");
		 System.out.println("����������8");
		 System.out.println("��ʧ������9");
		 System.out.println("������һ��������quit");
		 String adminChange = userInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //���
			
		 }else if(adminChange.equals("2")) {
			 //ȡ��
			 
		 }else if(adminChange.equals("3")) {
			 //ת��
			
		 }else if(adminChange.equals("4")) {
			//����ѯ
			 UserBalance userBalance = new UserBalance();
			 userBalance.userBalance();

		 }else if(adminChange.equals("5")) {
			 //�鿴ת�˼�¼
			 UserTransferaccounts userTransferaccounts = new UserTransferaccounts();
			 userTransferaccounts.userTransferaccounts();
		 }else if(adminChange.equals("6")) {
			 //�鿴����¼
			 UserDepositRecords userDepositRecords = new UserDepositRecords();
			 userDepositRecords.userDepositRecords();
		 }else if(adminChange.equals("7")) {
			 //�鿴ȡ���¼
			 UserWithdrawRecords userWithdrawRecords = new UserWithdrawRecords();
			 userWithdrawRecords.userWithdrawRecords();
		 }else if(adminChange.equals("8")) {
			 //����
			 UserDelete userDelete = new UserDelete();
			 userDelete.userDelete();
			 
		 }else if(adminChange.equals("9")) {
			 //��ʧ
			 
		 }else if(adminChange.equals("quit")) {
			 //�����ʼҳ��
			 UserSystem userSystem = new UserSystem();
			 userSystem.userSystem();
		 }else {
			 System.err.println("��������ȷ������:");
			 userManagement();
		 }
	    }


}