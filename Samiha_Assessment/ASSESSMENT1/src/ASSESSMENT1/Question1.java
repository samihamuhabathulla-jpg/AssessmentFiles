package ASSESSMENT1;
import java.util.Scanner;
public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No.of participants : ");
		int participants = sc.nextInt();
		int first = 0, second = 0, third = 0,ans = 0;
		int[] arr = new int[participants];
		for(int i = 0;i<participants;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Token for no.of participants is ");
		System.out.print("[");
		for(int i = 0;i<participants;i++) {
			System.out.print(arr[i]);
			if(i<participants-1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
		for(int i = 0;i<participants;i++) {
			ans = sumofDigits(arr[i]);
			if(ans>9) {
			       ans = sumofDigits(ans);
				}
			System.out.println("sum "+ans);
				if(ans==7) {
					first = arr[i];
				}
				else if(ans == 5) {
					second = arr[i];
				}
				else if(ans == 3) {
					third = arr[i];
				}
		}
		System.out.println("First prize is to token : "+first);
		System.out.println("Second prize is to token : "+second);
		System.out.println("Third prize is to token : "+third);
		
	}
	public static int sumofDigits(int a) {
		int sum = 0;
		while(a>0) {
			sum+=a%10;
			a/=10;
		}
		return sum;
	}

}
			
			
			
		
        

		


		

	


