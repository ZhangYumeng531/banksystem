package banksystem;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentManagement {
	public void presidentManagement() throws SQLException {
		Scanner presidentInput = new Scanner(System.in);
		 System.out.println("�鿴����Ա��Ϣ������1");
		 System.out.println("����Ա��������2");
		 System.out.println("�������Ա������3");
		 System.out.println("���ӹ���Ա������4");
		 System.out.println("ɾ������Ա������5");
		 System.out.println("������һ��������quit");
		 String presidentChange = presidentInput.nextLine();
		 System.out.println(presidentChange);
		  if(presidentChange.equals("1")) {
			 //�鿴����Ա��Ϣ
			 SearchAdminInfo2 searchAdminInfo2=new SearchAdminInfo2();
			 searchAdminInfo2.searchAdminInfo2(presidentChange);
		 }else if(presidentChange.equals("2")) {
			 //���ù���Ա
			 AdminFreeze adminFreeze=new AdminFreeze();
			 adminFreeze.adminFreeze();
		 }
		 else if(presidentChange.equals("3")) {
			 //����Ա���
			 AdminUnfreezing adminUnfreezing=new AdminUnfreezing();
			 adminUnfreezing.adminUnfreezing();
		 }else if(presidentChange.equals("4")) {
			 //���ӹ���Ա
			 AddAdmin addAdmin=new AddAdmin();
			 addAdmin.addAdmin();
		 }else if(presidentChange.equals("5")) {
			 //ɾ������Ա
			 AdminDelete2 adminDelete2=new AdminDelete2();
			 adminDelete2.adminDelete2();
		 }else if(presidentChange.equals("quit")) {
			 //�����ʼҳ��
			 PresidentSystem presidentSystem = new PresidentSystem();
			 presidentSystem.presidentSystem();
		 }else {
			 System.err.println("��������ȷ������");
			 presidentManagement();
		 }
	    }

}
