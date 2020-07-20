package banksystem;

public class VerifyPassword {
	public int verifyPassword(String password) {
		if(password.equals("")){
			
			return 0;
		}
		else if(password.length()!=6){
			return 1;
		}
		return 2;
	}

}
