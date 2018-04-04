package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import comm.util.CommonUtility;

/* 1차 개인 프로젝트시 참고 코드 */
public class AddressCodeSampleApp {

	public static void main(String[] args) {
		
		Map<Character,List<Address>> address
		= new HashMap<Character,List<Address>>();
		//1]밸류 타입을 null로 초기화
		List<Address> valueList= null;
		//사용자 입력용 스캐너]
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("이름을 입력하세요?");
			String name = scanner.nextLine();
			if("EXIT".equalsIgnoreCase(name)) break;
			//2]초성 (ㄱ,ㄴ,ㄷ,.....ㅎ)얻기
			char firstCharacter = CommonUtility.getFirstCharacter(name);
			//System.out.println("초성:"+firstCharacter);
			if(firstCharacter=='0'){
				System.out.println("한글 이름이 아닙니다");
				continue;
			}
			//3]초성이 한글 이름인 경우
			//맵컬렉션(address)에 firstCharacter 키값이 존재하는지 판단
			if(!address.containsKey(firstCharacter)){//키값이 존재하지 않는다면
				//value타입인 List<Address>객체 생성
				valueList = new Vector<Address>();
			}
			else{//키값이 존재 한다면
				valueList=address.get(firstCharacter);
			}
			valueList.add(new Address(name,1,"전번","주소"));
			//4]맵 컬렉션에 firstCharacter키값으로 저장
			address.put(firstCharacter, valueList);
		}////////while
		//출력]
		Set<Character> keys=address.keySet();
		for(Character key :keys){
			System.out.println(
					String.format("[%c로 시작하는 명단]",key));
			
			List<Address> values=address.get(key);
			for(Address value:values) value.printAddress();
		}
		/*문]찾고자 하는 사람의 이름을 입력받아
		     위 맵 컬렉션에 저장된 사람의 정보를 출력하자.
		     만약 해당하는 사람이 없으면 "해당하는 사람이 없어요"
		     라고 출력하여라.
		     찾을때까지 계속 입력받도록 하여라.
		*/
		while(true){
			System.out.println("찾고자 하는 사람의 이름을 입력하세요?");
			String name = scanner.nextLine();
			boolean isExit =false;
			for(Character key :keys){			
				List<Address> values=address.get(key);
				for(Address value:values) {
					if(value.name.equals(name)){
						value.printAddress();
						isExit= true;
						break;
					}
				}
				if(isExit) break;
			}
			if(!isExit ) System.out.println("해당 하는 사람이 없어요");
			else break;
		}
		
	}///////////////main
}///////////////////class
