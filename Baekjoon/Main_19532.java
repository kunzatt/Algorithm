import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19532 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		int[] arr = new int[6];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(((arr[2]*arr[4])-(arr[5]*arr[1]))/((arr[0]*arr[4])-(arr[3]*arr[1]))+" ");
		System.out.println(((arr[2]*arr[3])-(arr[5]*arr[0]))/((arr[1]*arr[3])-(arr[4]*arr[0])));

	}

}
