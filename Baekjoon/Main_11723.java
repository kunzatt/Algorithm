import java.io.*;
import java.util.*;

public class Main_11723 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				
				case "add" :
					int a = Integer.parseInt(st.nextToken());
					if (!list.contains(a)) list.add(a);
					break;
				case "check" :
					if (list.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "remove" :
					int b = Integer.parseInt(st.nextToken());
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j) == b) {
							list.remove(j);
							break;
						}
					}
					break;
				case "toggle" :
					int c = Integer.parseInt(st.nextToken());
					if (list.contains(c)) {
						for (int j = 0; j < list.size(); j++) {
							if (list.get(j) == c) {
								list.remove(j);
								break;
							}
						}						
					}
					else if (!list.contains(c)) list.add(c);
					break;
				case "all" : 
					list.clear();
					for (int j = 1; j <= 20; j++) {
						list.add(j);
					}
					break;
				case "empty" :
					list.clear();
					break;			
			}
		}
		System.out.println(sb);

	}

}
