package tictactoe;
import java. util.Scanner;
import java.util.Random;

public class Computer extends Game implements Runnable {
	private int level;

	Random random = new Random();

	public Computer(){
		//this.level = 1;메소드로 만들었어요.
	}

	//public Computer(int level){
	//	this.level = level;
	//}
	//메인말고 메소드로 만듬.

	public void inputlevel() {
		Scanner scanner = new Scanner(System.in);
		int level;
		Game.sleep(800);
		Game.printSeq("Enter the number of level 1.easy 2.middle 3.hard");
		Game.sleep(500);
		System.out.print("level : ");
	

		while(true){
			String scanString = scanner.nextLine();
			if (scanString.equals("1")) {
				level = 1;
				break;
			}else if (scanString.equals("2")) {
				level = 2;
				break;
			}else if (scanString.equals("3")) {
				level = 3;
				break;
			}else {
				System.out.println("   Plz input again");
				System.out.print("level : ");
				continue;
			}
		}


		Game.sleep(500);
		if(level ==1)
			Game.printSeq("you choose level 1" );
		else if (level == 2)
			Game.printSeq("you choose level 2" );
		else if(level ==3)
			Game.printSeq("you choose level 3" );
		Game.printSeq("******************************************************");


		//scanner.close();

	}

	public void run(int[][] map) {
		if (level == 1)
			randomInput(map);
		else if(level == 2)
			medium(map);
		else if (level == 3)
			computerInput(map);
	}

	private void medium(int[][] map) {
		int[][] copyMap = new int[3][3];
		int index = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				copyMap[i][j] = map[i][j];
				if (index == -1 && map[i][j] == BLANK)
					index = i * 3 + j;
			}
		}

		if (index == -1) {
			System.out.println("Map is full!");
			return;
		}

		int max = -1000;
		int maxIndex = -1;
		for (int i = index; i < 9; i++) {
			int result = calculate(copyMap, index, COMPUTER);
			if (result > max) {
				max = result;
				maxIndex = i;
			}
		}

		if (maxIndex == -1) {
			System.out.println("Computer fail");
			return;
		}

		map[maxIndex / 3][maxIndex % 3] = COMPUTER;
	}

	private int calculate(int[][] map, int index, int turn) {
		LogicCheck checker = new LogicCheck();
		map[index / 3][index % 3] = turn;

		int result = checker.ScoreCheck(map);
		if (result != CONTINUE) {
			if (result == USER)
				return 100;
			else
				return -100;
		}

		turn = (turn == COMPUTER) ? USER : COMPUTER;

		return calculate(map, index + 1, turn);
	}

	private void randomInput(int[][] map) {
		int n = random.nextInt(9);
		while(map[n / 3][n % 3] != 0)
			n = random.nextInt(9);

		map[n / 3][n % 3] = -1;
	}

	public void middleInput(int [][] map){
		if(chkDanger(map) == 9){

			if(chkOvrlap(map, 1, 1) == false){
				map[1][1] = -1;
			}

			else if(chkOvrlap(map, 0, 0) == false){
				map[0][0] = -1;
			}
			else if(chkOvrlap(map, 2, 2) == false){
				map[2][2] = -1;
			}
			else if(chkOvrlap(map, 0, 2) == false){
				map[0][2] = -1;
			}
			else if(chkOvrlap(map, 2, 0) == false){
				map[2][0] = -1;
			}

			else{
				while(true){
					int computer = random.nextInt();
					int i = Math.abs(computer % 3);
					computer = Math.abs(random.nextInt());
					int j = Math.abs(computer % 3);
					if(chkOvrlap(map, i, j) == false){
						map[i][j] = -1;
						break;
					}
				}
			}
		}


		else{
			if(chkOvrlap(map, chkDanger(map)/3, chkDanger(map)%3) == false){
				map[chkDanger(map)/3][chkDanger(map)%3] = -1;
			}
			else{
				while(true){
					int computer = Math.abs(random.nextInt());
					int i = computer % 3;
					computer = Math.abs(random.nextInt());
					int j = computer % 3;
					if(chkOvrlap(map, i, j) == false){
						map[i][j] = -1;
						break;
					}
				}
			}
		}

	}

	public void computerInput(int[][] map){
		if(chkChance(map) != 9 && chkOvrlap(map, chkChance(map)/3, chkChance(map)%3) == false){
			map[chkChance(map)/3][chkChance(map)%3] = -1;
		}

		else{

			if(chkDanger(map) == 9){

				if(chkOvrlap(map, 1, 1) == false){
					map[1][1] = -1;
				}

				else if(chkOvrlap(map, 0, 0) == false){
					map[0][0] = -1;
				}
				else if(chkOvrlap(map, 2, 2) == false){
					map[2][2] = -1;
				}
				else if(chkOvrlap(map, 0, 2) == false){
					map[0][2] = -1;
				}
				else if(chkOvrlap(map, 2, 0) == false){
					map[2][0] = -1;
				}

				else{
					while(true){
						int computer = random.nextInt();
						int i = Math.abs(computer % 3);
						computer = Math.abs(random.nextInt());
						int j = Math.abs(computer % 3);
						if(chkOvrlap(map, i, j) == false){
							map[i][j] = -1;
							break;
						}
					}
				}
			}


			else{
				if(chkOvrlap(map, chkDanger(map)/3, chkDanger(map)%3) == false){
					map[chkDanger(map)/3][chkDanger(map)%3] = -1;
				}
				else{
					while(true){
						int computer = Math.abs(random.nextInt());
						int i = computer % 3;
						computer = Math.abs(random.nextInt());
						int j = computer % 3;
						if(chkOvrlap(map, i, j) == false){
							map[i][j] = -1;
							break;
						}
					}
				}
			}

		}

	}

	int chkDanger(int map[][]){
		if((map[0][0] == 1 && map[0][1] == 1) || (map[0][0] == 1 && map[0][2] == 1) || (map[0][1] == 1 && map[0][2] == 1)){
			for(int j = 0; j < 3; j++){
				int i = 0;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[1][0] == 1 && map[1][1] == 1) || (map[1][0] == 1 && map[1][2] == 1) || (map[1][1] == 1 && map[1][2] == 1)){
			for(int j = 0; j < 3; j++){
				int i = 1;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[2][0] == 1 && map[2][1] == 1) || (map[2][0] == 1 && map[2][2] == 1) || (map[2][1] == 1 && map[2][2] == 1)){
			for(int j = 0; j < 3; j++){
				int i = 2;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][0] == 1 && map[1][0] == 1) || (map[0][0] == 1 && map[2][0] == 1) || (map[1][0] == 1 && map[2][0] == 1)){
			for(int i = 0; i < 3; i++){
				int j = 0;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][1] == 1 && map[1][1] == 1) || (map[0][1] == 1 && map[2][1] == 1) || (map[1][1] == 1 && map[2][1] == 1)){
			for(int i = 0; i < 3; i++){
				int j = 1;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][2] == 1 && map[1][2] == 1) || (map[0][2] == 1 && map[2][2] == 1) || (map[1][2] == 1 && map[2][2] == 1)){
			for(int i = 0; i < 3; i++){
				int j = 2;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][0] == 1 && map[1][1] == 1) || (map[0][0] == 1 && map[2][2] == 1) || (map[1][1] == 1 && map[2][2] == 1)){
			for(int i = 0; i < 3; i++){
				int j = i;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][2] == 1 && map[1][1] == 1) || (map[0][2] == 1 && map[2][0] == 1) || (map[1][1] == 1 && map[2][0] == 1)){
			if(chkOvrlap(map, 0, 2) == false){
				return 2;
			}
			else if(chkOvrlap(map, 1, 1) == false){
				return 4;
			}
			else if(chkOvrlap(map, 2, 0) == false){
				return 6;
			}
		}
		return 9;
	}

	int chkChance(int map[][]){
		if((map[0][0] == -1 && map[0][1] == -1) || (map[0][0] == -1 && map[0][2] == -1) || (map[0][1] == -1 && map[0][2] == -1)){
			for(int j = 0; j < 3; j++){
				int i = 0;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[1][0] == -1 && map[1][1] == -1) || (map[1][0] == -1 && map[1][2] == -1) || (map[1][1] == -1 && map[1][2] == -1)){
			for(int j = 0; j < 3; j++){
				int i = 1;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[2][0] == -1 && map[2][1] == -1) || (map[2][0] == -1 && map[2][2] == -1) || (map[2][1] == -1 && map[2][2] == -1)){
			for(int j = 0; j < 3; j++){
				int i = 2;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][0] == -1 && map[1][0] == -1) || (map[0][0] == -1 && map[2][0] == -1) || (map[1][0] == -1 && map[2][0] == -1)){
			for(int i = 0; i < 3; i++){
				int j = 0;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][1] == -1 && map[1][1] == -1) || (map[0][1] == -1 && map[2][1] == -1) || (map[1][1] == -1 && map[2][1] == -1)){
			for(int i = 0; i < 3; i++){
				int j = 1;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][2] == -1 && map[1][2] == -1) || (map[0][2] == -1 && map[2][2] == -1) || (map[1][2] == -1 && map[2][2] == -1)){
			for(int i = 0; i < 3; i++){
				int j = 2;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][0] == -1 && map[1][1] == -1) || (map[0][0] == -1 && map[2][2] == -1) || (map[1][1] == -1 && map[2][2] == -1)){
			for(int i = 0; i < 3; i++){
				int j = i;
				if(chkOvrlap(map, i, j) == false){
					return 3*i+j;
				}
			}
		}
		if((map[0][2] == -1 && map[1][1] == -1) || (map[0][2] == -1 && map[2][0] == -1) || (map[1][1] == -1 && map[2][0] == -1)){
			if(chkOvrlap(map, 0, 2) == false){
				return 2;
			}
			else if(chkOvrlap(map, 1, 1) == false){
				return 4;
			}
			else if(chkOvrlap(map, 2, 0) == false){
				return 6;
			}
		}
		return 9;
	}

	boolean chkOvrlap(int map[][], int i, int j){
		if(map[i][j] == 0){
			return false;
		}
		else{
			return true;
		}
	}
}