package exception21;

public class Club {
	void entrance(String cloths,int age) throws NotGoodAppearnceException{
		if("남루".equals(cloths)){
			throw new NotGoodAppearnceException();
		}
		else if("정장".equals(cloths) && age < 20)
			throw new NotGoodAppearnceException("나이가 너무 어려요");
		else if("정장".equals(cloths) && age > 40)
			throw new NotGoodAppearnceException("나이가 너무 많아요");
		
		System.out.println("불금을 보내세요");
	}
}
