package banksystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserBalance {

	public void userBalance() throws SQLException {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("---------”‡∂Ó≤È—Ø--------");
		System.out.println("«Î ‰»Îƒ˙“™Ω¯––”‡∂Ó≤È—Øµƒ’À∫≈£∫");
		String userNum = userInput.nextLine();
	    System.out.println(userNum);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_sm","root","root");
			String sql="select balance from user where Num = ?";
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
		    ps.setString(1,userNum );
			
			ResultSet res = ps.executeQuery();
			//System.out.println(res);
			while(res.next()) {
			System.out.println("”‡∂Ó"+res.getString(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
