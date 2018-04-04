package method05;
/*
명령줄(Command Line) 인수:
main메서드의 매개변수인 args에 전달하는 값을
명령줄 인수라 한다
args는 CommandLine에서 인수를 의미 즉
예] dos>CommandLine 100 에서  args는 100를 
담은 매개변수임

[실행시] 인수 개수가 args 배열의 인덱스보다 
많으면 상관없으나
부족하면 ArrayOutofBoundsException예외 발생

dos>java CommandLine 홍길동 20 강남

*/
public class CommandLine {

	public static void main(String[] args) {
		System.out.println("이름:"+args[0]);
		System.out.println("나이:"+args[1]);
		System.out.println("사는 곳:"+args[2]);
	}//////////////main

}////////////class
