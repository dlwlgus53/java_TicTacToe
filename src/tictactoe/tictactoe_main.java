package tictactoe;

import java.io.FileNotFoundException;

public class tictactoe_main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Make array for save_load 
		int[][] User_Save = new int[3][3];
		int[][] Computer_Save = new int[3][3];
		
		load_save ULS = new load_save();//UserLoadSave
		load_save CLS = new load_save();//ComputerLoadSave
		//array initialaize
		SaveMakeClean(User_Save);
		SaveMakeClean(Computer_Save);
		//pirnt board
		print board = new print();
		board.origin();
		board.show(User_Save, Computer_Save);
		int temp;
	//	int turn=0;
	//	int i,j;
	

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