package banksystem;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPhone {
	public int verifyPhone(String telephone) {
		
		if(telephone.equals("")){
			return 0;
		}
		else if(telephone.length()!=11){
			System.err.println("��������ֻ��Ų����Ϲ���11λ�����������룡");
			return 1;
		}else{
			String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
			Pattern p =Pattern.compile(regex);
			Matcher m=p.matcher(telephone);
			boolean isMatch = m.matches();
			if(!isMatch){
				return 2;
			}else{
				return 3;
			}
			
		}
		
	}

}
