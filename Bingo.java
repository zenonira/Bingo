public class Bingo {
	
	public static boolean bingo(int[][] board, int[] drawn) {

		int[][] newBoard;
		newBoard=copyBoard(board);

		//System.out.println("Drawn");
		//printRow(drawn);
		for (int i =0; i<drawn.length; i++) {
			for (int row=0; row<board.length; row++) {
				//System.out.println("Row");
				//printRow(board[row]);
				for (int col=0; col<board[row].length; col++) {
					if (board[row][col] == drawn[i]) {
						newBoard[row][col] = 0;
					}
				}
			}
			newBoard[board.length/2][board.length/2]=0;
			
			if (checkRow(newBoard) == 0) {
				//System.out.println("found row");
				return true;
			}
			if (checkCol(newBoard) == 0) {
				//System.out.println("found col");
				return true;
			}
			if (newBoard[0][0] + newBoard[newBoard.length-1][0] + newBoard[0][newBoard.length-1] + newBoard[newBoard.length-1][newBoard.length-1] == 0) {
				return true;
			}
		}
		return false;
	}

	public static int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[board.length][board.length];

		for (int row=0; row<board.length; row++) {
			for (int col=0; col<board[row].length; col++) {
				newBoard[row][col] = board[row][col];
			}
		}
		return newBoard;
	}

	public static void printRow(int[] myrow) {
		String str = "";
		for(int row=0; row <myrow.length;row++) {
			str +=myrow[row]+" ";
		}
		System.out.println(str);
	}

	public static int checkRow(int[][] board) {
		int sum =0;
		for (int r=0; r<board.length; r++) {
			for (int c=0; c<board[r].length; c++) {
				sum += board[r][c];
			}
			if (sum == 0) {
				return 0;
			}
			sum = 0;

		}
		return 1;
	}

	public static int checkCol(int[][] board) {
		int sum =0;
		for (int r=0; r<board.length; r++) {
			for (int c=0; c<board[r].length; c++) {
				sum += board[c][r];
			}
			if (sum == 0) {
				return 0;
			}
			sum = 0;

		}
		return 1;

	}

}