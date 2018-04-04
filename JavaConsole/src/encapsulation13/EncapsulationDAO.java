package encapsulation13;
/*
 * EncapsulationDTO 에 저장된 데이타를
 * 가공 처리하는 로직을 갖는 클래스
 *  
 * -초기화 로직
 * -저축하는 로직
 * -인출하는로직
 * -통장 정보를 출력하는로직
 * 
 */
public class EncapsulationDAO {
	//[멤버변수]
	private EncapsulationDTO capsule = new EncapsulationDTO();
	//[멤버 메소드]
	//-초기화 로직
	public void initialize(String name,String accountNo,int balance){
		//세터를 통해서 초기화
		capsule.setAccountNo(accountNo);
		capsule.setBalance(balance);
		capsule.setName(name);
		
	}////initialize()
	//-저축하는 로직
	public void deposite(int money){
		capsule.setBalance(capsule.getBalance()+money);
		System.out.println(money+"가 입금 되었어요");
		print();
	}/////////////////deposite()
	//-인출하는로직
	public void withdraw(int money){
		if(capsule.getBalance() < money){
			System.out.println("잔액이 부족해요");
		}
		else{
			capsule.setBalance(capsule.getBalance()-money);
			System.out.println(money+"가 출금 되었어요");
		}
		print();
	}//////////withdraw(int money)
	//-통장 정보를 출력하는로직
	public void print(){
		System.out.println(String.format("[%s님의 계좌 정보]",capsule.getName()));
		System.out.println(String.format("계좌번호:%s", capsule.getAccountNo()));
		System.out.println(String.format("잔액:%d원", capsule.getBalance()));
	}
}/////////////////////////////
