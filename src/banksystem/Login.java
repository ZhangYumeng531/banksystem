package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
     public void Login() throws SQLException {
    	 Scanner userInput = new Scanner(System.in);
    	 System.out.println("�������Աϵͳ������1��");
    	 System.out.println("�����û�ϵͳ������2��");
    	 System.out.println("�����г�ϵͳ������3��");
    	 int loginChange = userInput.nextInt();
    	 if(loginChange == 1) {
    		 //����ϵͳ
    		 System.out.println("��ӭ����Ա��");
    		 AdminSystem adminSystem = new AdminSystem();
    		 adminSystem.adminSystem();
    	  }else if(loginChange == 2) {
    		  //�û�ϵͳ
    			 System.out.println("��ӭ�û���");
    			UserSystem userSystem = new UserSystem();
        		 userSystem.userSystem();
    	  }else if(loginChange == 3) {
    		  //�г�ϵͳ
    			 System.out.println("��ӭ�г���");
    			PresidentSystem presidentSystem = new PresidentSystem();
    			presidentSystem.presidentSystem();
    		 }else {
    			 System.err.println("��������ȷѡ�1 or 2 or 3��");
    			 //Login();
    		 }
    	 
     }
}
