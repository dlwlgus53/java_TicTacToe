package tictactoe;

import java.util.Scanner;

public class InputClass {
   //char 배열이 아니라 int 배열이라 파라미터 수장하겠습니당!
	//static 굳이 안써도 될거같아요
   public int input(int[][] user, int[][] com) {
      
      Scanner kb = new Scanner(System.in);
      int number;
      
      do {
         System.out.println("<<Input number>>");
         number = kb.nextInt();
         //close추가했습니당.
         kb.close();
      }while(check(number, user, com) == false);
      kb.close();
      return number;
      
   }
   //int배열로 수정하겠습니당
   //static 굳이 안써도 될거같아요
   private boolean check (int num, int[][] user, int[][] com) {

      int row ;
      int column ;
      
      switch(num) {
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
      //..?여기뭔가..이상한거같아요 
      if(row < 0) {
         System.out.println(num + ": NO Number!!");
         return false;
      }else {
    	  if(1==user[row][column]) {
    		  System.out.println("It's already exist-user");
    		  return false;
    	  }
    	  else if(1==com[row][column]) {
    		  System.out.println("It's already exist-com");
    		  return false;
    	  }
    	  else
    		  return true;
  
         
      }
   }
   


}
