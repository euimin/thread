package io24.filter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/*
자바의 클래스는 직렬화가 되야 파일로 저장하거나
네트웍을 통해 전송할 수 있다.

어떤 클래스를 직렬화 하려면 Serializable혹은 Externalizable
인터페이스를 구현(상속)해야 한다. 

*/
public class PersonSerializable implements Serializable {
	//[멤버 변수]
	String name;
	int age;
	String addr;
	public PersonSerializable() {}
	public PersonSerializable(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	void print(){
		System.out.println(
				String.format("이름:%s,나이:%d,주소:%s",name,age,addr));
	}	
}
