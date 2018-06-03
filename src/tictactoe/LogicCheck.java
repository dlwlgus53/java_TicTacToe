package tictactoe;



public class LogicCheck {
	static final int CONTINUE = 0;
	static final int USER_WIN = 1;
	static final int COMPUTER_WIN = 2;
	static final int NO_WIN = 3;
	
	public int ScoreCheck(int[][] array) {
		int userScore = 0;
		int compScore = 0;
		int i, j = 0;
		
		int[][] scoreArray = new int[3][3];
		scoreArray = array;
		
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++) {
				if (scoreArray[i][j] == 1) // user input�� 1�̶�� ǥ�� 
					userScore =  (10^i)*(j+1);//�̻��ѰŰ��ƿ�...
				if (scoreArray[i][j] == -1) // computer input�� -1�̶�� ǥ�� 
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
				if (array[row][column] == 0) // �ϳ��� 0�� �迭�� ������ ���� ������ �� ������ ��� ���� ��
					return false;
			
		return true; // ���� �迭�� �� á�µ� �̱� ����� ������ tie 
	}
		
/*	public static void again() {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("������ �ٽ� �Ͻðڽ��ϱ�? (y/n)");
		String Again = kb.nextLine();

		if(Again.equalsIgnoreCase("y"))
			startGame();
		else
			endGame();
		
		kb.close();
	}
	
	public static void startGame() {
		System.out.println("t\t\t Tic - Tac - Toe"); //����� �ٽ� �����ϱ� ���� �� ���� �����ϴ� �κ��� �ҷ������� �ߴµ� �ϴ� �׷��� ��� ���� �ӽ÷� ��������..!
		System.out.println(" ");
		System.out.println("\t\t\t������ �����մϴ�!");
	}
	
	public static void endGame() {
		System.out.println("������ �������ϴ� !"); //���� ������ ���±��� �ߴ� ���� ����� �����ַ��� �ϴµ� ���� �ϼ����� �ʾҾ��...
	}*/
}
