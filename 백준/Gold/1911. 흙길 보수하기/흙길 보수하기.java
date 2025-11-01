import java.io.*;
import java.util.*;

public class Main {
    
    static class I implements Comparable<I>{
        int s, e;
        public I(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(I o) {
            if(this.s == o.s)
                return o.e - this.e;
            return this.s - o.s;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<I> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new I(s, e));
        }
        int r = 0;
        int f = 0;
        while(!pq.isEmpty()){
            I c = pq.poll();
            if(c.e < f)
                continue;
            if(f < c.s)
                f = c.s;
            int rm = (c.e - f) % l;
            r += (c.e - f) / l;
            f = c.e;
            if(rm != 0) {
                r++;
                f += l - rm;
            }
        }
        bw.write(String.valueOf(r));
        bw.flush();
        bw.close();
    }
}