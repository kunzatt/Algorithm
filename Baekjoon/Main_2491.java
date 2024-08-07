import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2491 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int[N];
		
		// arr 순회
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 1;
		int max = 1; // max를 1로 초기화한다. N이 1일 경우 1이 나와야 하는데 아래의 반복문을 거치지 않으므로
		 		     // 출력할 때 1이 나오게 해야한다.
		
		// i값이 커질 수록 증가할 때의 max 구하기
		for (int i = 1; i < N; i++) {
			if(arr[i-1] <= arr[i]) {
				count ++;
				max = Math.max(max, count);
			}else {
				count = 1;
			}
		}
		
		// i값이 작아질 수록 증가할 때의 max 구하기
		count = 1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1] >= arr[i]) {
				count ++;
				max = Math.max(max, count);
			}else {
				count = 1;
			}
		}
		
		// 경우 나눠줄 필요 없이 max값을 출력하면 된다.
		bw.write(max + "\n");	
		
			
		bw.flush();
		bw.close();
	}

}
