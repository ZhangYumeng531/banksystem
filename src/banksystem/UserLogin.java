package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	public void userLogin() throws SQLException {
		 Scanner userInput = new Scanner(System.in);
		 User user = new User();
		 System.out.println("��ӭ�����û���¼");
		 System.out.println("�������˺ţ�");
		 user.setNum(userInput.nextLine().trim());
		 int num=0;
		 while(user.getNum().equals("")) {
			 if(num>2){
				 //������ҳ
				 System.out.println("������������࣬����������ҳ");
				 UserSystem userSystem = new UserSystem();
				 userSystem.userSystem();
			 }
			 System.err.println("�������˺�Ϊ�գ����������룺");
			 user.setNum(userInput.nextLine().trim()); 
			 num++;
		 }
		 
		 System.out.println("���������룺");
		 user.setPassword(userInput.nextLine().trim());
		 while(user.getPassword().equals("")) {			
			 System.err.println("����������Ϊ�գ����������룺");
			 user.setPassword(userInput.nextLine().trim()); 
		 }
		 if(user.getPassword().length() != 6) {
			 System.err.println("���������벻����6λ");
			 
		 }
	}
}

