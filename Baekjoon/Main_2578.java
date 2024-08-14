import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578 {
	
	static int count;
	static int[][] bingo;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bingo = new int[5][5];
		count = 0;
		int ans = 1;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if(bingo[k][l] == num) {
							bingo[k][l] = 0;
						}
					}
				}
				ccheck();
				rcheck();
				dcheck();
				rdcheck();
				
				if(count >= 3) {
					System.out.println(ans);
					System.exit(0);
				}
				count = 0;
				ans++;
			}
		}
	}
	public static void ccheck() {
		for (int i = 0; i < 5; i++) {
			int zerocount = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[j][i] == 0) {
					zerocount++;
				}
				if(zerocount == 5) {
					count++;
				}
			}
		}
	}
	public static void rcheck() {
		for (int i = 0; i < 5; i++) {
			int zerocount = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0) {
					zerocount++;
				}
				if(zerocount == 5) {
					count++;
				}
			}
		}
	}
	public static void dcheck() {
		int zerocount = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0) {
				zerocount++;
			}
			if (zerocount == 5) {
				count++;
			}
		}
	}
	public static void rdcheck() {
		int zerocount = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4-i] == 0) {
				zerocount++;
			}
			if (zerocount == 5) {
				count++;
			}
		}
	}
}