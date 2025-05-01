import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] list;
    static int[] arr;
    static int[] tarr;
    static int[] rarr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (true) {
                int neighbor = Integer.parseInt(st.nextToken());
                if (neighbor == 0) break;
                list[i].add(neighbor);
            }
        }

        arr = new int[N + 1];
        Arrays.fill(arr, -1);

        tarr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tarr[i] = (list[i].size() + 1) / 2;
        }

        rarr = new int[N + 1];

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> initialQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int person = Integer.parseInt(st.nextToken());
            arr[person] = 0;
            initialQueue.add(person);
        }

        spreadRumor(initialQueue);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
    }

    private static void spreadRumor(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i : list[curr]) {
                if (arr[i] != -1) continue;

                rarr[i]++;

                if (rarr[i] >= tarr[i]) {
                    arr[i] = arr[curr] + 1;
                    queue.add(i);
                }
            }
        }
    }
}