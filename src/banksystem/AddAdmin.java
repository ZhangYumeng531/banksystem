package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddAdmin {
	public void addAdmin() throws SQLException{
		Scanner userInput = new Scanner(System.in);
		Admin admin=new Admin();
		System.out.println("请输入新管理员姓名:");
		admin.setAname(userInput.nextLine().trim());
		int num=1;
		while(admin.getAname().equals("")){
			if(num>2){
				System.err.println("输入用户名次数过多，即将返回......");
				PresidentManagement presidentManagement = new PresidentManagement();
				presidentManagement.presidentManagement();
			}
			System.err.println("管理员姓名输入为空请重新输入！");
			admin.setAname(userInput.nextLine().trim());
			num++;
		}
		System.out.println("请输入管理员手机号:");
		admin.setAtelephone(userInput.nextLine().trim());
		VerifyPhone verifyPhone=new VerifyPhone();
		int verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
			if(verifyPhoneNum==0){
				System.err.println("手机号输入为空请重新输入：");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==1){
				System.err.println("您输入的手机号不符合规则（11位）请重新输入：");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==2){
				System.err.println("您输入的手机号不正确请重新输入：");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==3){
			
			}
		}
		
		
		System.out.println("请输入密码（6位）:");
		admin.setApassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword=new VerifyPassword();
		int verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
		while(verifyPasswordNum==0||verifyPasswordNum==1){
			if(verifyPasswordNum==0){
				System.err.println("您输入的密码为空，请重新输入:");
				admin.setApassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
			}else if(verifyPasswordNum==1){
				System.err.println("您输入的密码长度必须为6位,请重新输入：");
				admin.setApassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
			}
					
		}
		System.out.println("请输入新管理员账号8位:");
		admin.setAnum(userInput.nextLine().trim());
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			String sql="INSERT INTO admin(anum,aname,apassword,atelephone) VALUE(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAnum());
			ps.setString(2, admin.getAname());
			ps.setString(3, admin.getApassword());
			ps.setString(4, admin.getAtelephone());
			int res =ps.executeUpdate();
			if(res!=0){
				System.out.println("添加管理员成功......");
				PresidentManagement presidentManagement=new PresidentManagement();
				presidentManagement.presidentManagement();
			}else{
				System.out.println("注册失败返回上一级......");
				PresidentManagement presidentManagement=new PresidentManagement();
				presidentManagement.presidentManagement();
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


}
