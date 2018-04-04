package exception21;

public class ClubApp {

	public static void main(String[] args) {
		Club club= new Club();
		
		try {
			club.entrance("남루", 22);
		} catch (NotGoodAppearnceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장", 15);
		} catch (NotGoodAppearnceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장", 50);
		} catch (NotGoodAppearnceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrance("정장", 25);
		} catch (NotGoodAppearnceException e) {
			System.out.println(e.getMessage());
		}
	}/////////////

}///////////////////
