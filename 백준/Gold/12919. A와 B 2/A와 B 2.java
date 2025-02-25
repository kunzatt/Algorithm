import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(dfs(S, T));
    }

    private static int dfs(String S, String T) {
        if (S.length() == T.length()) {
            return S.equals(T) ? 1 : 0;
        }

        int ans = 0;

        if (T.charAt(T.length() - 1) == 'A') {
            String next = T.substring(0, T.length() - 1);
            ans = dfs(S, next);
        }

        if (ans == 0 && T.charAt(0) == 'B') {
            String R = new StringBuilder(T.substring(1)).reverse().toString();
            ans = dfs(S, R);
        }

        return ans;
    }
}