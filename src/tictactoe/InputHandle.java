package tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandle {
   
   public static void run(int[][] map) {
         
         Scanner kb = new Scanner(System.in);

         int number;
         
         try {
            do {
                System.out.println("<<Input number>>");
                number = kb.nextInt(); 
                
             }while(check(map, number) == false);
         }
         
         catch(InputMismatchException e) {
              System.out.println("���ڸ� �Է¹޾ҽ��ϴ�.");
              run(map);
            }
         
         return;
      }

   private static boolean check (int[][] map, int num) {

      int row ;
      int column ;
      
      switch(num) {
      case 0:
         System.out.println("1~9������ ������ �Է����ּ���~");
         return false;
      case 1:
         row = 0;
         column = 0;
         break;
      case 2:
         row = 0;
         column = 1;
         break;
      case 3:
         row = 0;
         column = 2;
         break;
      case 4:
         row = 1;
         column = 0;
         break;
      case 5:
         row = 1;
         column = 1;
         break;
      case 6:
         row = 1;
         column = 2;
         break;
      case 7:
         row = 2;
         column = 0;
         break;
      case 8:
         row = 2;
         column = 1;
         break;
      case 9:
         row = 2;
         column = 2;
         break;
      default:
         row = -1;
         column = -1;   
      }
      //..?���⹺��..�̻��ѰŰ��ƿ� 
      if(row < 0) {
         System.out.println(num + ": NO Number!!");
         return false;
      }else {
         if(1 == map[row][column]) {
            System.out.println("It's already exist-user");
            return false;
         }
         else if(-1 == map[row][column]) {
            System.out.println("It's already exist-com");
            return false;
         }
         else {
            map[row][column]=1;
            return true;
         }
      }
      
 
   }
   
}