import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (stack.isEmpty() || stack.peek() != str.charAt(j)) {
                    stack.push(str.charAt(j));
                } else if (stack.peek() == str.charAt(j)) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) count++;
        }
        System.out.println(count);
        
    }
}