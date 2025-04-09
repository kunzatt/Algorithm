import java.util.*;
import java.io.*;

class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        
        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> turn = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            turn.put(time, direction);
        }
    
        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});  
        map[0][0] = 2;  
        
        int dir = 0;    
        int time = 0;  
        
        while (true) {
            time++;
            
            int[] head = snake.peekLast();
            int nr = head[0] + dr[dir];
            int nc = head[1] + dc[dir];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
                break;
            }
            
            if (map[nr][nc] != 1) {
                int[] tail = snake.poll();
                map[tail[0]][tail[1]] = 0;
            }
            
            snake.offer(new int[]{nr, nc});
            map[nr][nc] = 2;
            
            if (turn.containsKey(time)) {
                if (turn.get(time).equals("L")) {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
        
        System.out.println(time);
    }
}