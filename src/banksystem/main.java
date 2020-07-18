package banksystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("------------欢迎使用银行管理系统-----------");
		Login login = new Login();
		login.Login();

	}

}

