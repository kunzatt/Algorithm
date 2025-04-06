import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        List<SnowMan> list = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                list.add(new SnowMan(i, j, arr[i] + arr[j]));
            }
        }

        Collections.sort(list, (a, b) -> a.height - b.height);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                SnowMan snowMan1 = list.get(i);
                SnowMan snowMan2 = list.get(j);
                if (snowMan1.idx1 != snowMan2.idx1 &&
                        snowMan1.idx1 != snowMan2.idx2 &&
                        snowMan1.idx2 != snowMan2.idx1 &&
                        snowMan1.idx2 != snowMan2.idx2) {
                    ans = Math.min(Math.abs(snowMan1.height - snowMan2.height), ans);
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    static private class SnowMan {
        int idx1;
        int idx2;
        int height;

        public SnowMan(int idx1, int idx2, int height) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.height = height;
        }
    }
}