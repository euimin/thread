package collection20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

class Address implements Comparable<Address>{
	//[멤버변수]
	String name;
	int age;
	String tel;
	String addr;
	//[인자 생성자]
	public Address(String name, int age, String tel, String addr) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.addr = addr;
	}
	//[멤버 메소드]
	String getAddressString(){
		return String.format("이름:%s  전번:%s  나이:%d  주소:%s",
				              name,tel,age,addr );
	}
	void printAddress(){
		System.out.println(getAddressString());
	}
	///
	@Override
	public int compareTo(Address another) {
		//오름차순]
		//return this.name.compareTo(another.name);
		//내림 차순]
		return another.name.compareTo(this.name);
	}
	
}


public class AddressBookApp {

	public static void main(String[] args) {
		/*
		1]초성을 Key값-String 혹은 Character		  
		  List계열 컬렉션을 Value값-List<String>
		  Map계열 컬렉션		  
		  Value에는 초성에 해당하는 이름들 저장
		*/
		Map<Character, List> nameAddr = new HashMap<Character, List>();
		//1-1]이름 저장용 List계열 컬렉션 객체 생성]
		List kieyeok = new Vector();
		List nieoun  = new Vector();
		//1-2]이름 저장
		kieyeok.add("고길동");
		kieyeok.add("가길동");
		kieyeok.add("김길동");
		kieyeok.add("곽길동");
		
		nieoun.add("나길동");
		nieoun.add("노길동");
		nieoun.add("남길동");
		//1-3]Map컬렉션(nameAddr)에 이름이 저장된 List계열 컬렉션 저장
		nameAddr.put('ㄱ', kieyeok);
		nameAddr.put('ㄴ', nieoun);
		//1-4-1]키값을 알때
		System.out.println("[키값을 알때]");
		List values=nameAddr.get('ㄱ');
		for(Object value:values) System.out.println(value);
		//1-4-1]키값을 모를때
		System.out.println("[키값을 모를때]");
		//키값부터 얻자]		
		Set<Character> keys= nameAddr.keySet();
		for(Character key:keys){
			System.out.println(String.format("[%c로 시작하는 명단]",key));
			//키값에 따른 밸류값 얻기]
			values=nameAddr.get(key);
			for(Object value:values) System.out.println(value);
		}
		/*
		2]초성을 Key값-String 혹은 Character		 
		  List계열 컬렉션을 Value값-List<Map<String,Object>>
		  Map계열 컬렉션		  
		  Value에는 초성에 해당하는 이름,주소,전화번호들 저장
		*/
		Map<Character,List<Map<String,Object>>> address
			= new HashMap<Character,List<Map<String,Object>>>();
		//2-1]이름/전번/주소/나이가 저장된 맵 컬렉션을 저장할
		//    리스트계열 컬렉션 객체 생성
		List<Map<String,Object>> kie = new Vector<Map<String,Object>>();
		List<Map<String,Object>> nie = new Vector<Map<String,Object>>();
		//2-2]이름/전번/주소/나이를 저장할 맵 컬렉션 객체 생성
		Map<String,Object> k = new HashMap<String,Object>();
		k.put("name", "고길동");
		k.put("age", 20);
		k.put("tel", "010");
		k.put("addr", "가산동");
		//리스트 계열 컬렉션에 저장
		kie.add(k);
		
		k = new HashMap<String,Object>();
		k.put("name", "가길동");
		k.put("age", 30);
		k.put("tel", "011");
		k.put("addr", "독산동");
		//리스트 계열 컬렉션에 저장
		kie.add(k);
		
		Map<String,Object> n = new HashMap<String,Object>();
		n.put("name", "나길동");
		n.put("age", 15);
		n.put("tel", "019");
		n.put("addr", "청담동");
		//리스트 계열 컬렉션에 저장
		nie.add(n);
		
		n = new HashMap<String,Object>();
		n.put("name", "노길동");
		n.put("age", 45);
		n.put("tel", "017");
		n.put("addr", "논현동");
		//리스트 계열 컬렉션에 저장
		nie.add(n);
		//주소록 저장하는 맵컬렉션에 리스트 저장]
		address.put('ㄱ',kie);
		address.put('ㄴ',nie);
		/*
		 * 객체 꺼내올때]
		 * Set/List계열 무조건 확장 for문 사용
		 * Map계열은 keySet()으로 키값들이 저장된
		 * Set계열 반환 받은 후 확장 for문 사용	
		 */
		//출력]
		System.out.println("[키값을 알때]");
		List<Map<String,Object>> addressValues=address.get('ㄱ');
		for(Map<String,Object> vals:addressValues){
			Set<String> kkeys=vals.keySet();
			for(String key:kkeys){
				Object val=vals.get(key);
				System.out.print(
						String.format("%s:%s%4c",key,val,' '));
			}
			System.out.println();
		}
		System.out.println("[키값을 모를때]");
		Set<Character> kkeys=address.keySet();
		for(Character key:kkeys){
			System.out.println("["+key+"으로 시작하는 명단]");
			addressValues=address.get(key);
			for(Map<String,Object> vals:addressValues){
				Set<String> ks=vals.keySet();
				for(String ky:ks){
					Object val=vals.get(ky);
					System.out.print(
							String.format("%s:%s%4c",ky,val,' '));
				}
				System.out.println();
			}
		}
		//3]Address클래스를 사용해서 2]번 처럼 구현
		Map<Character,List<Address>> classAddress
			= new HashMap<Character,List<Address>>();
		//3-1]주소를 저장할 리스트 계열 컬렉션 생성
		List<Address> kiec = new Vector<Address>();
		List<Address> niec = new Vector<Address>();
		//3-2]주소 저장
		kiec.add(new Address("고길동", 20, "010", "인천"));
		kiec.add(new Address("곽길동", 30, "011", "부산"));
		
		niec.add(new Address("나길동",40,"017","강남"));
		niec.add(new Address("노길동",45,"019","강동"));
		//3-3]키값으로 리스트 컬렉션객체를 맵(classAddress)에 저장
		classAddress.put('ㄱ', kiec);
		classAddress.put('ㄴ', niec);
		//출력]
		System.out.println("[Address클래스 사용]");
		Set<Character> sc=classAddress.keySet();
		for(Character c:sc){
			System.out.println("["+c+"로 시작하는 명단]");
			List<Address> la=classAddress.get(c);
			for(Address a:la) a.printAddress();
			
		}
		
		
		
	}////////////////main
}///////////////////class
