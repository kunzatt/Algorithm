import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ch = str.toCharArray();
        int num = 0;
        char[] quack = {'q', 'u', 'a', 'c', 'k'};
        int[] arr = new int[ch.length];

        if (ch[0] != 'q' || ch.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < ch.length; j++) {
                if (ch[j] == 0 || ch[j] == quack[num]) {
                    num++;
                    list.add(ch[j]);
                    ch[j] = 1;
                    if (num == 5) num = 0;
                }
            }
            if (list.size() != 0) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                count++;
            }
        }
        System.out.println(count);

    }
}