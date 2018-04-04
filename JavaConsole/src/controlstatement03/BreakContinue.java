package controlstatement03;

public class BreakContinue {
	/*
	 기타 제어문:continue문 이나 break문은 
	             반복문(for/while/do~while)
	             이나 switch문에서 사용
	 continue:
	 	continue문을 만나면 반복문 처음으로 이동
	 break:
	 	break문을 만나면 switch문이나 반복문을 빠져 나간다.  
	 	
	 또한 continue문이나 break문을 만나면 그 아래에 있는 
	 명령문들은 실행이 안된다.
	 
	 */
	public static void main(String[] args) {
		int i=0;
		while(i < 100000000){
			i++;
			System.out.printf("[i가 %d일때]%n",i);
			System.out.println("continue이전 출력문");
			if(i % 2==0) continue;
			System.out.println("continue이후 출력문");
			System.out.println("break이전 출력문");
			if(i==3) break;
			System.out.println("break이후 출력문");
		}
		/*
		 * ※break문은 반복문이나 switch문안에서만 사용가능
		 *   continue문은 반복문 안에서만 사용가능
		 * 
		 */
		//break;//[x]
		//continue;//[x]
		//if(true) break;//[x]
		//if(true) continue;//[x]
	}/////////////main

}//////////////////class
