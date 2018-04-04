package method05;

public class CallByRefExample {
	
	//총점과 평균을 구하는 설정하는 메소드]
	//매개변수:2차원의 double형 배열
	static void setTotalNAverage(double[][] s){
		for(int i=0;i < s.length;i++){
			//총점 구하기
			for(int k=0;k < s[i].length-2;k++){
				s[i][3]+=s[i][k];
			}
			//평균 구하기
			s[i][4] = s[i][3]/3;
		}
	}///////////////////////////
	static void printScore(double[][] score) {
		for(int i=0;i < score.length;i++){
			System.out.printf("[%d번째 학생]%n",i+1);
			System.out.printf(
					"국어:%d,영어:%d,수학:%d,총점:%d,평균:%.2f%n",
					(int)score[i][0],
					(int)score[i][1],
					(int)score[i][2],
					(int)score[i][3],
					score[i][4]
					);
		}
	}
	
	
	public static void main(String[] args) {
		double[][] score= {
				{100,100,100,0.0,0.0},
				{90,90,90,0.0,0.0},
				{95,95,95,0.0,0.0}};
		//메소드 호출]
		//총점 및 평균설정
		setTotalNAverage(score);
		//출력
		printScore(score);
	}///////////////////main
	
}///////////////////////class
