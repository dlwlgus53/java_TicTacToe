package tictactoe;

public class Print {

	public static void origin() {
		//ó�� ǥ �����ִ� �Լ�
		System.out.println(" 1 �� 2 �� 3");
		System.out.println(" ��     ��    ��");
		System.out.println(" 4 �� 5 �� 6");
		System.out.println(" ��     ��    ��");
		System.out.println(" 7 �� 8 �� 9");
	}
	
	public static void show(int[][] map) {
		//������¸� �����ִ� �Լ�
		
		int i=0,j=0;
		System.out.println("\n"+" ��     ��    ��");
		for(i=0;i<3;i++) {
			System.out.print("| ");
			for(j=0;j<3;j++) {
				if(map[i][j] == 0) {
					System.out.print(" ");
					System.out.print("| ");
				}
				else if(map[i][j] ==1) {
					System.out.print("O");
					System.out.print("| ");
				}
				else if(map[i][j] == -1) {
					System.out.print("X");
					System.out.print("| ");
					
				}
			}
			System.out.println("\n"+" ��     ��    ��");
			
		}
		System.out.println("\n\n");
	}

	

}
