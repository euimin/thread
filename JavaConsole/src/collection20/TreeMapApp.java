package collection20;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class TreeMapApp {

	public static void main(String[] args) {
		TreeMap<Character,List<Address>> map =
			new TreeMap<Character,List<Address>>();
		
		List<Address> dig =new Vector<Address>();
		dig.add(new Address("딕길동",10, "010","강남"));
		dig.add(new Address("다길동",30, "011","강서"));
		dig.add(new Address("도길동",20, "017","강동"));
		//정렬후 저장]
		Collections.sort(dig);
		map.put('ㄷ', dig);
		
		List<Address> ki =new Vector<Address>();
		ki.add(new Address("곽길동",10, "010","강남"));
		ki.add(new Address("고길동",30, "011","강서"));
		ki.add(new Address("가길동",20, "017","강동"));
		Collections.sort(ki);
		map.put('ㄱ', ki);
		
		List<Address> ni =new Vector<Address>();
		ni.add(new Address("노길동",10, "010","강남"));
		ni.add(new Address("나길동",30, "011","강서"));
		ni.add(new Address("너길동",20, "017","강동"));
		Collections.sort(ni);
		map.put('ㄴ', ni);
		//오름 차순]
		//Set<Character> keys= map.keySet();
		//내림차순]
		Set<Character> keys=map.descendingKeySet();
		for(Character key:keys){
			System.out.println(key+"로 시작하는 사람들...");
			List<Address> values=map.get(key);
			for(Address value:values) value.printAddress();
		}

	}

}
