package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
	public void userManagement() throws SQLException {
		Scanner userInput = new Scanner(System.in);
		 System.out.println("存款请输入1");
		 System.out.println("取款请输入2");
		 System.out.println("转账请输入3");
		 System.out.println("余额查询请输入4");
		 System.out.println("查看转账记录请输入5");
		 System.out.println("查看存款记录请输入6");
		 System.out.println("查看取款记录请输入7");
		 System.out.println("销户请输入8");
		 System.out.println("挂失请输入9");
		 System.out.println("返回上一级请输入quit");
		 String adminChange = userInput.nextLine();
		 System.out.println(adminChange);
		 if(adminChange.equals("1")) {
			 //存款
			
		 }else if(adminChange.equals("2")) {
			 //取款
			 
		 }else if(adminChange.equals("3")) {
			 //转账
			
		 }else if(adminChange.equals("4")) {
			//余额查询
			 UserBalance userBalance = new UserBalance();
			 userBalance.userBalance();

		 }else if(adminChange.equals("5")) {
			 //查看转账记录
			 UserTransferaccounts userTransferaccounts = new UserTransferaccounts();
			 userTransferaccounts.userTransferaccounts();
		 }else if(adminChange.equals("6")) {
			 //查看存款记录
			 UserDepositRecords userDepositRecords = new UserDepositRecords();
			 userDepositRecords.userDepositRecords();
		 }else if(adminChange.equals("7")) {
			 //查看取款记录
			 UserWithdrawRecords userWithdrawRecords = new UserWithdrawRecords();
			 userWithdrawRecords.userWithdrawRecords();
		 }else if(adminChange.equals("8")) {
			 //销户
			 UserDelete userDelete = new UserDelete();
			 userDelete.userDelete();
			 
		 }else if(adminChange.equals("9")) {
			 //挂失
			 
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