package array04;

import java.util.Scanner;

public class ArrayExample {
	
	/*
	  *1] 학생수를 사용자로부터 입력받자
	  *   -Scanner클래스 사용
	  *2] 입력받은 학생 수만큼 국영수 점수 및 총점를 저장할수 있는
	  *   int형 배열을 선언하고  메모리를 할당해라
	  *3] 다시 학생 수만큼 각 학생의 국영수 점수를 입력받아
	  *   2]에서 생성한 배열에 저장해라.* 
	  *    -Scanner클래스 사용
	  *4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
	  * 
	  */ 
	public static final int SUBJECT_COUNT=3;
	
	public static void main(String[] args) {
		
		//1] 학생수를 사용자로부터 입력받자
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생수를 입력하세요?");
		int numberOfStudent = scanner.nextInt();
		
		//System.out.println("학생수:"+numberOfStudent);
		//2] 입력받은 학생 수만큼 국영수 점수 및 총점를 저장할수 있는
		//   int형 배열을 선언하고  메모리를 할당해라
		int score[][] = new int[numberOfStudent][SUBJECT_COUNT+1];
		//3] 다시 학생 수만큼 각 학생의 국영수 점수를 입력받아
		//   2]에서 생성한 배열에 저장해라.
		String[] subjectString={"국어","영어","수학"};
		for(int i=0;i < score.length;i++){
			System.out.printf("[%d번째 학생]%n",i+1);
			for(int k=0;k < score[i].length-1;k++){
				System.out.println(subjectString[k]+"점수 입력?");
				score[i][k]=scanner.nextInt();
				//i번째 학생의 점수 누적
				score[i][SUBJECT_COUNT]+=score[i][k];
			}
			
		}/////////////////////////
		//4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라.
		for(int i=0 ; i < score.length;i++){
			System.out.printf("[%d번째 학생] ",i+1);
			//국영수 출력]
			for(int k=0;k < score[i].length-1;k++){
				System.out.printf("%s:%-5d",subjectString[k],score[i][k]);
			}
			//총점하고 평균]
			System.out.printf("총점:%d 평균:%.2f%n",score[i][SUBJECT_COUNT],
					(double)score[i][SUBJECT_COUNT]/SUBJECT_COUNT);
			
		}
	}/////////////main
}///////////////class
