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
		//插入
		//输入的类
		Scanner userInput = new Scanner(System.in);
		User user=new User();
		/*System.out.print("请输入要删除的管理员账号：");
		System.out.print("请输入管理员账号：");
		String anum = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("请输入管理员名（英文）：");
		String aname = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("请输入管理员密码：");
		String apassword = userInput.nextLine();
		System.out.println("-------------------------------------");
		System.out.print("请输入手机号：");
		String atelephone = userInput.nextLine();
		System.out.println("-------------------------------------");
		
		System.out.println("管理员账号："+anum);
		System.out.println("管理员名："+aname);
		System.out.println("管理员密码："+apassword);
		System.out.println("手机号："+atelephone);
		
		System.out.println("-------------------------------------");*/
		//使用jdbc连接数据库
		
		//try{
			//1.导入jar包
			//2.注册驱动
		
			//Class.forName("com.mysql.jdbc.Driver");
			//3.获取数据连接
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			//4.定义sql语句
			//String sql="INSERT INTO admin(anum,aname,apassword,atelephone) VALUE(?,?,?,?)";
			//String sql="DELETE FROM admin WHERE anum='18044560'";
			//String sql="UPDATE admin SET apassword='123456' WHERE anum='18044562' and atelephone=18845753333";
			//String sql="SELECT * FROM admin WHERE anum='18044562'";
			//System.out.println(sql);
			//5.获取执行sql语句的对象
			//Statement st= con.createStatement();
			//PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//插入数据
			//ps.setString(1,"18044565");
			//ps.setString(2,"rose");
			//ps.setString(3,"789123");
			//ps.setString(4,"18845754444");
			//6.执行sql语句
			//ResultSet res =st.executeQuery(aql);
			//int res = st.executeUpdate(sql);
			//int res = ps.executeUpdate();
			//System.out.println(res);
			//7.查看返回结果
			//executeUpdate
			//executeQuery
			//if(res!=0){
			//	System.out.println("成功！");
			//}else{
			//	System.out.println("失败！");
			//}
			//Systen.out.println(res.next());
			//while(res.next()){
				//System.out.println(res.getInt(1));
				//System.out.println(res.getString(2));
				//System.out.println(res.getString(3));
				//System.out.println(res.getString(5));
				//System.out.println("管理员账号："+res.getString(2));
				//System.out.println("管理员名："+res.getString(2));
				//System.out.println("手机号："+res.getString(5));
			

			//}
			//8.释放资源
			//con.close();
			
		//}catch(Exception e){
			//e.printStackTrace();
		//}

	}
	

}


