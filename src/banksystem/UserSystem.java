package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserSystem {
public void userSystem() throws SQLException {
	Scanner userInput = new Scanner(System.in);
	 System.out.println("��¼������1");
	 System.out.println("ע��������2");
	 System.out.println("�һ�����������3");
	 System.out.println("�޸�����������4");
	 System.out.println("�����˻�����������5");
	 System.out.println("������һ��������quit");
	 String adminChange = userInput.nextLine();
	 System.out.println(adminChange);
	 if(adminChange.equals("1")) {
		 //�û���¼
		 UserLogin userLogin = new UserLogin();
		 userLogin.userLogin();
	 }else if(adminChange.equals("2")) {
		 //�û�ע��
		 UserRegister userRegister = new UserRegister();
		 userRegister.userRegister();
		 
	 }else if(adminChange.equals("3")) {
		 //�һ�����
		 
	 }else if(adminChange.equals("4")) {
		 //�޸�����
		
	 }else if(adminChange.equals("5")) {
		 //�˻�����
		 UserManagement userManagement = new UserManagement();
		 userManagement.userManagement();
	 }else if(adminChange.equals("quit")) {
		 //�����ʼҳ��
		 Login login = new Login();
		 login.Login();
	 }else {
		 System.err.println("��������ȷ������");
		 userSystem();
	 }
    }
}