package banksystem;
import java.math.BigDecimal;
public class User {
	private String Num;
	private String Name;
	private String password;
	private String telephone;
	private int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	private String quanxian;
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
		
}