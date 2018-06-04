package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class RockPaperSissor extends Game {
	    static int num;//컴퓨터 랜덤 값 
		static int val=0;// 컴퓨터-사용자 비교 
		static String scanString;//사용자 가위 바위 보 입력
		
	public static void run() {
		
		Random random = new Random();
		
		num = random.nextInt(3);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("가위바위보를 입력해주세요.");
		
		scanString = scan.nextLine();
		
	
		if (scanString.equals("가위")) {
			val = 0;
		}else if (scanString.equals("바위")) {
			val = 1;
		}else if (scanString.equals("보")) {
			val = 2;
		}
		
		if(num ==0 ) {
			System.out.println("컴퓨터는 가위를 냈습니다.");
		}else if(num == 1) {
			System.out.println("컴퓨터는 바위를 냈습니다.");
		}else if(num ==2 ) {
			System.out.println("컴퓨터는 보를 냈습니다.");
		}
	
		
	
}

public int RPS() {
	
	RockPaperSissor.run();
	
	switch (val) {
	case 0://가위
		if (num == 0) {
			System.out.println("비겼습니다.");
			RockPaperSissor.run();
		}else if (num == 1) {//바위
			System.out.println("졌습니다.");
			return COMPUTER;
		}else if (num == 2) {
			System.out.println("이겼습니다.");
			return USER;
		}
		break;
	case 1://바위
		if (num == 0) {//가위
			System.out.println("이겼습니다.");
			return USER;
		}else if (num == 1) {//바위
			System.out.println("비겼습니다.");
			RockPaperSissor.run();
		
		}else if (num == 2) {//보
			System.out.println("졌습니다.");
			return COMPUTER;
		}
		break;

	case 2://보
		if (num == 0) {
			System.out.println("졌습니다.");
			return COMPUTER;
		}else if (num == 1) {
			System.out.println("이겼습니다.");
			return USER;
		}else if (num == 2) {
			System.out.println("비겼습니다.");
			RockPaperSissor.run();
		}
	break;}
	return -1;
	}
}
