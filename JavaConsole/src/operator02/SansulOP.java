package operator02;

public class SansulOP {
	
	public static void main(String[] args) {
		//※연산자-데이타를 처리하는 기호
		/*
		-산술연산자(이항 연산자)의 결과는 다양하다
		-산술연산자내 에서의 연산 우선순위
		(*,%,/) > (+,-)
		-우선 순위가 같은 경우 왼쪽에서 오른쪽으로 연산한다
		-산술 연산자를 써서 식을 만들면 산술식
		*/
		int result=3 * 2 + 5 % 2 - 6 / 3 * 5;
		/*
		 * 1]3*2 = 6
		 * 2]5 %2 = 1
		 * 3]6/3 = 2
		 * 중간정리] 6 + 1 - 2 * 5
		 * 4]2 * 5 =10;
		 * 5]6+1 = 7
		 * 6] 7-10 =-3
		 */	
		System.out.printf("result=%d%n",result);
	}///////////main
}/////////////class
