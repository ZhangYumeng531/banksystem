package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
     public void Login() throws SQLException {
    	 Scanner userInput = new Scanner(System.in);
    	 System.out.println("进入管理员系统请输入1：");
    	 System.out.println("进入用户系统请输入2：");
    	 System.out.println("进入行长系统请输入3：");
    	 int loginChange = userInput.nextInt();
    	 if(loginChange == 1) {
    		 //管理系统
    		 System.out.println("欢迎管理员！");
    		 AdminSystem adminSystem = new AdminSystem();
    		 adminSystem.adminSystem();
    	  }else if(loginChange == 2) {
    		  //用户系统
    			 System.out.println("欢迎用户！");
    			UserSystem userSystem = new UserSystem();
        		 userSystem.userSystem();
    	  }else if(loginChange == 3) {
    		  //行长系统
    			 System.out.println("欢迎行长！");
    			PresidentSystem presidentSystem = new PresidentSystem();
    			presidentSystem.presidentSystem();
    		 }else {
    			 System.err.println("请输入正确选项（1 or 2 or 3）");
    			 //Login();
    		 }
    	 
     }
}
