import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Integer> blist = new ArrayList<>();
        List<Integer> flist = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(' && str.charAt(i + 1) == '(') {
                blist.add(i);
            } else if (str.charAt(i) == ')' && str.charAt(i + 1) == ')') {
                flist.add(i);
            }
        }

        int count = 0;
        for (int i : blist) {
            for (int j : flist) {
                if (i < j) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}