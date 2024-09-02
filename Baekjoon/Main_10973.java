import java.io.*;
import java.util.*;

public class Main_10973 {
	
	static int[] arr;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(np(N-1)) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
		}else {
			sb.append(-1);
		}
		System.out.println(sb);

	}

	static boolean np(int size) {
		
		int i = size;
		
		while (i > 0 && arr[i-1] >= arr[i]) i--;
		
		if (i == 0) return false;
		
		int j = size;
		
		while (arr[i-1] >= arr[j]) j--;
		
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		int k = size;
		
		while (i < k) {
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++;
			k--;
		}
		return true;
		
	}

}
