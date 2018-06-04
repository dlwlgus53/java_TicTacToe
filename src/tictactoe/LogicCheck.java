package tictactoe;

public class LogicCheck {
	static final int CONTINUE = 0;
	static final int USER_WIN = 1;
	static final int COMPUTER_WIN = 2;
	static final int NO_WIN = 3;
	
	public int ScoreCheck(int[][] scoreArray) {
		int win = 0;
		int i = 0;
				
	for (i = 0; i < 3; i++) {
			if ((scoreArray[0][i] == 1 && scoreArray[1][i] == 1 && scoreArray[2][i] == 1) 
					|| (scoreArray[i][0] == 1 && scoreArray[i][1] == 1 && scoreArray[i][2] == 1))
				win = USER_WIN;
			if ((scoreArray[0][i] == -1 && scoreArray[1][i] == -1 && scoreArray[2][i] == -1)
					|| (scoreArray[i][0] == -1 && scoreArray[i][1] == -1 && scoreArray[i][2] == -1))
				win = COMPUTER_WIN;		}
	
		if (scoreArray[0][0] == 1 && scoreArray[1][1] == 1 && scoreArray[2][2] == 1)
			win = USER_WIN;

		if (scoreArray[0][2] == 1 && scoreArray[1][1] == 1 && scoreArray[2][0] == 1)
			win = USER_WIN;
		
		if (scoreArray[0][0] == -1 && scoreArray[1][1] == -1 && scoreArray[2][2] == -1)
			win = COMPUTER_WIN;
		
		if (scoreArray[0][2] == -1 && scoreArray[1][1] == -1 && scoreArray[2][0] == -1)
			win = COMPUTER_WIN;
		
		if (win == USER_WIN) {
			return USER_WIN;
		}
		else if (win == COMPUTER_WIN) {
			return COMPUTER_WIN;
		}
		else {
			if (tie(scoreArray) == true) return NO_WIN;

			else return CONTINUE;
		}
		
	}
	
	public static boolean tie(int[][] array) {
		for (int row = 0; row < 3; row ++)
			for (int column = 0; column < 3; column ++)
				if (array[row][column] == 0) // 하나라도 0인 배열이 있으면 아직 게임이 덜 끝나서 계속 게임 진					return false;
			
		return true; // 만약 배열이 다 찼는데 이긴 사람이 없으면 tie 	}
}
