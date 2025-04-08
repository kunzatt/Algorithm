import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            List<String> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            
            while (true) {
                String temp = br.readLine();
                if (temp.equals("what does the fox say?")) break;
                st = new StringTokenizer(temp);
                for (int i = 0; i < 3; i++) {
                    String str = st.nextToken();
                    if (i == 2) {
                        list.removeIf(item -> item.equals(str));
                    }
                }
            }
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }        
    }
}