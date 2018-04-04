package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
객체가 저장된 파일(object.dat)로부터 객체를 읽어 오자
데이타 소스:파일
    노드 스트림:FileInputStream

필터 스트림:ObjectInputStream
    
데이타 목적지:객체(메모리)-인스턴스 변수
 
*/
public class ExternalizableFileToObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//1]필터를 끼운 입력 스트림 생성
		ObjectInputStream ois =
				new ObjectInputStream(
						new FileInputStream("src/io24/filter/object.dat"));
		//2]ois로 읽어서 PersonExternalizable타입에 저장
		
		Object obj=ois.readObject();
		if(obj instanceof PersonExternalizable){
			((PersonExternalizable)obj).print();
		}
		PersonExternalizable per2 = (PersonExternalizable)ois.readObject();
		per2.print();
		PersonExternalizable per3 = (PersonExternalizable)ois.readObject();
		per3.print();
		//아래는 java.io.EOFException발생
		//ois.readObject();//실행 오류
		
		ois.close();
	}/////main

}
