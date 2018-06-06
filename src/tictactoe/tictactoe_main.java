package tictactoe;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class tictactoe_main {

	public static void main(String[] args) throws FileNotFoundException {
		int count=1;
		System.out.println("|*******************Tic-Tac-Toe*******************|");
		Scanner scanner = new Scanner(System.in);
		String state = "Yes";
		
		// Make array map
		int[][] map = new int[3][3];
		LoadSave loadSaveHandler = new LoadSave();

		// Array initialize
		
		SaveMakeClean(map);
		Computer ai = new Computer();
		ai.inputlevel();

		int turn = Game.USER;
		int flag = Game.CONTINUE;
	
		
		LogicCheck check = new LogicCheck();
		RockPaperSissor ordergame = new RockPaperSissor();
		
		turn=ordergame.RPS();
		Print.origin();
		
		while(state.toLowerCase().charAt(0) == 'y') {
		
			// Handle input (in InputHandle, Logic check will be called and return that value)
			if (turn == Game.COMPUTER) {
				System.out.println("<<Computer turn>>");
				Game.sleep(1800);
				ai.computerInput(map);
				flag = check.ScoreCheck(map);
				Game.sleep(1500);//ÄÄÇ»ÅÍ ¸ÊÀº ´Ê°Ô ³ª¿À±â
			}
			else {
					InputHandle.run(map);
					flag = check.ScoreCheck(map);
					Game.sleep(500);
					
			}
			
			Print.show(map);
			
			if(flag != Game.CONTINUE) {
				winner(flag,count);
				count ++;
				loadSaveHandler.run(flag, "load_save.txt");
				System.out.print("Do you want to play game again? (Y/N) ");
				state = scanner.next();
				if (state.toLowerCase().charAt(0) == 'y') {
					SaveMakeClean(map);
					Print.origin();
					turn = (flag == Game.COMPUTER_WIN) ? Game.USER : Game.COMPUTER;
					continue;
				}
			}
			turn = (turn == Game.COMPUTER) ? Game.USER : Game.COMPUTER;
		}

		loadSaveHandler.showResult("load_save.txt");


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
	
	private static void winner(int flag, int count) {
		Game.sleep(500);
		  System.out.println("<<Result>>");
		if(flag == Game.USER_WIN)
			System.out.println("game " + count +" : "+ "  User win");
		else if(flag == Game.COMPUTER_WIN)
			System.out.println("game " + count +":"+ "  Computer win");
		else if(flag == Game.NO_WIN)
			System.out.println("game" + count +" : " + "  NO Winner");
	}
	
	
	


}
