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
		System.out.println("|*******************Tic-Tac-Toe*******************|");
		System.out.println("|*                                              **|");
		System.out.println("|***  choose the level 1.easy 2.middle 3.hard  ***|");

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
			
			Print.show(map);
			
			if(flag != Game.CONTINUE) {
				//check.winnerCheck(flag);
				loadSaveHandler.run(flag, "load_save.txt");
				System.out.print("Do you want to play game again? (Y/N) ");
				state = scanner.next();
				if (state.toLowerCase().charAt(0) == 'y') {
					SaveMakeClean(map);
					turn = (flag == Game.COMPUTER_WIN) ? Game.USER : Game.COMPUTER;

					continue;
				}
			}
			turn = (turn == Game.COMPUTER) ? Game.USER : Game.COMPUTER;
		}
		loadSaveHandler.printResult("load_save.txt");
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
