package operator02;
class Ref{
	
	int data=100;
	
	
}
public class NolliOP {

	public static void main(String[] args) {
		/*
		 * -논리연산자(이항연산자)의 결과값은 true,false이다.
		 * &&: and연산자(논리곱) 두 항이 참일때만 참이다 
		 *     (~그리고)
		 * ||: or연산자(논리합) 두 항중의 하나라도 
		 *     참이면 참(~또는 ,혹은)
		 * !(단항연산자): not연산자(논리부정) 단항이 참이면 거짓,
		 *                거짓이면 참(~아니다)
		 * 
		 * ^(이항연산자):xor연산자(배타) 두 항이 서로 배타적일때 참
		 *               두 항이 서로 같으면 거짓
		 * 
		 *-논리연산자의 우선 순위: ! > && > ||,^
		 * 
		 *- && 와 &,|| 와 | 는 둘다 결과값이 같다
		 * 
		 *-&&는 첫째항이 거짓이면 두번째항은 계산안한다
		 *-&는 첫째항이 거짓이더라도 두번째항을 계산한다
		 * 
		 * -산술 > 비교 >논리연산자순으로 우선순위가 적용됨.
		 */
		
		int num1 =15,num2=10;
		boolean result = num1 >= num2 && num1 == num2;
		System.out.printf("%d >= %d && %d == %d의 결과:%b%n",num1,num2,num1,num2,result);
		
		result = true || false;
		System.out.printf("%b || %b의 결과:%b%n",true,false,result);
		//논리 연산자(&&,||,!,^)의 각 항에는 반드시 true나false값을
		//갖는 식(비교식)이거나 true,false값이여야 한다.
				
		//result = num1+num2 && num1==num2;//[x]
		result = num1 <= num2 ^ num1 != num2; 	
		//printf와 같은 기능을 하는 메소드:
		//format("형식문자열",콤마로 구분해서 값나열)
		System.out.format("%d <= %d ^ %d != %d의 결과:%b%n",num1,num2,num1,num2,result);
		
		result= !(num1 !=num2) || num1 >=num2 && num1 == num2;
		/*
		 * 1](num1 != num2) = true
		 * 2] !true = false
		 * 3] num1 >=num2 = true
		 * 4]num1 == num2 =false
		 * 중간정리] false || true && false
		 * 5]true && false= false
		 * false || false = false
		 */
		System.out.println("result="+result);
		result= 5*2%3 > 6-2*2 && 10 <= 6*2 || 5*3 !=10 ;
		/*
		 * 1]5*2%3 =1
		 * 2]2*2=4
		 * 3]6*2 =12
		 * 4]5*3 =15
		 * 중간] 1 > 2 && 10 <= 12 || 15 !=10
		 * 5]1 > 2 =false
		 * 6]10 <= 12 = true
		 * 7]15 !=10 =true
		 * 마지막] false && true || true
		 * 8]false && true = false
		 * false || true = true
		 */
		System.out.println("result="+result);
		result= !true || true ^ false && true;
		/*
		 * 1] !true : false
		 * 2] false && true : false
		 * 중간정리] false || true ^ false
		 * 3] false || true : true
		 * 중간정리] true ^ false
		 * 최종 =>true
		 */
		System.out.println("result="+result);
		
		//&&와 & , || 와 |
		
		num1 =10;
		num2 =100;
		
		System.out.println(num1 > num2 && num1 < num2);
		System.out.println(num1 > num2 & num1 < num2);
		
		
		
		Ref r=null;
		System.out.println("[&&사용]");
		System.out.println(r.data==100);
		System.out.println(r != null && r.data==100);
		
		//아래는 두번째항에서 실행시 에러
		//즉 r.data==100항이 실행되서.....
		//r이 null즉 가리키는 메모리가 없음
		System.out.println("[&사용]");
		System.out.println(r != null & r.data==100);
		
		
		
	}/////////////////main
}////////////////////class
