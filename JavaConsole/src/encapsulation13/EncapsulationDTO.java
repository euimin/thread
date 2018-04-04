package encapsulation13;

public class EncapsulationDTO {
	//[멤버변수]
	private String name;//예금주]
	private String accountNo;//계좌번호]
	private int balance;//잔액]
	
	//GETTER 메소드]
	public String getName(){
		return name;
	}	
	public String getAccountNo() {
		return accountNo;
	}
	public int getBalance() {
		
		return balance;
	}	
	//SETTER 메소드]
	public void setName(String n){
		
		name = n;
	}
	public void setAccountNo(String accNo) {
		accountNo = accNo;
	}
	public void setBalance(int bal) {
		
		balance = bal;
	}

}
