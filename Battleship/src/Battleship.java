import java.util.Arrays;

/*
CHARACTERS SET
0    ➞ blank
1    ➞ ship
2    ➞ miss
3   ➞ hit
*/

public class Battleship {
	private String[] scheme;
	private String[] target;
	public String[][] board;
	public Battleship(String[] scheme, String[] target) {
		this.scheme = scheme;
		this.target = target;
		this.board = new String[5][5];
		for(String[] row: board){
			Arrays.fill(row,"0");
		}
	}
	public String[][] board() {
		String copy[][] = new String[5][5];
		for(int i=0;i<5;i++) {
			copy[i] = Arrays.copyOf(board[i], 5);
		}
		for(String mark:scheme) {
			int row = mark.charAt(0)-'A';
			int col = mark.charAt(1)-'1';
			copy[row][col] = "1";
		}
		
		for(String atk:target) {
			int row = atk.charAt(0)-'A';
			int col = atk.charAt(1)-'1';
			//Attack success
			if(copy[row][col].equals("1")) {
				copy[row][col] = "3";
			}
			else {
				copy[row][col] = "2";
			}
		}
		return copy;
		
	}
	public int hits() {
		
		int cnt=0;
		String copy[][] = new String[5][5];
		for(int i=0;i<5;i++) {
			copy[i] = Arrays.copyOf(board[i], 5);
		}
		for(String mark:scheme) {
			int row = mark.charAt(0)-'A';
			int col = mark.charAt(1)-'1';
			copy[row][col] = "1";
		}
		
		for(String atk:target) {
			int row = atk.charAt(0)-'A';
			int col = atk.charAt(1)-'1';
			//Attack success
			if(copy[row][col].equals("1")) {
				cnt++;
				copy[row][col] = "3";
			}
			else {
				copy[row][col] = "2";
			}
		}
		return cnt;
		
	}
	
	private int countConnectedComponents(String[][] matrix, int row, int col, String symbol) {
	    if (row < 0 || row >= 5 || col < 0 || col >= 5 || (!matrix[row][col].equals(symbol))) {
	        // Base case: if the current cell is out of bounds or doesn't contain the symbol, return 0
	        return 0;
	    }
	    
	    // Mark the current cell as visited
	    matrix[row][col] = " ";
	    
	    // Recursively count the connected components in all four directions
	    int count = 1;
	    count += countConnectedComponents(matrix, row+1, col, symbol); // Down
	    count += countConnectedComponents(matrix, row-1, col, symbol); // Up
	    count += countConnectedComponents(matrix, row, col+1, symbol); // Right
	    count += countConnectedComponents(matrix, row, col-1, symbol); // Left
	    
	    return count;
	}
	public int sunk() {
		String copy[][] = new String[5][5];
		int ans = 0 ;
		copy = new Battleship(scheme, target).board();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(copy[i][j].equals("3")) {
					int cnt = countConnectedComponents(copy, i, j, "3");
					ans += cnt/2;
				}
			}
		}
		return ans;
		
		
	}
	public int points() {
		int hit = new Battleship(scheme, target).hits();
		int sunk = new Battleship(scheme, target).sunk();
		int sum = 0;
		sum+= sunk*2;
		sum+= hit;
		return sum;
		
	}
}