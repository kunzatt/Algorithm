import java.io.*;
import java.util.*;

public class Main_1085 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int ans = Math.min(Math.min(x, y), Math.min(w-x, h-y));
		System.out.println(ans);

	}

}
