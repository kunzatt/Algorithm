import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String min = null;

        for (int i = 1; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String part1 = str.substring(0, i);
                String part2 = str.substring(i, j);
                String part3 = str.substring(j);

                StringBuilder sb1 = new StringBuilder(part1);
                StringBuilder sb2 = new StringBuilder(part2);
                StringBuilder sb3 = new StringBuilder(part3);

                String reversed1 = sb1.reverse().toString();
                String reversed2 = sb2.reverse().toString();
                String reversed3 = sb3.reverse().toString();

                String result = reversed1 + reversed2 + reversed3;

                if (min == null || result.compareTo(min) < 0) {
                    min = result;
                }
            }
        }

        System.out.println(min);
    }
}