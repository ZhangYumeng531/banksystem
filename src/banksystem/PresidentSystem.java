package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentSystem {
	public void presidentSystem() throws SQLException {
		System.out.println("*****************************");
		System.out.println("��ӭ�����г�����");
		System.out.println("��½������1");
		System.out.println("�һ�����������2");
		System.out.println("�޸�����������3");
		System.out.println("����������quit");
	    Scanner presidentInput = new Scanner(System.in);
		String presidentChange=presidentInput.nextLine();
		System.out.println("*****************************");
		 System.out.println(presidentChange);
		 if(presidentChange.equals("1")) {
			 //�г���¼
			 PresidentLogin presidentLogin = new PresidentLogin();
			 presidentLogin.presidentLogin(presidentChange, presidentChange);
		 }else if(presidentChange.equals("2")) {
			 //�һ�����
			 PresidentFindPassword presidentFindPassword=new PresidentFindPassword();
			 presidentFindPassword.presidentFindPassword();
		 }else if(presidentChange.equals("3")) {
			 //�޸�����
			 PrsidentChangePassword prsidentChangePassword = new PrsidentChangePassword();
			 prsidentChangePassword.prsidentChangePassword();
		 }else if(presidentChange.equals("quit")) {
			 //�����ʼҳ��
			 Login login = new Login();
			 login.Login();
		 }else {
			 System.err.println("��������ȷ������");
			 presidentSystem();
		 }
	    }

}