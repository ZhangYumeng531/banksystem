package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
	public void userManagement() throws SQLException {
		Scanner userInput = new Scanner(System.in);
		 System.out.println("���������1");
		 System.out.println("ȡ��������2");
		 System.out.println("����ѯ������3");
		 System.out.println("����������4");
		 System.out.println("��ʧ������5");
		 System.out.println("������һ��������quit");
		 String adminChange = userInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //���
			 Deposit deposit=new Deposit();
			 deposit.deposit();
			
		 }else if(adminChange.equals("2")) {
			 //ȡ��
			 DrawMoney drawMoney=new DrawMoney();
			 drawMoney.drawMoney();
		 }else if(adminChange.equals("3")) {
			//����ѯ
			 UserBalance userBalance = new UserBalance();
			 userBalance.userBalance();

		 }else if(adminChange.equals("4")) {
			 //����
			 UserDelete userDelete = new UserDelete();
			 userDelete.userDelete();
			 
		 }else if(adminChange.equals("5")) {
			 //��ʧ
			 ReportLoss reportLoss=new ReportLoss();
			 reportLoss.reportLoss();
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