
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shiritori testShiritori = new Shiritori();
		testShiritori.play("hostess");
		
		System.out.println(testShiritori
				.toString());
		testShiritori.play("stash");
		System.out.println(testShiritori.toString());
	}

}
