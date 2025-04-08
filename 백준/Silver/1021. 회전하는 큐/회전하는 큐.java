import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int count = 0;
    static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[M];
        for(int i = 0 ; i < M ; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++) {
            deque.add(i);
        }

        for (int i = 0; i < M; i++) {
            if (check(temp[i])) {
                while (temp[i] != deque.get(0)) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                while (temp[i] != deque.get(0)) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.poll();
        }
        System.out.println(count);
    }

    private static boolean check(int num) {
        for (int i = 0; i <= deque.size() / 2; i++) {
            if (deque.get(i) == num) {
                return true;
            }
        }
        return false;
    }

}