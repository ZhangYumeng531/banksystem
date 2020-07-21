package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminManagement {
	public void adminManagement() throws SQLException {
		Scanner adminInput = new Scanner(System.in);
		 System.out.println("修改用户信息请输入1");
		 System.out.println("查看用户信息请输入2");
		 System.out.println("查看其他管理员信息请输入3");
		 System.out.println("修改管理员信息请输入4");
		 System.out.println("返回上一级请输入quit");
		 String adminChange = adminInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //修改用户信息
			 ChangeUserInfo changeUserInfo=new ChangeUserInfo();
			 changeUserInfo.changeUserInfo();
			
		 }else if(adminChange.equals("2")) {
			 //查看用户信息
			 SearchUserInfo searchUserInfo=new SearchUserInfo();
			 searchUserInfo.searchUserInfo(adminChange);
		 }else if(adminChange.equals("3")) {
			 //查看其他管理员信息
			 SearchAdminInfo searchAdminInfo=new SearchAdminInfo();
			 searchAdminInfo.searchAdminInfo(adminChange);
		 }else if(adminChange.equals("4")) {
			 //修改管理员信息
			 ChangeAdminPhone changeAdminPhone=new ChangeAdminPhone();
			 changeAdminPhone.changeAdminPhone();
		 }else if(adminChange.equals("quit")) {
			 //进入初始页面
			 AdminSystem adminSystem = new AdminSystem();
			 adminSystem.adminSystem();
		 }else {
			 System.err.println("请做出正确的输入");
			 adminManagement();
		 }
	    }

}
