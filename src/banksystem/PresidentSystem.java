package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentSystem {
	public void presidentSystem() throws SQLException {
		System.out.println("*****************************");
		System.out.println("欢迎进入行长管理！");
		System.out.println("登陆请输入1");
		System.out.println("找回密码请输入2");
		System.out.println("修改密码请输入3");
		System.out.println("返回请输入quit");
	    Scanner presidentInput = new Scanner(System.in);
		String presidentChange=presidentInput.nextLine();
		System.out.println("*****************************");
		 System.out.println(presidentChange);
		 if(presidentChange.equals("1")) {
			 //行长登录
			 PresidentLogin presidentLogin = new PresidentLogin();
			 presidentLogin.presidentLogin(presidentChange, presidentChange);
		 }else if(presidentChange.equals("2")) {
			 //找回密码
			 PresidentFindPassword presidentFindPassword=new PresidentFindPassword();
			 presidentFindPassword.presidentFindPassword();
		 }else if(presidentChange.equals("3")) {
			 //修改密码
			 PrsidentChangePassword prsidentChangePassword = new PrsidentChangePassword();
			 prsidentChangePassword.prsidentChangePassword();
		 }else if(presidentChange.equals("quit")) {
			 //进入初始页面
			 Login login = new Login();
			 login.Login();
		 }else {
			 System.err.println("请做出正确的输入");
			 presidentSystem();
		 }
	    }

}