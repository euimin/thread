package globalnlocal08;
/*
멤버변수(클래스안에서 선언된 변수): 
         멤버변수는 해당 클래스안의 
         모든 메서드에서 사용 가능
         하고 전역변수(Global variable)와 같다.
         멤버변수는 초기화를 하지 않고 사용해도
         해당 자료형의 기본값으로 초기화 된다.
         예] int:0,double:0.0 참조형:null,
         boolean:false로 등
		 
지역변수(Local Variable):
		특정 지역 안에서 선언되어 그 지역에서만 사용되는 변수
		그 지역을 벗어나면 그 변수는 메모리에서 사라진다.
		
		메소드 안에서 선언된변수
         혹은 Block(if문,while문,for문,try문등) {}
		안에서 선언된 변수를 지역변수라 한다
		또한 매개변수도 지역변수이다
		지역변수는 선언된 곳을 벗어나면 메모리가 해제된다.
		지역변수는 사용시 반드시 초기화를 하고 사용해야 한다
		즉 지역변수는 자동으로 초기화가 안된다.
		
		※지역변수앞에는 modifier중
		(final/abstract/static) 
		  final만 붙일 수 있다.
		  abstract는 클래스와 메소드앞에만 
		  붙일 수 있다.
		  static는 못붙임.
		또한 지역변수 앞에는 
		    접근지정자를 붙일수 없다. 
		 
*/
public class GlobalNLocalVar {
	//[멤버 변수]
	private int memberNoInit;//자동으로 초기화 되있음.0으로
	int memberInit =100;//개발자가 선언과 동시에 초기화.100으로
	int[] memberArray = new int[3];//선언과 동시에 메모리 할당 및 주소로 초기화
	//[멤버 메소드]
	int getTotal(int start,int end){
		int total;//지역변수는 자동으로 초기화 안됨.
		total=0;//지역변수 초기화
		for(int i=start;i<=end;i++){
			//total+=i;//[x]지역변수인 total을 초기화 안해서
			total+=i;//[o]지역변수 초기화 후엔 정상
		}		
		//지역변수 i는 for문 안에서만 사용가능
		//System.out.println("i="+i);//[x]
		//지역변수 total,start,end는 getTotal메소드안에서는
		//어디든 사용가능
		System.out.printf("%d부터 %d까지 누적합:%d%n",start,end,total);
		if(total % 2==0){
			String stringResult;
			//System.out.println(stringResult);//[x]초기화 안해서
			stringResult="총합은 짝수";
			System.out.println(stringResult);//[o]
		}
		else{
			//stringResult는 if블락 안에서만 사용가능
			//stringResult="총합은 홀수";//[x]
		}
		//멤버변수는 자동으로 초기화 되기 때문에
		//개발자가 초기화 하지 않아도 바로 사용가능
		System.out.println(memberNoInit);//[o]
		return total;
	}
	
	public static void main(String[] args) {
		//GlobalNLocalVar클래스 인스턴스화/객체화/메모리 생성]
		GlobalNLocalVar gnl = new GlobalNLocalVar();
		System.out.println("gnl.memberNoInit="+gnl.memberNoInit);
		System.out.println("gnl.memberInit="+gnl.memberInit);
		System.out.println("gnl.memberArray="+gnl.memberArray);
		
		int total = gnl.getTotal(1, 10);
		//[x]지역변수앞에는 접근지정자 붙일수 없다
		//public int start,end;//[x]
		int start,end;//[o]
		//total = gnl.getTotal(start, end);//[x]초기화 안해서
		start=1;end=100;//초기화
		total = gnl.getTotal(start, end);//[o]
		/*
		 * 배열은 지역에서 선언된 배열이든 
		 * 클래스의 멤버로 선언된 배열이든
		 * 해당 자료형으로 초기화 된다. 
		 */
		System.out.println("[클래스의 멤버인 배열:사용자가 초기화 안함]");
		for(int i=0;i < gnl.memberArray.length;i++){
			System.out.printf("memberArray[%d]=%d%n",i,gnl.memberArray[i]);
		}////////////////
		
		int[] localArray=new int[3];
		System.out.println("[지역에서 선언한 배열:사용자가 초기화 안함]");
		for(int i=0;i < localArray.length;i++){
			System.out.printf("localArray[%d]=%d%n",i,localArray[i]);
		}////////////////
		
		
	}////////////////

}
