package io24.filter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
자바의 클래스는 직렬화가 되야 파일로 저장하거나
네트웍을 통해 전송할 수 있다.

어떤 클래스를 직렬화 하려면 Serializable혹은 Externalizable
인터페이스를 구현(상속)해야 한다. 

*/
public class PersonExternalizable implements Externalizable {
	//[멤버 변수]
	String name;
	int age;
	String addr;
	public PersonExternalizable() {}
	public PersonExternalizable(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	void print(){
		System.out.println(
				String.format("이름:%s,나이:%d,주소:%s",name,age,addr));
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//멤버변수에 저장된값을 writeObject()메소드를 통해서
		//파일이나 네트웍을 통해 저장될 수 있도록
		//오버라이딩]	
		out.writeObject(name);
		out.writeObject(age);
		out.writeObject(addr);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		//멤버변수에 저장된 값을 readObject()메소드를 통해서
		//파일이나 네트웍을 통해 읽을 수 있도록
		//오버라이딩
		//위의  writeExternal()메소드에서 저장한 순서대로 read해야 한다.	
		name=(String)in.readObject();
		age=(Integer)in.readObject();
		addr=(String)in.readObject();
	}
	
	
}
