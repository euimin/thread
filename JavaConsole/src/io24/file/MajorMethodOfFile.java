package io24.file;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MajorMethodOfFile {
	//문]File클래스의 getName()과 같은 역할을 하는 
	//   나만의 메소드를 정의하자]
	private static String getName(String value) {
		int beginIndex = value.lastIndexOf("/") !=-1 ? 
				         value.lastIndexOf("/")+1    :
				         value.lastIndexOf("\\")+1   ;
		
		return value.substring(beginIndex);
	}
	
	public static void main(String[] args) {
		/*
		  \:디렉토리의 원도우식 표기법
		  /:디렉토리의 UNIX(LINUX)식 표기법
		*/ 
		String wExistFile="C:\\CCH\\JAVA\\Workspace\\Basic\\JavaConsole\\src\\HelloWorld.java";
		String wNoExistFile="C:\\CCH\\NoFile.txt";		
		String uRelativeDir="src/io24/node";
		String uAbsoluteNoDir="C:/CCH/NoDir";
		
		//1]File 객체 생성
		//1-1]파일에 대한 정보를 가진 File객체
		File fwExistFile = new File(wExistFile);
		File fwNoExistFile = new File(wNoExistFile);
		//1-2]디렉토리에 대한 정보를 가진 File객체
		File fuRelativeDir = new File(uRelativeDir);
		File fuAbsoluteNoDir = new File(uAbsoluteNoDir);
		//2]파일명 혹은 디렉토리명 얻기:String getName()
		System.out.println("fwExistFile의 파일명:"+fwExistFile.getName());
		System.out.println("fwNoExistFile의 파일명:"+fwNoExistFile.getName());
		System.out.println("fuRelativeDir의 디렉토리명:"+fuRelativeDir.getName());
		System.out.println("fuAbsoluteNoDir의 디렉토리명:"+fuAbsoluteNoDir.getName());
		System.out.println("[내가 만든 getName()으로 출력]");
		System.out.println("wExistFile의 파일명:"+getName(wExistFile));
		System.out.println("wNoExistFile의 파일명:"+getName(wNoExistFile));
		System.out.println("uRelativeDir의 디렉토리명:"+getName(uRelativeDir));
		System.out.println("uAbsoluteNoDir의 디렉토리명:"+getName(uAbsoluteNoDir));
		/*3] 파일 혹은 디렉토리 여부 판단:
	     boolean isFile() 혹은 boolean isDirectory()
	     isFile():파일이 아니거나 ,파일이 존재하지 않으면 
	              false반환.
		 isDirectory():디렉토리가 아니거나 ,
	                 디렉토리가 존재 하지 않으면 false반환.
		 */
		System.out.println(fwExistFile.isFile() ?"파일이다":"파일이 아니거나 존재하지 않는다");
		System.out.println(fwNoExistFile.isFile() ?"파일이다":"파일이 아니거나 존재하지 않는다");
		System.out.println(fwExistFile.isDirectory() ?"디렉토리다":"디렉토리가 아니거나 존재하지 않는다");
		System.out.println(fuRelativeDir.isDirectory()?"디렉토리다":"디렉토리가 아니거나 존재하지 않는다");
		System.out.println(fuAbsoluteNoDir.isDirectory()?"디렉토리다":"디렉토리가 아니거나 존재하지 않는다");
		//4]파일 혹은 디렉토리 존재 여부 판단:boolean exists()
		//※항상 존재 여부 판단후 파일인지 디렉토리인지 판단하자.
		System.out.println(fuRelativeDir.exists() ? "존재한다":"존재 하지 않는다");
		System.out.println(fuAbsoluteNoDir.exists() ? "존재한다":"존재 하지 않는다");
		if(fwExistFile.exists()){
			if(fwExistFile.isFile())
				System.out.println("파일이다");
			else
				System.out.println("디렉토리다");				
		}
		
		System.out.println(fuRelativeDir.exists() ? fuRelativeDir.isDirectory() ? "디렉토리다" : "파일이다" :"존재하지 않는다" );
		//5]파일 혹은 디렉토리의 상대경로(getPath()) / 절대경로(getAbsolutePath()) 얻기 
		/*
		 * ※자바 프로그램에서 상대경로로 표기하고 
		 *   절대 경로를 얻고자할때 주로 getAbsolutePath()사용
		 */
		
		System.out.println("fuRelativeDir의 상대경로:"+fuRelativeDir.getPath());
		//※아래처럼 주로 사용
		System.out.println("※fuRelativeDir의 절대경로:"+fuRelativeDir.getAbsolutePath());
		System.out.println("fuAbsoluteNoDir의 상대경로:"+fuAbsoluteNoDir.getPath());
		System.out.println("fuAbsoluteNoDir의 절대경로:"+fuAbsoluteNoDir.getAbsolutePath());
		
		//6]파일 혹은 디렉토리의 크기 얻기(단위:바이트) :long length()
		/*
		8bit     -> 1BYTE
		1024byte -> 1KB
		1024KB   -> 1MB
		1024MB   -> 1GB
		1024GB   -> 1TB		
		 */
		//디렉토리는 OS에 따라서 
		//0을 반환하거나 일부 크기를
		//반환 할 수도 있다. 파일은 존재하면 해당 크기를 반환
		//존재하지 않으면 0반환.
		/* length()메소드 사용시 크기가 0인경우
		 * -디렉토리(OS에 따라 다름)
		 * -파일형식이지만 파일이 존재 하지 않은경우
		 * -파일이 존재하지만 크기가 0인경우 
		 */
		//디렉토리 경우 XP는 무조건 0반환,WIN7는 크기 반환하지만
		//실제 크기는 아님
		System.out.println("fwExistFile의 파일 크기:"+fwExistFile.length()+"byte");
		System.out.println("fwNoExistFile의 파일 크기:"+fwNoExistFile.length()+"byte");
		
		System.out.println("fuRelativeDir의 디렉토리 크기:"+fuRelativeDir.length()+"byte");
		System.out.println("fuAbsoluteNoDir의 디렉토리 크기:"+fuAbsoluteNoDir.length()+"byte");
		
		//7]상위 부모경로 얻기:getParent()
		/*
		 * 주로 디렉토리에 적용하는데 파일객체를 생성시
		 * 상대경로든 절대경로든 여러 경로를 준 경우에 사용
		 */	
		System.out.println("fwExistFile의 부모경로:"+fwExistFile.getParent());
		System.out.println("fwNoExistFile의 부모경로:"+fwNoExistFile.getParent());
		System.out.println("fuRelativeDir의 부모경로:"+fuRelativeDir.getParent());
		System.out.println("fuAbsoluteNoDir의 부모경로:"+fuAbsoluteNoDir.getParent());
	
		File fone = new File("io24");
		System.out.println("fone의 부모 경로:"+fone.getParent());
		File ftwo = new File("src","node");
		System.out.println("ftwo의 부모 경로:"+ftwo.getParent());
		ftwo = new File("src/node");
		System.out.println("ftwo의 부모 경로:"+ftwo.getParent());
		//8]디렉토리 혹은 파일 삭제:
		//  boolean delete()-삭제 성공시 true,
		//  실패시 false
		System.out.println(fwNoExistFile.delete() ?"삭제 성공":"삭제 실패");
		File fexit = new File("C:/CCH/X.txt");
		System.out.println(fexit.delete() ? "삭제 성공":"삭제 실패");
		//디렉토리는 안에 비어 있어야 삭제됨.
		System.out.println(fuRelativeDir.delete()?"삭제 성공":"삭제 실패");
		File fdir = new File("C:/TEST");
		System.out.println(fdir.delete()?"삭제 성공":"삭제 실패");
		//9]디렉토리 생성:boolean mkdir() /mkdirs();
	    //mkdir():부모 디렉토리 존재 하지 않으면 생성 실패
	    //mkdirs():부모 디렉토리까지 생성해줌.
		File fmkdir = new File("src/io24/node/temp");
		System.out.println(fmkdir.mkdir() ? "디렉토리 생성" : "디렉토리 생성 실패");
		
		File fmkdirs = new File("src/io24/node/noexit/temp");
		System.out.println(fmkdirs.mkdirs()? "성공" : "실패");
		
		//10]읽기/쓰기 가능 판단
		//윈도우계열 OS는 모든 파일이 디폴트로 실행가능
		File fcan = new File("C:/CCH/CAN.TXT");
		System.out.println(fcan.canRead() ?"읽기 가능":"읽기 불가능");
		System.out.println(fcan.canWrite() ?"쓰기 가능":"쓰기 불가능");
		System.out.println(fcan.canExecute() ?"실행 가능":"실행 불가능");
		/*11]파일 혹은 디렉토리의 최근 수정된 시간 얻기
		long lastModified():1970년 1월 1일 0시 0분 0초부터 현재까지 
		흘러온 시간을 1000분의 1초단위로 환산해서 long형으로 반환.*/
		long time=fcan.lastModified();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd a H:mm");
		String lastTime=simple.format(new Date(time));
		System.out.println("최근 수정된 시간:"+lastTime);
		//12]파일 이름 변경:boolean renameTo(File dest)  
		//   src.renameTo(dest) src와 dest는 둘다 파일객체
		/*
		 * 같은 폴더 안:파일명 변경효과
		 * 다른 폴더 안으로:파일 이동 효과
		 * 
		 */
		File frename = new File("C:/CCH/CANCHANGE.TXT");
		System.out.println(fcan.renameTo(frename) ?"이름 변경 성공":"이름 변경 실패");
		System.out.println(frename.renameTo(new File("C:/CCH/JAVA/MY.TXT"))?"파일 이동 성공":"파일 이동 실패");
		/*13]파일목록 및 디렉토리목록 얻어 오기
		String[] list():해당 디렉토리안에 있는 파일 및 디렉토리명만
		File[] listFiles():해당 디렉토리안에 있는 파일 및 디렉토리에
		대한 파일객체 배열 반환
		*/
		String[] names=fuRelativeDir.list();
		System.out.println("[파일명 및 디렉토명만 반환]");
		for(String name:names) System.out.println(name);
		
		System.out.println("[File객체 반환]");
		File[] files=fuRelativeDir.listFiles();
		
		for(File file : files){
			//파일명 혹은 디렉토리명]
			String name = file.getName();
			//최근 수정된 시간]
			String lastString=simple.format(new Date(file.lastModified()));
			if(file.isFile()){
				System.out.println(
						String.format("파일명:%s,최근 수정된 시간:%s",name,lastString));
			}
			else{
				System.out.println(
						String.format("디렉토리명:%s,최근 수정된 시간:%s",name,lastString));
			}
			
		}
	}/////////////////////

	

}
