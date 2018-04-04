package console;

import java.util.Scanner;

public class BaseBall {
	
	//랜덤하게 숫자 발생후 배열에 저장하는 메소드]
	public static void setArrayRandom(int[] random, int start, int end) {
		for(int i=0;i < random.length ;i++){//i를 random배열의 인덱스번호로 사용	
			
			while(true){
				//랜덤하게 숫자 발생 시키자
				int randomNumber=(int)(Math.random()*(end-start+1))+start;
				//랜덤하게 발생시킨 숫자의 중복 여부체크를 위한 변수 선언
				boolean isDuplicated= false;
				//배열크기만큼 반복하면서 랜덤하게 발생시킨 숫자(randomNumber)와
				//중복 여부 체크
				for(int k=0;k < random.length;k++){
					if(randomNumber== random[k]){//중복된 경우
						isDuplicated=true;
						break;
					}
				}//////중복 체크용 for문
				
				//중복되지 않은 경우]
				if(!isDuplicated){
					random[i]=randomNumber;
					//while문 빠져 나가기
					break;
				}				
			}/////////while
			
			
		}///////////////for		
	}////////////////setArrayRandom
	//사용자 입력용 메소드
	private static void setUserNumber(int[] user) {
		Scanner scanner = new Scanner(System.in);
		
		//문]입력한 3자리가 중복이 안되도록 수정하여라..
		while(true){
			System.out.println("3자리 숫자를 중복되지 않게 입력하세요?");
			int userNumber = scanner.nextInt();
			user[0] = userNumber / 100;
			user[1] = userNumber / 10 % 10;//% 100 / 10;
			user[2] = userNumber % 100 % 10;//% 10
			if(!(user[0]==user[1] || 
			   user[0]==user[2] || 
			   user[1]==user[2])){//중복 안된 경우
			   break;				
			}
			System.out.println("중복 되었어요..");
		}/////////////while 
		
	}///////////////////setUserNumber
	//스트라이크/볼 여부 판단후 저장]
	private static void setStrikeOrBall(int[] computer, int[] user, int[] ballOrStrike) {
		
		for(int i=0;i < computer.length;i++){			
			for(int k=0;k < user.length ;k++){
				//자리수도 같고 값도 같은 경우
				if(i==k && computer[i]==user[k])
					ballOrStrike[0]++;
				//자리수은 같지 않으나 값이 같은 경우
				else if(computer[i]==user[k])
					ballOrStrike[1]++;
			}
		}
		
	}///////////////setStrikeOrBall
	
	//게임 계속 진행 여부 판단용 메소드]
	private static void isContinue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[종료하려면 X나 x를 입력하세요.\r\n계속하려면 아무 키나 누르세요..]");
		String exitString = scanner.nextLine();
		if(exitString.equals("x") || exitString.equals("X")){
			System.out.println("수고 했어요...");
			System.exit(0);//프로그램 종료.
		}
	}/////////////isContinue()
	
	
	public static void main(String[] args) {
		while(true){
			//1]랜덤하게 발생시킨 숫자를 저장할 1차원 배열 선언
			int[] computer=new int[3];
			//2]랜덤하게 숫자를 발생시켜 배열에 저장하는 메소드 호출	
			setArrayRandom(computer,1,9);
			//컴퓨터 숫자 확인용]
			for(int i=0; i < computer.length;i++) System.out.printf("%-2d",computer[i]);
			System.out.println();
			
			int tryCount=1;
			while(true){
				//3]사용자로부터 3자리 숫자를 입력받자	
				//3-1]사용자 입력 숫자를 저장할 1차원 배열 선언
				int[] user = new int[3];
				//3-2]사용자 입력을 받는 메소드 호출
				setUserNumber(user);
				/*
				//사용자 숫자 확인용]
				for(int i=0; i < user.length;i++) System.out.printf("%-2d",user[i]);
				System.out.println();
				*/
				//4]스트라이크/볼 여부 판단
				//스트라이크 및 볼값을 저장할 배열 선언]
				// 0번째 방에는 스트라이크,1번째 방에는 볼 저장
				int[] ballOrStrike = new int[2];
				setStrikeOrBall(computer,user,ballOrStrike);
				/*
				//볼/스트라이크 확인용]
				for(int i=0; i < ballOrStrike.length;i++) System.out.printf("%-2d",ballOrStrike[i]);
				System.out.println();
				*/
				System.out.printf("%d Stike,%d Ball--%d번째 시도%n",ballOrStrike[0],ballOrStrike[1],tryCount);
				
				if(ballOrStrike[0] ==3){
					System.out.printf("빙고! 짝 짝 짝!!!%d번째만에 맞혔어요%n",tryCount);
					break;
				}
				//시도 회수 증가
				tryCount++;
			}///////안쪽while
			//5]게임 계속여부 판단용 메소드 호출
			isContinue();
			
		}////바깥 while
		
		
	}/////////////////////main


}/////////////////////////class
