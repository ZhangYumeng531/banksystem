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
		System.out.println("�������¹���Ա����:");
		admin.setAname(userInput.nextLine().trim());
		int num=1;
		while(admin.getAname().equals("")){
			if(num>2){
				System.err.println("�����û����������࣬��������......");
				PresidentManagement presidentManagement = new PresidentManagement();
				presidentManagement.presidentManagement();
			}
			System.err.println("����Ա��������Ϊ�����������룡");
			admin.setAname(userInput.nextLine().trim());
			num++;
		}
		System.out.println("���������Ա�ֻ���:");
		admin.setAtelephone(userInput.nextLine().trim());
		VerifyPhone verifyPhone=new VerifyPhone();
		int verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum==0||verifyPhoneNum==1||verifyPhoneNum==2){
			if(verifyPhoneNum==0){
				System.err.println("�ֻ�������Ϊ�����������룺");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==1){
				System.err.println("��������ֻ��Ų����Ϲ���11λ�����������룺");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==2){
				System.err.println("��������ֻ��Ų���ȷ���������룺");
				admin.setAtelephone(userInput.nextLine().trim());
				verifyPhoneNum=verifyPhone.verifyPhone(admin.getAtelephone());
			}else if(verifyPhoneNum==3){
			
			}
		}
		
		
		System.out.println("���������루6λ��:");
		admin.setApassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword=new VerifyPassword();
		int verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
		while(verifyPasswordNum==0||verifyPasswordNum==1){
			if(verifyPasswordNum==0){
				System.err.println("�����������Ϊ�գ�����������:");
				admin.setApassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
			}else if(verifyPasswordNum==1){
				System.err.println("����������볤�ȱ���Ϊ6λ,���������룺");
				admin.setApassword(userInput.nextLine().trim());
				verifyPasswordNum=verifyPassword.verifyPassword(admin.getApassword());
			}
					
		}
		System.out.println("�������¹���Ա�˺�8λ:");
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
				System.out.println("��ӹ���Ա�ɹ�......");
				PresidentManagement presidentManagement=new PresidentManagement();
				presidentManagement.presidentManagement();
			}else{
				System.out.println("ע��ʧ�ܷ�����һ��......");
				PresidentManagement presidentManagement=new PresidentManagement();
				presidentManagement.presidentManagement();
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


}
