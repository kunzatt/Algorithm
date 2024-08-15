import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {
	// 이진 탐색으로 풀지 않고 반복문으로 풀면 시간초

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] com = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < com.length; i++) {
			com[i] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(arr); // 이진 탐색은 정렬 필수.
		
		for (int i = 0; i < com.length; i++) {
			System.out.print(binarySearch(arr, com[i])+" ");
		}
	}
	static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(arr[mid] == key) {
				return 1;
			}else if(arr[mid]<key) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return 0;
	}
	
}
