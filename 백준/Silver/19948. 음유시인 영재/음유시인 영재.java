import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        map.put(' ', Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        char prev = 0;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur != prev) {
                if (cur != ' ') {
                    char lower = Character.toLowerCase(cur);
                    if (map.get(lower) <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    map.put(lower, map.get(lower) - 1);
                } else {
                    if (map.get(' ') <= 0) {
                        System.out.println(-1);
                        return;
                    }
                    map.put(' ', map.get(' ') - 1);
                }
            }

            prev = cur;
        }

        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }
        }

        prev = 0;
        for (int i = 0; i < sb.length(); i++) {
            char cur = sb.charAt(i);
            if (cur != prev) {
                char lower = Character.toLowerCase(cur);
                if (map.get(lower) <= 0) {
                    System.out.println(-1);
                    return;
                }
                map.put(lower, map.get(lower) - 1);
            }
            prev = cur;
        }

        System.out.println(sb);
    }
}