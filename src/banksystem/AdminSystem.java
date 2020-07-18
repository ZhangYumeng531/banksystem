package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminSystem {
	/*public void adminSystem(){
		System.out.println("*****************************");
		System.out.println("欢迎管理员！");
		System.out.println("登陆请输入1");
		System.out.println("找回密码请输入2");
		System.out.println("返回请输入quit");
	    Scanner adminInput = new Scanner(System.in);
		String adminChange=adminInput.nextLine();
		System.out.println("*****************************");
		if(adminChange.equals(1)){
			System.out.println("欢迎登陆");
		}if(adminChange.equals(2)){
			System.out.println("欢迎进入找回密码");
		}if(adminChange.equals("quit")){
			System.out.println("反回上一级");
			Main main =new Main();
		}
	}*/
	public void adminSystem() throws SQLException {
		Scanner adminInput = new Scanner(System.in);
		 System.out.println("登录请输入1");
		 System.out.println("找回密码请输入2");
		 System.out.println("修改密码请输入3");
		 //System.out.println("进入管理员管理请输入4");
		 System.out.println("返回上一级请输入quit");
		 String adminChange = adminInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //用户登录
			 UserLogin userLogin = new UserLogin();
			 userLogin.userLogin();
		 }else if(adminChange.equals("2")) {
			 //找回密码
			 
		 }else if(adminChange.equals("3")) {
			 //修改密码
			
		 }/*else if(adminChange.equals("4")) {
			 //账户管理
			 UserManagement userManagement = new UserManagement();
			 userManagement.userManagement();
		 }*/else if(adminChange.equals("quit")) {
			 //进入初始页面
			 Login login = new Login();
			 login.Login();
		 }else {
			 System.err.println("请做出正确的输入");
			 adminSystem();
		 }
	    }

}
