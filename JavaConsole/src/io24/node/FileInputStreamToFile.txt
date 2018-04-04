package io24.node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
[파일로부터 데이타를 읽어 파일에 출력]

파일에 직접 연결이 가능한 1바이트 기반의 노드 스트림 이용

※데이타 소스나 데이타 목적지에 따라 입출력 노드 스트림 결정

데이타 소스:File
		1바이트 기반의 입력 스트림:FileInputStream
	
데이타 목적지:File
		1바이트 기반의 출력 스트림:FileOutputStream


*/
public class FileInputStreamToFile {

	public static void main(String[] args) {
		FileInputStream fis =null;
		FileOutputStream fos=null;
		try{
			//1]바이트 기반의 입력용 노드 스트림 생성-파일에 입력용 빨대를 꽂자
			fis = new FileInputStream("src/io24/node/Keyboard.txt");
			//2]바이트기반의 출력용 노드 스트림 생성-파일에 출력용 빨대를 꽂자
			fos = new FileOutputStream("src/io24/node/OutputKeyboard.txt");
			//3]fis로 읽고 fos로 출력
			int data;
			int totalByte=0;//총 바이트 수
			int repeatCount=0;//반복 횟수
			/*
			//[필터 효과 적용 전]
			while((data=fis.read()) !=-1){
				totalByte++;
				repeatCount++;
				//파일로 출력]
				fos.write(data);
				fos.flush();
			}
			*/
			//[필터효과 적용]			
			/*
			 * read():1바이트씩 읽은 데이타의 아스키 코드값 반환
			 * read(byte[] b):1바이트씩 읽어서
			 *                byte형 배열 b에 채운후 
			 *                읽은 바이트 수 반환 
			 */
			//계란판으로 사용할 바이트형 배열]
			byte[] b = new byte[128];
			while((data= fis.read(b))!=-1){
				totalByte+=data;
				repeatCount++;
				//파일로 출력]
				//write(배열명,0,읽은 바이트 수)
				//즉 읽은 바이트 수만큼 출력]
				fos.write(b,0,data);
				fos.flush();
			}
			
			System.out.println(
					String.format("총 바이트 수:%d,반복 횟수:%d",totalByte,repeatCount));
		}
		catch(FileNotFoundException e){
			System.out.println("파일이 존재하지 않아요");
		}
		catch(IOException e){
			System.out.println("파일 읽기시 오류");
		}
		finally {
			try{
				//4]스트림 닫기
				if(fis !=null) fis.close();
				if(fos != null) fos.close();
			}
			catch(IOException e){
				System.out.println("스트림 닫기시 오류:"+e.getMessage());
			}
		}
	}///////////////////main
}///////////////////////class
