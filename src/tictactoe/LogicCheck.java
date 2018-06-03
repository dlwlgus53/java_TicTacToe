package tictactoe;



public class LogicCheck {
	static final int CONTINUE = 0;
	static final int USER_WIN = 1;
	static final int COMPUTER_WIN = 2;
	static final int NO_WIN = 3;
	
	public int ScoreCheck(int[][] array, int turn) {
		int userScore = 0;
		int compScore = 0;
		int i, j = 0;
		
		int[][] scoreArray = new int[3][3];
		scoreArray = array;
		
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++) {
				if (scoreArray[i][j] == 1) // user input을 1이라고 표시 
					userScore =  (10^i)*(j+1);//이상한거같아요...
				if (scoreArray[i][j] == -1) // computer input을 -1이라고 표시 
					compScore = (10^i)*(j+1);
			}
		
		if (userScore == 600 || userScore == 60 || userScore == 6 || userScore == 111 || userScore == 222 || userScore == 333 || userScore == 123 || userScore == 321) {
			
			//again();
			return USER_WIN;
		}
		else if (compScore == 600 || compScore == 60 || compScore == 6 || compScore == 111 || compScore == 222 || compScore == 333 || compScore == 123 || compScore == 321) {
			
			//again();
			return COMPUTER_WIN;
		}
		else {
			if (tie(scoreArray) == true) {
				
				//again();
				return NO_WIN;
			}
		else
				return CONTINUE;
		}
		
	}
	
	public static boolean tie(int[][] array) {
		for (int row = 0; row < 3; row ++)
			for (int column = 0; column < 3; column ++)
				if (array[row][column] == 0) // 하나라도 0인 배열이 있으면 아직 게임이 덜 끝나서 계속 게임 진
					return false;
			
		return true; // 만약 배열이 다 찼는데 이긴 사람이 없으면 tie 
	}
		
/*	public static void again() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("게임을 다시 하시겠습니까? (y/n)");
		String Again = kb.nextLine();

		if(Again.equalsIgnoreCase("y"))
			startGame();
		else
			endGame();
		
		kb.close();
	}
	
	public static void startGame() {
		System.out.println("t\t\t Tic - Tac - Toe"); //여기는 다시 게임하기 했을 때 게임 시작하는 부분을 불러오려고 했는데 일단 그런게 없어서 제가 임시로 만들었어요..!
		System.out.println(" ");
		System.out.println("\t\t\t게임을 시작합니다!");
	}
	
	public static void endGame() {
		System.out.println("게임이 끝났습니다 !"); //게임 끝나고 여태까지 했던 게임 결과를 보여주려고 하는데 아직 완성되지 않았어요...
	}*/
}
