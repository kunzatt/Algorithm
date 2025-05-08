import java.util.Scanner;

public class Main{
	
	static int N; 
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in); 
		N=scann.nextInt();
		for (int i = 0; i < N; i++) { 
			for(int j=N-i ; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}