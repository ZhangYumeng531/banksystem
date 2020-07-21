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
		System.out.println("��ӭ����ע��");
		System.out.println("�������û���:");
		user.setName(userInput.nextLine().trim());
		int num=1;
		while(user.getName().equals("")){
			if(num>2){
				System.err.println("�����û����������࣬���������û�ѡ�����......");
				UserSystem userSystem=new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("�û�������Ϊ�����������룡");
			user.setName(userInput.nextLine().trim());
			num++;
		}
		System.out.println("�������ֻ���:");
		user.setTelephone(userInput.nextLine().trim());
		VerifyPhone verifyPhone=new VerifyPhone();
		int verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
			if(verifyPhoneNum==0){
				System.err.println("�ֻ�������Ϊ�����������룺");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==1){
				System.err.println("��������ֻ��Ų����Ϲ���11λ�����������룺");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==2){
				System.err.println("��������ֻ��Ų���ȷ���������룺");
				user.setTelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(user.getTelephone());
			}else if(verifyPhoneNum==3){
			
			}
		}
		
		
		System.out.println("���������루6λ��:");
		user.setPassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword=new VerifyPassword();
		int verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
		while(verifyPasswordNum==0||verifyPasswordNum==1){
			if(verifyPasswordNum==0){
				System.err.println("�����������Ϊ�գ�����������:");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			}else if(verifyPasswordNum==1){
				System.err.println("����������볤�ȱ���Ϊ6λ,���������룺");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			}
					
		}
		System.out.println("���ٴ���������:");
		String verifyConfirm=userInput.nextLine().trim();
		while(!user.getPassword().equals(verifyConfirm)){
			System.err.println("������������벻һ�£��������������룺");
			user.setPassword(userInput.nextLine().trim());
			 verifyPassword=new VerifyPassword();
			 verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
			while(verifyPasswordNum==0||verifyPasswordNum==1){
				if(verifyPasswordNum==0){
					System.err.println("�����������Ϊ�գ��������������룺");
					user.setPassword(userInput.nextLine().trim());
					verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
				}else if(verifyPasswordNum==1){
					System.err.println("����������볤�ȱ���Ϊ6λ�����������룺");
					user.setPassword(userInput.nextLine().trim());
					verifyPasswordNum=verifyPassword.verifyPassword(user.getPassword());
				}
						
			}
			System.out.println("���ٴ���������:");
			verifyConfirm=userInput.nextLine();
		}
		
	
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss:SSS");//���ڵĸ�ʽ
		String time = sdf.format(new Date());//��ȡ��ǰʱ��
		String delTime = time.replaceAll("-", "");//ɾ���ַ����е�"-"
		String reDelTime = delTime.replaceAll(":", "");//ɾ���ַ����е�":"
		StringBuilder account = new StringBuilder(reDelTime);//ɾ�����ź�õ����˺�
		account.replace(reDelTime.length()-1, reDelTime.length(),"");//ɾ���˺ŵ����һλ
		String ac = account + "";
		System.out.println("����:"+ac);	
		
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
				System.out.println("ע��ɹ���ת��¼ҳ��......");
				UserLogin userLogin=new UserLogin();
				userLogin.userLogin(ac, ac);
			}else{
				System.out.println("ע��ʧ�ܷ�����һ��......");
				UserSystem userSystem=new UserSystem();
				userSystem.userSystem();
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
	}

}
