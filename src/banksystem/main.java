package banksystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import banksystem.model.User;

import com.mysql.jdbc.PreparedStatement;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		//�������
		Scanner userInput = new Scanner(System.in);
		User user=new User();
		/*System.out.print("������Ҫɾ���Ĺ���Ա�˺ţ�");
		System.out.print("���������Ա�˺ţ�");
		String anum = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("���������Ա����Ӣ�ģ���");
		String aname = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("���������Ա���룺");
		String apassword = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("�������ֻ��ţ�");
		String atelephone = userInput.nextLine();
		System.out.println("-------------------------------------");
		
		System.out.println("����Ա�˺ţ�"+anum);
		System.out.println("����Ա����"+aname);
		System.out.println("����Ա���룺"+apassword);
		System.out.println("�ֻ��ţ�"+atelephone);
		
		System.out.println("-------------------------------------");*/
		//ʹ��jdbc�������ݿ�
		
		//try{
			//1.����jar��
			//2.ע������
		
			//Class.forName("com.mysql.jdbc.Driver");
			//3.��ȡ��������
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			//4.����sql���
			//String sql="INSERT INTO admin(anum,aname,apassword,atelephone) VALUE(?,?,?,?)";
			//String sql="DELETE FROM admin WHERE anum='18044560'";
			//String sql="UPDATE admin SET apassword='123456' WHERE anum='18044562' and atelephone=18845753333";
			//String sql="SELECT * FROM admin WHERE anum='18044562'";
			//System.out.println(sql);
			//5.��ȡִ��sql���Ķ���
			//Statement st= con.createStatement();
			//PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//��������
			//ps.setString(1,"18044565");
			//ps.setString(2,"rose");
			//ps.setString(3,"789123");
			//ps.setString(4,"18845754444");
			//6.ִ��sql���
			//ResultSet res =st.executeQuery(aql);
			//int res = st.executeUpdate(sql);
			//int res = ps.executeUpdate();
			//System.out.println(res);
			//7.�鿴���ؽ��
			//executeUpdate
			//executeQuery
			//if(res!=0){
			//	System.out.println("�ɹ���");
			//}else{
			//	System.out.println("ʧ�ܣ�");
			//}
			//Systen.out.println(res.next());
			//while(res.next()){
				//System.out.println(res.getInt(1));
				//System.out.println(res.getString(2));
				//System.out.println(res.getString(3));
				//System.out.println(res.getString(5));
				//System.out.println("����Ա�˺ţ�"+res.getString(2));
				//System.out.println("����Ա����"+res.getString(2));
				//System.out.println("�ֻ��ţ�"+res.getString(5));
			

			//}
			//8.�ͷ���Դ
			//con.close();
			
		//}catch(Exception e){
			//e.printStackTrace();
		//}

	}
	

}


