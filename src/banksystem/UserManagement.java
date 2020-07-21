package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
	public void userManagement() throws SQLException {
		Scanner userInput = new Scanner(System.in);
		 System.out.println("存款请输入1");
		 System.out.println("取款请输入2");
		 System.out.println("余额查询请输入3");
		 System.out.println("销户请输入4");
		 System.out.println("挂失请输入5");
		 System.out.println("返回上一级请输入quit");
		 String adminChange = userInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //存款
			 Deposit deposit=new Deposit();
			 deposit.deposit();
			
		 }else if(adminChange.equals("2")) {
			 //取款
			 DrawMoney drawMoney=new DrawMoney();
			 drawMoney.drawMoney();
		 }else if(adminChange.equals("3")) {
			//余额查询
			 UserBalance userBalance = new UserBalance();
			 userBalance.userBalance();

		 }else if(adminChange.equals("4")) {
			 //销户
			 UserDelete userDelete = new UserDelete();
			 userDelete.userDelete();
			 
		 }else if(adminChange.equals("5")) {
			 //挂失
			 ReportLoss reportLoss=new ReportLoss();
			 reportLoss.reportLoss();
		 }else if(adminChange.equals("quit")) {
			 //进入初始页面
			 UserSystem userSystem = new UserSystem();
			 userSystem.userSystem();
		 }else {
			 System.err.println("请做出正确的输入:");
			 userManagement();
		 }
	    }


}