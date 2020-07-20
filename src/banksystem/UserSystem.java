package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserSystem {
public void userSystem() throws SQLException {
	Scanner userInput = new Scanner(System.in);
	 System.out.println("登录请输入1");
	 System.out.println("注册请输入2");
	 System.out.println("找回密码请输入3");
	 System.out.println("修改密码请输入4");
	 System.out.println("进行账户管理请输入5");
	 System.out.println("返回上一级请输入quit");
	 String adminChange = userInput.nextLine();
	 System.out.println(adminChange);
	 if(adminChange.equals("1")) {
		 //用户登录
		 UserLogin userLogin = new UserLogin();
		 userLogin.userLogin();
	 }else if(adminChange.equals("2")) {
		 //用户注册
		 UserRegister userRegister = new UserRegister();
		 userRegister.userRegister();
		 
	 }else if(adminChange.equals("3")) {
		 //找回密码
		 
	 }else if(adminChange.equals("4")) {
		 //修改密码
		
	 }else if(adminChange.equals("5")) {
		 //账户管理
		 UserManagement userManagement = new UserManagement();
		 userManagement.userManagement();
	 }else if(adminChange.equals("quit")) {
		 //进入初始页面
		 Login login = new Login();
		 login.Login();
	 }else {
		 System.err.println("请做出正确的输入");
		 userSystem();
	 }
    }
}