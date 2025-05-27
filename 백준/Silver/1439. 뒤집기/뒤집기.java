import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count0 = 0;
        int count1 = 0;

        char current = str.charAt(0);
        if (current == '0') count0++;
        else count1++;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != current) {
                current = str.charAt(i);
                if (current == '0') count0++;
                else count1++;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}