import java.io.*;
import java.util.*;

public class Main_10845 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push"	:
					que.add(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop" :
					if (!que.isEmpty()) System.out.println(que.poll());
					else System.out.println(-1);
					break;
					
				case "size" :
					System.out.println(que.size());
					break;
					
				case "empty" :
					if (que.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
					
				case "front" :
					if (!que.isEmpty()) System.out.println(que.peek());
					else System.out.println(-1);
					break;
					
				case "back" :
					if (!que.isEmpty()) System.out.println(que.toArray()[que.size()-1]);
					else System.out.println(-1);
					break;
					
			}
		}

	}

}
