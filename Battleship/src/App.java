import java.lang.annotation.Target;
import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sheme  = {"A1", "C1", "B2", "B3", "D2", "E2", "E4", "E5", "A5"};
		String[] target = {"A1", "B2", "C3", "D4", "E5", "E4"};
		Battleship battleship = new Battleship(sheme, target);
		//System.out.println(battleship.board());\
		/*for(String[] x : battleship.board) {
			for(String tmp:x) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}*/
		String[][] copy = battleship.board();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("hit: "+battleship.hits()+" sunk: "+battleship.sunk()+ " points: "+battleship.points());
		
	}
		

}
