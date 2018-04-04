package abstraction06;

import java.util.Scanner;

/*
성적처리하는 프로그램 로직을 추상화 하자
	-DAO(Data Access Object)계열 클래스
	 비즈니스 로직(업무처리 로직)를 작성

멤버변수]:학생수,
         GradeRecord타입의 배열
         (배열크기는 학생수 만큼)
멤버메소드]:
		   1]학생수를 설정하는 메소드
           2]점수를 입력받고 총점 및 평균을 구하는 메소드
           3]등수를 구하는 메소드
           4]결과를 출력하는 메소드

*/
public class GradeLogic {
	//[멤버 변수]
	int numberOfStudent;//학생수 저장용]
	GradeRecord[] records;//각 학생의 성적 저장용 배열]
	String[] titles={"국어","영어","수학"};//과목 타이틀 출력용
	//[멤버 메소드]
	// 1]학생수를 설정하는 메소드
	/*
	 * 매개변수:없음
	 * 반환타입:void
	 * 
	 */
	void setNumberOfStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생수를 입력하세요?");
		numberOfStudent = scanner.nextInt();
		//학생수만큼 GradeRecord타입 배열의 메모리 할당
		records = new GradeRecord[numberOfStudent];
		//학생수만큼 GradeRecord타입의 메모리 생성해서 위의 배열에 주소 저장
		for(int i=0;i < records.length;i++)
			records[i] =new GradeRecord();
	}/////////////setNumberOfStudent()
	/*
	 * 2]점수를 입력받고 총점 및 평균을 구하는 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	void setNameNJumsu(){
		Scanner scanner = new Scanner(System.in);
		//학생수 만큼 국영수 점수 입력 받기]
		for(int i=0;i < numberOfStudent;i++){
			System.out.printf("[%d번째 학생]%n",i+1);
			//i번째 학생의 이름 입력받기
			System.out.println("이름을 입력하세요?");
			records[i].name=scanner.nextLine();
			//i번째 학생의 국영수 점수를 입력받자
			for(int k=0;k < titles.length;k++){
				System.out.println(titles[k]+"점수 입력?");
				records[i].jumsu[k]=scanner.nextInt();
				//i번째 학생의 점수 누적
				records[i].total+=records[i].jumsu[k];
			}
			//i번째 학생의 평균
			records[i].avg=(double)records[i].total/GradeRecord.SUBJECT;
			
			//버퍼에 남아 있는 엔터값 읽어서 버리자
			scanner.nextLine();
		}//////////////////////////////
		
	}///////////////////////////setNameNJumsu
	/*
	 * 3]등수를 구하는 메소드
	 * 매개변수:NO
	   반환타입:void
	 * 
	 */
	void setRank(){
		for(int i=0;i < records.length-1;i++)
			for(int k=i+1;k < records.length;k++){
				if(records[i].total < records[k].total) 
					records[i].rank++;
				else if(records[i].total > records[k].total) 
					records[k].rank++; 
			}
	}//////////////////////setRank()
	
	//둥수별로 재 정렬하는 메소드]
	void sort(){
		for(int i=0;i < records.length-1;i++)
			for(int k=i+1;k < records.length;k++){
				if(records[i].total < records[k].total){
					GradeRecord temp =records[k];
					records[k] = records[i];
					records[i] =temp;					
				}			
			}
	}//////////////////
	/*
	 4]결과를 출력하는 메소드
	 매개변수:NO
	 반환타입:void
	 */
	void printGrade(){
		//출력전 재정렬
		sort();
		
		//학생수만큼 반복해서 출력]
		System.out.println("===========================================");
		System.out.printf("%-10s%-5s%-5s%-5s%-5s%-7s%s%n",
				"NAME","KOR","ENG","MATH","SUM","AVG","RANK");
		System.out.println("===========================================");
		
		for(int i=0;i < numberOfStudent;i++){
			//이름 출력]
			System.out.printf("%-10s",records[i].name);
			//국영수 출력]
			for(int k=0;k < titles.length;k++){
				System.out.printf("%-5d",records[i].jumsu[k]);
			}
			//총점 및 평균 그리고 등수 출력
			System.out.printf("%-5d%-7.2f%d%n",
								records[i].total,
								records[i].avg,
								records[i].rank
					);
		}
	}///////////////////////printGrade()
	
}
