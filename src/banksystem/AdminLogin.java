package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	public void adminLogin() throws SQLException {
		 Scanner adminInput = new Scanner(System.in);
		 Admin admin = new Admin();
		 System.out.println("��ӭ�������Ա��¼");
		 System.out.println("�������˺ţ�");
		 admin.setAnum(adminInput.nextLine().trim());
		 int num=0;
		 while(admin.getAnum().equals("")) {
			 if(num>2){
				 //������ҳ
				 System.out.println("������������࣬����������ҳ");
				 AdminSystem adminSystem = new AdminSystem();
				 adminSystem.adminSystem();
			 }
			 System.err.println("�������˺�Ϊ�գ����������룺");
			 admin.setAnum(adminInput.nextLine().trim()); 
			 num++;
		 }
		 
		 System.out.println("���������룺");
		 admin.setApassword(adminInput.nextLine().trim());
		 while(admin.getApassword().equals("")) {			
			 System.err.println("����������Ϊ�գ����������룺");
			 admin.setApassword(adminInput.nextLine().trim()); 
		 }
		 if(admin.getApassword().length() != 6) {
			 System.err.println("���������벻����6λ");
			 
		 }
	}

}
