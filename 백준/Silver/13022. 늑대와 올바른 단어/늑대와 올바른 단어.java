import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idx = 0;
        boolean flag = true;

        while (idx < str.length() && flag) {
            int wCount = 0;
            while (idx < str.length() && str.charAt(idx) == 'w') {
                wCount++;
                idx++;
            }

            int oCount = 0;
            while (idx < str.length() && str.charAt(idx) == 'o') {
                oCount++;
                idx++;
            }

            int lCount = 0;
            while (idx < str.length() && str.charAt(idx) == 'l') {
                lCount++;
                idx++;
            }

            int fCount = 0;
            while (idx < str.length() && str.charAt(idx) == 'f') {
                fCount++;
                idx++;
            }

            if (wCount == 0 || wCount != oCount || oCount != lCount || lCount != fCount) {
                flag = false;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}