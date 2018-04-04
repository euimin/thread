package network28;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
InetAddress 클래스:IP를 추상화 한 클래스 
*/
public class InetAddressApp {

	public static void main(String[] args) {
		/*
		 프로토콜(http 혹은 ftp등)을 제외한 도메인을
		 인자로 넣어줘야 한다
		 만약 도메인이 적절하지 않으면 UnknownHostException발생
		*/
		String domain="www.naver.com";
		String ip="120.50.132.112";
		/* InetAddress객체는 new 생성자()해서
		 * 객체를 얻어 올 수 없다.		
		 */
		//InetAddress inet = new InetAddress(); //[x]
		
		try {
			//1]호스트와 연결:getByName(도메인명 혹은 IP주소)
			/*
			 *static InetAddress  getByName("도메인")메소드가
			 *null을 반환하지 않으면 바로 도메인으로 지정한
			 *호스트에 연결됨.
			 */
			InetAddress inet= InetAddress.getByName(domain);
			System.out.println("네이트 연결 성공:"+inet);
			//[연결된 호스트에 대한 여러가지 정보 얻기]
			//2]호스트(네이트)아이피 주소 얻기:String getHostAddress():중요
			System.out.println("아이피 주소:"+inet.getHostAddress());
			//3]호스트의 도메인 :String getHostName() -
			//  도메인을 getByName()의 인자로 넣어줬을때
			System.out.println("도메인 주소:"+inet.getHostName());
			//4]자신의 아이피 주소 얻기:static InetAddress getLocalHost()
			System.out.println("자신의 아이피:"+InetAddress.getLocalHost().getHostAddress());
			//5]자신의 루프백주소:static InetAddress getLoopbackAddress() 
			System.out.println("루프백 주소:"+InetAddress.getLoopbackAddress().getHostAddress());
			//6]호스트의 모든 IP주소 얻기:static InetAddress[] getAllByName(도메인혹은 아이피주소)
			InetAddress[] inets= InetAddress.getAllByName(domain);
			for(InetAddress address:inets)
				System.out.println(address.getHostAddress());
			/*
		    * [정리]
		    * 
		    * InetAddress타입의 객체 생성
		    * 1]InetAddress.getByName("도메인명")으로 얻는다
		    *
		    * 1]에서 연결된 도메인의 아이피 얻기
		    * InetAddress타입의 인스턴스변수.getHostAddress()
		    * 
		    * 2] 자신의 아이피 주소 얻기(루프백 주소가 아닌)
		    * InetAddress.getLocalHost().getHostAddress()
		    * 
		    * 
		    */
		} 
		catch (UnknownHostException e) {
			System.out.println("네이트 연결 실패:"+e.getMessage());
		}
	}

}
