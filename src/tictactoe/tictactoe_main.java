package tictactoe;

import java.util.Scanner;

public class tictactoe_main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String state = "Yes";
		
		// Make array map
		int[][] map = new int[3][3];
		LoadSave loadSaveHandler = new LoadSave();

		// Array initialize
		SaveMakeClean(map);
		System.out.println("choose the leve 1.easy 2.middle 3.hard");
		int level = scanner.nextInt();
		
		
		Computer ai = new Computer(level);
		int turn = Game.USER;
		int flag = Game.CONTINUE;
	
		
		
		Print.origin();
		LogicCheck check = new LogicCheck();
		RockPaperSissor ordergame = new RockPaperSissor();
		turn=ordergame.RPS();
		
		while(state.toLowerCase().charAt(0) == 'y') {
			// Handle input (in InputHandle, Logic check will be called and return that value)
			if (turn == Game.COMPUTER) {
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
			
			if (flag != Game.CONTINUE) {

				if (turn == Game.USER_WIN) {
					// User win process
					System.out.println("You win!!");
				}
				else if(turn == Game.COMPUTER_WIN) {
					// Computer win process
					System.out.println("Computer win!!");
				}
				else {
						System.out.println("no winner!!");
				}
				
				System.out.print("Do you want to play game again? (Y/N) ");
				state = scanner.next();
				if (state.toLowerCase().charAt(0) == 'y') {
					SaveMakeClean(map);
					turn = Game.USER;
					continue;
				}
			}
			turn = (turn == Game.COMPUTER) ? Game.USER : Game.COMPUTER;
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
