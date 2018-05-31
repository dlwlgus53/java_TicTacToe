package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class load_save {
	int i,j;
	String FileName;
	
	load_save() {
		FileName = null;
	}
	
	public void save(String FileName, int[][] Load_Save) throws FileNotFoundException  {
			PrintWriter output = new PrintWriter(FileName);
			for(i=0;i<3;i++) {
				for(j=0;j<3;j++) {
					output.println(Load_Save[i][j]);
				}
			}
			output.close();
	}
			

		
	
	
	public void load(String FileName, int[][] Load_Save) throws FileNotFoundException {
		File inputFile = new File(FileName);
		Scanner scan = new Scanner(inputFile);
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				Load_Save[i][j] = scan.nextInt();
			}
		}
		scan.close(); 
		
	}
	
	public void run(int temp, int[][]Load_Save){
		if(temp==1)
			Load_Save[0][0]=1;
		if(temp==2)
			Load_Save[0][1]=1;
		if(temp==3)
			Load_Save[0][2]=1;
		if(temp==4)
			Load_Save[1][0]=1;
		if(temp==5)
			Load_Save[1][1]=1;
		if(temp==6)
			Load_Save[1][2]=1;
		if(temp==7)
			Load_Save[2][0]=1;
		if(temp==8)
			Load_Save[2][1]=1;
		if(temp==9)
			Load_Save[2][2]=1;		
	}
}
