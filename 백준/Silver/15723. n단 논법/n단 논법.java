import java.util.*;

public class Main {
    static final int INF = 1000000000;
    static final int MAX = 26;
    static int[][] d = new int[MAX][MAX];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                d[i][j] = (i == j) ? 0 : INF;
            }
        }
        
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            char a = line[0].charAt(0);
            char b = line[2].charAt(0);
            d[a - 'a'][b - 'a'] = 1;
        }
        
        for(int k = 0; k < MAX; k++) {
            for(int i = 0; i < MAX; i++) {
                for(int j = 0; j < MAX; j++) {
                    if(d[i][k] != INF && d[k][j] != INF) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        
        int m = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            char x = line[0].charAt(0);
            char y = line[2].charAt(0);
            System.out.println(d[x - 'a'][y - 'a'] == INF ? "F" : "T");
        }
        
        sc.close();
    }
}