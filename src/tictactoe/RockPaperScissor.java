package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor extends Game {
	static int num;//��ǻ�� ���� �� 
	static int val=0;// ��ǻ��-����� �� 
	static String scanString;//����� ���� ���� �� �Է�

	private static void run() {

		Random random = new Random();

		num = random.nextInt(3);
		Scanner scan = new Scanner(System.in);


		while(true) {
			System.out.print("  User : ");
			scanString = scan.nextLine();


			if (scanString.equals("scissor")) {
				val = 0;
			}else if (scanString.equals("rock")) {
				val = 1;
			}else if (scanString.equals("paper")) {
				val = 2;
			}else {
					System.out.println("   Plz input again");
					continue;
			}


			if(val != -1) {
				if(num ==0 ) {
					System.out.println("  Computer : scissor");
					break;
				}else if(num == 1) {
					System.out.println("  Computer : rock");
					break;
				}else if(num ==2 ) {
					System.out.println("  Computer : paper");
					break;
	
				}
			}
	
			
				
		}



	}

	public int RPS() {
		Game.sleep(500);
		Game.printSeq("Let's set order");
		Game.sleep(700);
		Game.printSeq(" Plz Enter (rock/paper/scissor)"); 
		RockPaperScissor.run();
		
		while(val == num) {
			Game.sleep(500);
			Game.printSeq("  DRAW\n");
			RockPaperScissor.run();
		}
		Game.sleep(500);

		switch (val) {
		case 0://����
			if (num == 0) {
				Game.printSeq("  DRAW!\n");
				RockPaperScissor.run();
			}else if (num == 1) {
				Game.printSeq("  computer WIN! computer do first");
				return COMPUTER;
			}else if (num == 2) {
				Game.printSeq("  user WIN! User do first");
				return USER;
			}
			break;
		case 1://����
			if (num == 0) {//����
				Game.printSeq("  user WIN! User do first");
				return USER;
			}else if (num == 1) {//����
				Game.printSeq("  DRAW!\n");
				RockPaperScissor.run();

			}else if (num == 2) {//��
				Game.printSeq("  computer WIN! computer do first");
				return COMPUTER;
			}
			break;

		case 2://��
			if (num == 0) {
				Game.printSeq("  computer WIN! computer do first");
				return COMPUTER;
			}else if (num == 1) {
				Game.printSeq("  user WIN! User do first");
				return USER;
			}else if (num == 2) {
				Game.printSeq("  DRAW!\n");
				RockPaperScissor.run();
			}
			break;}
		return -1;
	}
}
