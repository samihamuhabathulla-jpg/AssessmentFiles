package ASSESSMENT1;

import java.util.Scanner;

public class Question4 {
	    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Starting Number: ");
	        int start = sc.nextInt();

	        System.out.print("Enter Ending Number: ");
	        int end = sc.nextInt();

	        for(int i = start; i <= end; i++) {

	            if(i % 10 == 0) {
	                System.out.print("dong ");
	            }
	            else if(i % 5 == 0) {
	                System.out.print("ding ");
	            }
	            else {
	                System.out.print(i + " ");
	            }
	        }

	        sc.close();
	    }
	}



