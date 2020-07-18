package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	public void userLogin() throws SQLException {
		 Scanner userInput = new Scanner(System.in);
		 User user = new User();
		 System.out.println("欢迎进入用户登录");
		 System.out.println("请输入账号：");
		 user.setNum(userInput.nextLine().trim());
		 int num=0;
		 while(user.getNum().equals("")) {
			 if(num>2){
				 //跳回首页
				 System.out.println("您输入次数过多，即将跳回首页");
				 UserSystem userSystem = new UserSystem();
				 userSystem.userSystem();
			 }
			 System.err.println("您输入账号为空，请重新输入：");
			 user.setNum(userInput.nextLine().trim()); 
			 num++;
		 }
		 
		 System.out.println("请输入密码：");
		 user.setPassword(userInput.nextLine().trim());
		 while(user.getPassword().equals("")) {			
			 System.err.println("您输入密码为空，请重新输入：");
			 user.setPassword(userInput.nextLine().trim()); 
		 }
		 if(user.getPassword().length() != 6) {
			 System.err.println("您输入密码不符合6位");
			 
		 }
	}
}

