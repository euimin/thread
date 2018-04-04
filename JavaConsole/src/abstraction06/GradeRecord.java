package abstraction06;
/*
1명의 학생의 
이름/국영수점수/총점/평균/등수를 저장하는 클래스


성적정보를 저장하는 자료구조를 추상화 하자]
-DTO(Data Transfer Object)계열 클래스
*/
public class GradeRecord {
	
	//[멤버 상수]
	public static final int SUBJECT=3;
	//[멤버 변수]
	String name;//이름]
	int[] jumsu = new int[SUBJECT];//국영수 점수]
	int total ;//총점]
	double avg;//평균]
	int rank=1;//등수]
	
}
