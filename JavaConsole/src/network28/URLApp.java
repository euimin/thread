package network28;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
URL클래스:URL를 클래스화 해놓은 것
         java.net패키지에 있음.
*/
public class URLApp {

	public static void main(String[] args) {
		/*
		 InetAddress 는 IP를 클래스화 해놓은 것으로 프로토콜을
		 명시하지 않으나
		 URL는 반드시 해당 프로토콜을 명시해야 한다.
		 안그러면  MalformedURLException예외 발생.		  
		 */	
		String domain = "http://www.naver.com";
		
		try {
			/* URL클래스는 생성만 하면 해당  URL주소로 연결됨
			 * 단,주소가 정확하지 않아도 예외는 발생하지 않음
			 * MalformedURLException은 프로토콜을 명시하지 않은
			 * 경우에만 발생
			 */
			URL url = new URL(domain);
			System.out.println("네이버에 연결됨:"+url);
			//1]프로토콜 얻기-String getProtocol()
			System.out.println("프로토콜:"+url.getProtocol());
			//2]도메인 얻기 -String getHost()
			System.out.println("도메인:"+url.getHost());
			//2-1]도메인 얻고 IP주소 얻기
			System.out.println("IP주소:"+InetAddress.getByName(url.getHost()).getHostAddress());;
			//3]해당 프로토콜의 기본 port얻기:int getPort()
			/*
			 * 해당 프로토콜의 기본 Port를 알아내려면:getDefaultPort()
			 * 현재 사용하는 Port번호를 알아내려면 :getPort();
			 * 
			 * getPort()로 현재 사용하는 Port를 얻어올때
			 * 기본 Port를 사용하면 무조건 -1반환
			 * 기본 Port를 사용하지 않으면 해당 Port반환
			 */
			System.out.println("기본 포트:"+url.getDefaultPort());
			System.out.println("현재 사용하는 포트:"+(url.getPort()==-1?"80":url.getPort()));
			//4]도메인 이후의 주소를 얻어 옴-String getFile()
			URL url2 = new URL("https://s.pstatic.net/shopping.phinf/20170614_9/1601815f-82fe-4d94-8632-5b73a5bd3483.jpg");
			System.out.println("도메인 이후의 주소:"+url2.getFile());
			/*
			URL클래스는 해당 URL로 연결된 호스트의 InputStream을
			OpenStream()메소드로 얻어와서 웹 문서를 읽어 올수 있으나
			OutputStream을 얻어 올 수 있는 메소드는 제공하지 않는다.
			 */
			//원격의 이미지에 스트림 연결
			InputStream is=url2.openStream();
			
			BufferedInputStream bis 
				= new BufferedInputStream(is);			
			BufferedOutputStream bos 
			= new BufferedOutputStream(
				new FileOutputStream("src/network28/image.jpg"));
			
			int data;
			while((data=bis.read())!=-1){
				bos.write(data);
				bos.flush();
			}
			bis.close();
			bos.close();
			/*
		    * URL클래스의 openConnection()메소드로
		    * URLConnection객체를 얻어와서
		    * 연결된 컨텐츠에 대한 다양한 정보 등을 
		    * 알아낼수 있다(크기,컨텐츠 타입등)
		    */
			URLConnection connection=url2.openConnection();
			System.out.println("컨텐츠의 크기:"+connection.getContentLength());
			//컨텐츠 타입(MIME)-text/html,text/plain
			//                 image/jpg,image/png등
			System.out.println("컨텐츠 타입:"+connection.getContentType());
			long time=connection.getLastModified();
			SimpleDateFormat simple = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String lastString=simple.format(new Date(time));
			System.out.println("최근 수정한 시간:"+lastString);
		} 
		catch (MalformedURLException e) {
			System.out.println("네이버 연결 실패:"+e.getMessage());
		}
		catch(UnknownHostException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){}
	}

}
