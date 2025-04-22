import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            Long N = Long.parseLong(br.readLine());
            if (N <= 1) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                if (isPrime(N)) {
                    sb.append(N).append("\n");
                    break;
                }
                N++;
            }
        }

        System.out.println(sb);

    }

    public static boolean isPrime(long N) {
        if (N <= 1) return false;
        if (N <= 3) return true;
        if (N % 2 == 0 || N % 3 == 0) return false;

        long sqrt = (long) Math.sqrt(N);
        for (long i = 5; i <= sqrt; i += 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}