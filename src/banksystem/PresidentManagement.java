package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentManagement {
	public void presidentManagement() throws SQLException {
		Scanner presidentInput = new Scanner(System.in);
		 System.out.println("查看管理员信息请输入1");
		 System.out.println("管理员禁用输入2");
		 System.out.println("解禁管理员请输入3");
		 System.out.println("增加管理员请输入4");
		 System.out.println("删除管理员请输入5");
		 System.out.println("返回上一级请输入quit");
		 String presidentChange = presidentInput.nextLine();
		 System.out.println(presidentChange);
		  if(presidentChange.equals("1")) {
			 //查看管理员信息
			 SearchAdminInfo2 searchAdminInfo2=new SearchAdminInfo2();
			 searchAdminInfo2.searchAdminInfo2(presidentChange);
		 }else if(presidentChange.equals("2")) {
			 //禁用管理员
			 AdminFreeze adminFreeze=new AdminFreeze();
			 adminFreeze.adminFreeze();
		 }
		 else if(presidentChange.equals("3")) {
			 //管理员解禁
			 AdminUnfreezing adminUnfreezing=new AdminUnfreezing();
			 adminUnfreezing.adminUnfreezing();
		 }else if(presidentChange.equals("4")) {
			 //增加管理员
			 AddAdmin addAdmin=new AddAdmin();
			 addAdmin.addAdmin();
		 }else if(presidentChange.equals("5")) {
			 //删除管理员
			 AdminDelete2 adminDelete2=new AdminDelete2();
			 adminDelete2.adminDelete2();
		 }else if(presidentChange.equals("quit")) {
			 //进入初始页面
			 PresidentSystem presidentSystem = new PresidentSystem();
			 presidentSystem.presidentSystem();
		 }else {
			 System.err.println("请做出正确的输入");
			 presidentManagement();
		 }
	    }

}
