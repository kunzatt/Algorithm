import java.io.*;
import java.util.*;

public class Main_10866 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push_front" :
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;

				case "push_back" :
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop_front" :
					if (!deque.isEmpty()) System.out.println(deque.removeFirst());
					else System.out.println(-1);
					break;

				case "pop_back" :
					if (!deque.isEmpty()) System.out.println(deque.removeLast());
					else System.out.println(-1);
					break;
					
				case "size" :
					System.out.println(deque.size());
					break;
					
				case "empty" :
					if (deque.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
					
				case "front" :
					if (!deque.isEmpty()) System.out.println(deque.peekFirst());
					else System.out.println(-1);
					break;

				case "back" :
					if (!deque.isEmpty()) System.out.println(deque.peekLast());
					else System.out.println(-1);
					break;
					
			}
		}

	}

}
