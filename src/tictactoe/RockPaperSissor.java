package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class RockPaperSissor extends Game {
	    static int num;//��ǻ�� ���� �� 
		static int val=0;// ��ǻ��-����� �� 
		static String scanString;//����� ���� ���� �� �Է�
		
	public static void run() {
		
		Random random = new Random();
		
		num = random.nextInt(3);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������������ �Է����ּ���.");
		
		scanString = scan.nextLine();
		
	
		if (scanString.equals("����")) {
			val = 0;
		}else if (scanString.equals("����")) {
			val = 1;
		}else if (scanString.equals("��")) {
			val = 2;
		}
		
		if(num ==0 ) {
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
		}else if(num == 1) {
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
		}else if(num ==2 ) {
			System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
		}
	
		
	
}

public int RPS() {
	
	RockPaperSissor.run();
	
	switch (val) {
	case 0://����
		if (num == 0) {
			System.out.println("�����ϴ�.");
			RockPaperSissor.run();
		}else if (num == 1) {//����
			System.out.println("�����ϴ�.");
			return COMPUTER;
		}else if (num == 2) {
			System.out.println("�̰���ϴ�.");
			return USER;
		}
		break;
	case 1://����
		if (num == 0) {//����
			System.out.println("�̰���ϴ�.");
			return USER;
		}else if (num == 1) {//����
			System.out.println("�����ϴ�.");
			RockPaperSissor.run();
		
		}else if (num == 2) {//��
			System.out.println("�����ϴ�.");
			return COMPUTER;
		}
		break;

	case 2://��
		if (num == 0) {
			System.out.println("�����ϴ�.");
			return COMPUTER;
		}else if (num == 1) {
			System.out.println("�̰���ϴ�.");
			return USER;
		}else if (num == 2) {
			System.out.println("�����ϴ�.");
			RockPaperSissor.run();
		}
	break;}
	return -1;
	}
}
