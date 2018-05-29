package tictactoe;

public class print {
	int[][] UserAndCom = new int[3][3];

	print(){
		int i=0,j=0;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				UserAndCom[i][j] = 0;
			}
		}
	}

	public void origin() {
		System.out.println(" 1 太 2 太 3");
		System.out.println(" 天     天    天");
		System.out.println(" 4 太 5 太 6");
		System.out.println(" 天     天    天");
		System.out.println(" 7 太 8 太 9");
	}
	
	public void show(int[][] user_load,int[][] computer_load) {
		sum(user_load,computer_load);
		int i=0,j=0;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				System.out.print(UserAndCom[i][j] + " " );
			}
			System.out.println(" ");
		}	
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(UserAndCom[i][j] == 0) {
					System.out.print("  ");
					System.out.print("| ");
				}
				else if(UserAndCom[i][j] ==1) {
					System.out.print(" O ");
					System.out.print("|");
				}
				else if(UserAndCom[i][j] == -1) {
					System.out.print(" X ");
					System.out.print("|");
					
				}
			}
			System.out.println("\n"+" 天     天    天");
			
		}
	}

	private void sum(int[][] user_load,int[][] computer_load ) {
		//user = 1;
		//com = -1;

		int i=0,j=0;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				UserAndCom[i][j] = 0;
			}
		}
		//compare with user_load and update UserAndCom
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(user_load[i][j]==1)
					UserAndCom[i][j] = 1;
			}
		}

		//compare with computer_load and update UserAndCom
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(computer_load[i][j]==1)
					UserAndCom[i][j] = -1;
			}
		}

	}

}
