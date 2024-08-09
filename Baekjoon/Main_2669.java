import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[4][4];
		int[][] map = new int[101][101];
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int r = arr[i][1]; r < arr[i][3]; r++) { 
					for (int c = arr[i][0]; c < arr[i][2]; c++) {
						map[r][c]++;
					}
				}
			}
		}
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				if(map[r][c] > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
