package banksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserRegister {
	public void userRegister() throws SQLException{
		Scanner userInput = new Scanner(System.in);
		User user=new User();
		System.out.println("欢迎进入注册");
		System.out.println("请输入用户名:");
		user.setName(userInput.nextLine().trim());
		int num=1;
		while(user.getName().equals("")){
			if(num>2){
				System.err.println("输入用户名次数过多，即将返回用户选择界面......");
				UserSystem userSystem=new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("用户名输入为空请重新输入！");
			user.setName(userInput.nextLine().trim());
			num++;
		}
		System.out.println("请输入手机号:");
		user.setTelephone(userInput.nextLine().trim());
		VerifyPhone verifyPhone=new VerifyPhone();
		int verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
			if(verifyPhoneNum==0){
				System.err.println("手机号输入为空请重新输入：");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==1){
				System.err.println("您输入的手机号不符合规则（11位）请重新输入：");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==2){
				System.err.println("您输入的手机号不正确请重新输入：");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==3){
			
			}
		}
		
		
		System.out.println("请输入密码（6位）:");
		user.setPassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword=new VerifyPassword();
		int verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
		while(verifyPasswordNum==0||verifyPasswordNum==1){
			if(verifyPasswordNum==0){
				System.err.println("您输入的密码为空，请重新输入:");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			}else if(verifyPasswordNum==1){
				System.err.println("您输入的密码长度必须为6位,请重新输入：");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			}
					
		}
		System.out.println("请再次输入密码:");
		String verifyConfirm=userInput.nextLine().trim();
		while(!user.getPassword().equals(verifyConfirm)){
			System.err.println("两次输入的密码不一致，请重新输入密码：");
			user.setPassword(userInput.nextLine().trim());
			 verifyPassword=new VerifyPassword();
			 verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			while(verifyPasswordNum==0||verifyPasswordNum==1){
				if(verifyPasswordNum==0){
					System.err.println("您输入的密码为空，请重新输入密码：");
					user.setPassword(userInput.nextLine().trim());
					verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
				}else if(verifyPasswordNum==1){
					System.err.println("您输入的密码长度必须为6位，请重新输入：");
					user.setPassword(userInput.nextLine().trim());
					verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
				}
						
			}
			System.out.println("请再次输入密码:");
			verifyConfirm=userInput.nextLine();
		}
		
	
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss:SSS");//日期的格式
		String time = sdf.format(new Date());//获取当前时间
		String delTime = time.replaceAll("-", "");//删除字符串中的"-"
		String reDelTime = delTime.replaceAll(":", "");//删除字符串中的":"
		StringBuilder account = new StringBuilder(reDelTime);//删除符号后得到的账号
		account.replace(reDelTime.length()-1, reDelTime.length(),"");//删除账号的最后一位
		String ac = account + "";
		System.out.println("卡号:"+ac);	
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			String sql="INSERT INTO user(Num,Name,password,telephone) VALUE(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ac);
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getTelephone());
			int res =ps.executeUpdate();
			if(res!=0){
				System.out.println("注册成功跳转登录页面......");
				UserLogin userLogin=new UserLogin();
				userLogin.userLogin(ac, ac);
			}else{
				System.out.println("注册失败返回上一级......");
				UserSystem userSystem=new UserSystem();
				userSystem.userSystem();
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
	}

}
