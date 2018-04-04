package method05;
//메소드 형식 3: 매개변수는 있고 반환값은 없는 경우
/*
접근지정자 [modifier] void 메소드명(매개변수들){

처리할 일;

}  
*/
//메소드 정의]
/*
* 메소드에서 필요한 값을 매개변수를 통해서 받고
* 그 값으로 일을 처리한 후 결과값을
* 바로 출력하고자 할때 주로 사용

*/
public class MethodType03 {
	//1]메소드 정의:start부터 end까지 누적합 구하는 메소드
	static void getTotal(int start,int end){
		int total=0;
		for(int i=start;i<=end;i++) total+=i;
		System.out.printf("%d부터 %d까지 누적합:%d%n",start,end,total);
	}///////////////////////
	/*문] 국영수 세과목의 점수를 매개변수로 전달받아
	평균을구하고 힉점을 출력하는 메소드를 정의해라
	그리고 main메소드에서 호출하여 결과를 확인해라.*/
	static void getGrade(int kor,int eng,int math){
		System.out.printf("평균:%.2f,",(kor+eng+math)/3.0);
		switch((kor+eng+math)/30){
			case 10:
			case 9:System.out.println("A학점");return;
			case 8:System.out.println("B학점");return;
			case 7:System.out.println("C학점");return;
			case 6:System.out.println("D학점");return;
			default:System.out.println("F학점");
		}
	}//////////////////////
	/*문]
	   이름과 나이를 매개변수에 받아서
	   "이름은 ??? 나이는 ???"라고 바로 출력하는 
	   메서드를 정의해라
	   단, 반환값은 없다.
	   위 정의한 메서드를 main메서드에서 호출하여 
	   그 결과값을 확인 하여라
	*/
	static void printNameNage(String name,int age){
		System.out.printf("이름은 %s 나이는 %d%n",name,age);
	}
	/*
	 * 문] 숫자 두개를 매개변수로 입력받아서 즉 시작단 과 끝단을 
	 *     매개변수에 입력받아
	       해당 구구단을 출력하는 메소드를 정의하고
	       main메소드에서 호출하여라.
	 
	 */
	static void printDan(int start,int end){
		for(int i =1 ;i <=end ;i++){
			for(int k=start;k<=end;k++){
				System.out.printf("%d * %d = %-4d",k,i,k*i);
			}
			System.out.println();
		}
	}///////////////////////
	
	public static void main(String[] args) {
		//2]메소드 호출
		//매개변수에 값 전달:변수에 저장해서 전달
		int start=100;
		int end =1000;
		getTotal(start, end);
		//매개변수에 값 전달:상수값 직접 전달
		getTotal(1,10);
		getTotal(10, 1000);
		getTotal(1000, 10000);		
		getGrade(100,90,90);		
		
		int[][] score ={
				{90,67,89},
				{45,67,12},
				{56,71,90},
				{99,91,95},
				{89,81,78}
				};
		//문]위에 정의한 getGrade()메소드를 호출하여
	    //2차원 배열score에 저장된 5명의 학생의
	    //학점과 평균을 출력하여라.
		for(int i=0;i < score.length;i++){ 
			System.out.printf("%d번째 학생]",i+1);
			getGrade(score[i][0],score[i][1],score[i][2]);			
		}	
		
		printNameNage("김길동",20);
		System.out.println("[구구단]");
		printDan(2,9);
		System.out.println("[16단]");
		printDan(2,16);
		
	}/////////////////main
}////////////////////class
