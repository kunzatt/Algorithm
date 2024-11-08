import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10425 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            BigInteger N = new BigInteger(br.readLine());
            System.out.println(findFiboIndex(N));
        }
    }
    
    private static int findFiboIndex(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        int i = 1;
        int ans = -1;
        
        while (b.compareTo(n) <= 0) {
            if (b.equals(n)) {
                ans = i;
            }
            
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
            i++;
        }
        
        return ans;
    }
}
