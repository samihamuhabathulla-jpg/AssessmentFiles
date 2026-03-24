package ASSESSMENT1;

import java.util.Scanner;

public class Question5 {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int[] arr = new int[100];
	        int count = 0;

	        System.out.println("Enter the scores (enter negative number to stop):");

	        while(true) {
	            int num = sc.nextInt();

	            if(num < 0) {
	                break;
	            }

	            arr[count] = num;
	            count++;
	        }

	        System.out.println("Scores before processing:");
	        for(int i = 0; i < count; i++) {
	            System.out.print(arr[i] + " ");
	        }

	        System.out.println("\nScores after processing:");
	        for(int i = 0; i < count; i++) {
	            System.out.print(process(arr[i]) + " ");
	        }

	        sc.close();
	    }
public static int process(int num) {
 int result = 0;   
 
 if(num % 2 == 0) {
     result = 0;
 }

 if(num % 2 != 0) {
     if(1 > result) {
         result = 1;
     }
 }

 if(num % 8 == 0) {
     if(2 > result) {
         result = 2;
     }
 }

 if(num % 10 == 3) {
     if(3 > result) {
         result = 3;
     }
 }

 if(num % 9 == 0) {
     if(4 > result) {
         result = 4;
     }
 }

 return result;
}


}


