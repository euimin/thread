package swing27.model;

import java.sql.Date;

//하나의 레코드를 저장할수 있는 자료구조
//DTO(Data Transfer Object)계열 클래스
public class MemberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String age;
	private java.sql.Date regidate;
	
	//[생성자]
	public MemberDTO() {}	
	public MemberDTO(String id, String pwd, String name, String age, Date regidate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.regidate = regidate;
	}
	//[게터/세터]
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	
	
}
