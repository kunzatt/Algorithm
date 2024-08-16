import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int ans = A*B*C;
		String str = Integer.toString(ans);
		int[] arrNum = new int[str.length()];
		int[] arr = new int[10];
		for (int i = 0; i < str.length(); i++) {
			arrNum[i] = str.charAt(i)-'0';
		}
		for (int i = 0; i < str.length(); i++) {
			arr[arrNum[i]]++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
