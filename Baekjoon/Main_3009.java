import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3009 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[3][2];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(arr[0][0] == arr[1][0]) {
			sb.append(arr[2][0]).append(" ");
		}else if(arr[0][0] == arr[2][0]) {
			sb.append(arr[1][0]).append(" ");
		}else if(arr[1][0] == arr[2][0]) {
			sb.append(arr[0][0]).append(" ");
		}
		
		if(arr[0][1] == arr[1][1]) {
			sb.append(arr[2][1]);
		}else if(arr[0][1] == arr[2][1]) {
			sb.append(arr[1][1]);
		}else if(arr[1][1] == arr[2][1]) {
			sb.append(arr[0][1]);
		}
		
		System.out.println(sb);

	}

}
