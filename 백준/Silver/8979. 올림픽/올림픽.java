import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            if(a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });
        
        int rank = 1;
        for(int i = 0; i < n; i++) {
            if(i > 0 && (arr[i][1] != arr[i-1][1] || arr[i][2] != arr[i-1][2] || arr[i][3] != arr[i-1][3])) {
                rank = i + 1;
            }
            if(arr[i][0] == k) {
                System.out.println(rank);
                break;
            }
        }
    }
}