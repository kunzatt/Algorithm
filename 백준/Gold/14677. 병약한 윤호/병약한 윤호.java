import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    
    static int N, max;
    static LinkedList<Integer> list;
    static Map<String, Integer> memo;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        list = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (ch == 'B') list.add(1);
            else if (ch == 'L') list.add(2);
            else if (ch == 'D') list.add(3);
        }
        
        memo = new HashMap<>();
        
        if (list.getFirst() == 1 || list.getLast() == 1) {
            max = 0;
            dfs(0, list);
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }
    
    private static void dfs(int count, LinkedList<Integer> list) {
        int num = count % 3 + 1;
        boolean flag = false;
        
        String key = list.toString() + "," + count;
        
        if (memo.containsKey(key) && memo.get(key) >= count) {
            return;
        }
        
        memo.put(key, count);
        
        if (!list.isEmpty() && list.getFirst() == num) {
            LinkedList<Integer> next = new LinkedList<>(list);
            next.removeFirst();
            dfs(count + 1, next);
            flag = true;
        }
        
        if (!list.isEmpty() && list.getLast() == num) {
            LinkedList<Integer> next = new LinkedList<>(list);
            next.removeLast();
            dfs(count + 1, next);
            flag = true;
        }
        
        if (!flag) {
            max = Math.max(count, max);
        }
    }
}
