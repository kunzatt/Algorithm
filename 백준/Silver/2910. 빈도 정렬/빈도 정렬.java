import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            cnt.put(a[i], cnt.getOrDefault(a[i], 0) + 1);
            if (!idx.containsKey(a[i])) {
                idx.put(a[i], i);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        
        list.sort((x, y) -> {
            if (cnt.get(x) != cnt.get(y)) {
                return cnt.get(y) - cnt.get(x);
            }
            return idx.get(x) - idx.get(y);
        });
        
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            for (int i = 0; i < cnt.get(num); i++) {
                sb.append(num).append(" ");
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}