package tictactoe;

import java.util.Scanner;

public class tictactoe_main {
	static final int COMPUTER = 1;
	static final int USER = 0;
	
	// For test, these will be removed when program released
	static final int CONTINUE = 0;
	static final int USER_WIN = 1;
	static final int COMPUTER_WIN = 2;
	static final int NO_WIN = 3;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Make array map
		int[][] map = new int[3][3];
		LoadSave loadSaveHandler = new LoadSave();

		// Array initialize
		SaveMakeClean(map);
		
		Computer ai = new Computer();
		int turn = USER;
		int flag = CONTINUE;
		
		LogicCheck check = new LogicCheck();
		Print.origin();
		
		RockPaperSissor ordergame = new RockPaperSissor();
		turn=ordergame.RPS();
		
		while(true) {
			// Handle input (in InputHandle, Logic check will be called and return that value)
			if (turn == COMPUTER) {
				System.out.println("<<computer>>");
				ai.computerInput(map);
				flag = check.ScoreCheck(map);
			}
			else {
					InputHandle.run(map);
					flag = check.ScoreCheck(map);
			}
			
			// Save 
			try {
				loadSaveHandler.save("load_save.txt", map);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Print.show(map);
			
			if (flag != CONTINUE)
				break;
			turn = (turn == COMPUTER) ? USER : COMPUTER;
		}
		
		if (turn == USER_WIN) {
			// User win process
			System.out.println("You win!!");
		}
		else if(turn == COMPUTER_WIN) {
			// Computer win process
			System.out.println("Computer win!!");
		}
		else {
				System.out.println("no winner!!");
		}
		
		scanner.close();
	}

	private static void SaveMakeClean(int[][]array) {
		int i=0;
		int j=0;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				array[i][j] = 0;
			}
		}
	}


}
