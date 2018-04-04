package console.academy;

public class AcademyApp {

	public static void main(String[] args) {
		//배열 사용]
		//AcademyLogic logic = new AcademyLogic();
		//컬렉션 사용]
		//AcademyCollectionLogic logic = new AcademyCollectionLogic();
		//파일 저장 메뉴 추가-FileReader/FileWriter사용
		//AcademyCollectionFileRWLogic logic= new AcademyCollectionFileRWLogic();
		//파일 저장 메뉴 추가-ObjectInputStream/ObjectOutputStream필터사용
		AcademyCollectionObjectLogic logic= new AcademyCollectionObjectLogic();
		while(true){
			//1.메인 메뉴 출력]
			logic.printMainMenu();
			//2.메뉴 번호 입력 받기]
			int mainMenu = logic.getMenuNumber();
			//3.메인메뉴에 따른 분기]
			logic.seperateMainMenu(mainMenu);
		}/////////////while
	}////////////////main

}///////////////////class
