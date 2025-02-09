import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  
        StringBuilder answer = new StringBuilder();  
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse() + " ");  
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}


// import java.io.*;
// import java.util.*;

// public class Main {
	
// 	static StringBuilder sb = new StringBuilder();

// 	public static void main(String[] args) throws Exception {
		
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int T = Integer.parseInt(br.readLine());
		
// 		for (int i = 0; i < T; i++) {
// 			ArrayList<String> list = new ArrayList<String>();
// 			StringTokenizer st = new StringTokenizer(br.readLine());
			
// 			while (st.hasMoreElements()) {
// 				String str = st.nextToken();
// 				list.add(str);
// 			}
			
// 			flip(list);
// 			System.out.println(sb);
// 		}

// 	}

// 	static void flip(ArrayList<String> list) {
		
// 		Stack<Character> stack = new Stack<>();
		
// 		for (int i = 0; i < list.size(); i++) {
// 			String str = list.get(i);
// 			for (int j = 0; j < str.length(); j++) {
// 				stack.push(str.charAt(j));
// 			}
// 			while (!stack.isEmpty()) {
// 				sb.append(stack.pop());
// 			}
// 			sb.append(" ");
// 		}
		
// 	}

// }
