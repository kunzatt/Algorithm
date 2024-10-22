import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1373 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int anum = 0;

        StringBuilder ab = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String ans;
            anum = 0;
            for (int i = 0; i < 3; i++) {
                if (!stack.isEmpty()){
                    sb.append(stack.pop());
                }else {
                    sb.append(0);
                }

            }
            ans = String.valueOf(sb.reverse());
            int num = Integer.parseInt(ans);
            anum = num/100 * 4;
            num %= 100;
            anum += num/10 * 2;
            num %= 10;
            anum += num;

            ab.append(anum);
        }
        System.out.print(ab.reverse());

    }
}
