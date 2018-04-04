package abstraction06;

//은행계좌를 추상화 하자]
class Account{
	//[멤버 변수]
	String name ;//예금주
	String accountNo;//계좌번호
	int balance;//잔액
	//[멤버 메소드]
	//입금하다
	void deposite(int money){
		balance+=money;
		System.out.println(money+"가 입금 되었어요.");
		print();
	}/////////////
	//출금하다
	void withDraw(int money){
		if(balance < money){
			System.out.println("잔액이 부족해요!");
			print();
			return;
		}
		balance-=money;
		System.out.println(money+"가 출금되었어요");
		print();
	}//////////////////
	//통장정보 출력용]
	void print(){
		System.out.printf("[%s님의 계좌정보]%n",name);
		System.out.printf("계좌번호:%s%n",accountNo);
		System.out.printf("잔액:%d%n",balance);
	}
	
}

public class AccountApp {

	public static void main(String[] args) {
		//통장개설]
		Account ac1 = new Account();
		System.out.println("[멤버변수 초기화 전]");
		ac1.print();
		//멤버변수 초기화]
		ac1.name="김길동";
		ac1.balance=10000;
		ac1.accountNo="123-456";
		ac1.deposite(1000);
		ac1.withDraw(20000);
		ac1.withDraw(5000);
		
		//또 다른 통장 개설]
		Account ac2 = new Account();
		ac2.name="박길동";
		ac2.accountNo="456-789";
		ac2.balance=1000;		
		ac2.print();
		
	}

}
