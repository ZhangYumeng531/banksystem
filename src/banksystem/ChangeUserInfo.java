package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangeUserInfo {
	public void changeUserInfo() throws SQLException{
		System.out.println("*****************************");
		System.out.println("欢迎进行用户修改");
		System.out.println("用户冻结请输入1");
		System.out.println("用户解冻请输入2");
		System.out.println("用户修改手机号请输入3");
		System.out.println("返回请输入quit");
	    Scanner adminInput = new Scanner(System.in);
		String adminChange=adminInput.nextLine();
		System.out.println("*****************************");
		 if(adminChange.equals("1")) {
			 //用户冻结
			 UserAccountFreeze userAccountFreeze=new UserAccountFreeze();
			 userAccountFreeze.userAccountFreeze();
			
		 }else if(adminChange.equals("2")) {
			 //用户解冻
			 UserAccountUnfreezing userAccountUnfreezing=new UserAccountUnfreezing();
			 userAccountUnfreezing.userAccountUnfreezing();
		 }else if(adminChange.equals("3")) {
			 //修改用户手机号
			 ChangeUserPhone changeAdminPhone=new ChangeUserPhone();
			 ChangeUserPhone.changeUserPhone();
			
		 }else if(adminChange.equals("quit")) {
			 //进入初始页面
			 AdminManagement adminManagement = new AdminManagement();
			 adminManagement.adminManagement();
		 }else {
			 System.err.println("请做出正确的输入");
			 changeUserInfo();
		 }
		
	}

}
