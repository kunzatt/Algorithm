import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }
        
        StringBuilder ans = new StringBuilder();
        int total = 0;
        
        for (int j = 0; j < M; j++) {
            int[] count = new int[4]; 
            for (int i = 0; i < N; i++) {
                char nucleotide = dna[i].charAt(j);
                if (nucleotide == 'A') count[0]++;
                else if (nucleotide == 'C') count[1]++;
                else if (nucleotide == 'G') count[2]++;
                else if (nucleotide == 'T') count[3]++;
            }
            
            int maxCount = 0;
            char max = 'A';
            
            if (count[0] > maxCount) {
                maxCount = count[0];
                max = 'A';
            }
            if (count[1] > maxCount) {
                maxCount = count[1];
                max = 'C';
            }
            if (count[2] > maxCount) {
                maxCount = count[2];
                max = 'G';
            }
            if (count[3] > maxCount) {
                maxCount = count[3];
                max = 'T';
            }
            
            ans.append(max);
            total += (N - maxCount);
        }
        
        System.out.println(ans.toString());
        System.out.println(total);
    }
}