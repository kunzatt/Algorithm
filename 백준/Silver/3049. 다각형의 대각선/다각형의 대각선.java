import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long r = (long)n * (n-1) * (n-2) * (n-3) / 24;
        System.out.println(r);
    }
}