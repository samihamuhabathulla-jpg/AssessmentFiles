package ASSESSMENT1;
import java.util.Scanner;
public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a positive integer : ");
		int n = sc.nextInt();
		int ans = 0;
		for(int i = 1;i<n;i++) {
			if(n%i==0) {
				ans+=i;
			}
		}
		if(ans == n) {
			System.out.println("The given number is perfect");
		}
		else {
			System.out.println("The given number is not perfect");
		}
	}

}