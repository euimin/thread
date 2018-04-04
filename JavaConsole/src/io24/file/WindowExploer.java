package io24.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowExploer {

	public static void main(String[] args) {
		File f = new File("src/io24/node");
		//문]윈도우 탐색기처럼 상기 디렉토리 안에 있는
		//   하위디렉토리나 파일을 출력하여라,
		//   단, 디렉토리부터...
		File[] files=f.listFiles();
		
		System.out.println("==========================================================================");
		System.out.println(
				String.format("%-30s%-20s%-10s%s",
						"이름","수정한 날짜","유형","크기"));
		System.out.println("==========================================================================");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd a H:mm");
		
		StringBuffer sbdir = new StringBuffer();
		StringBuffer sbfile= new StringBuffer();
		
		for(File file : files){
			//파일명 혹은 디렉토리명]
			String name = file.getName();
			//최근 수정된 시간]
			String lastString=simple.format(new Date(file.lastModified()));
			if(file.isFile()){//파일인 경우
				//파일 유형]				
				String ext = name.substring(name.lastIndexOf(".")+1).toUpperCase();
				//파일 크기]
				int size=(int)Math.ceil(file.length()/1024.0);
				sbfile.append(
						String.format("%-30s%-20s%-10s%dKB%n",name,lastString,ext+"파일",size));
			}
			else{//디렉토리인 경우
				sbdir.append(String.format("%-30s%-20s%s%n",name,lastString,"파일 폴더"));
			}			
		}//////////for
		System.out.println(sbdir.toString()+sbfile);
		System.out.println((int)'ㄱ');
		System.out.println((int)'ㄴ');
		System.out.println((int)'ㄷ');
		System.out.println((int)'ㄹ');
		
	}//////////////////main
}//////////////////////class
