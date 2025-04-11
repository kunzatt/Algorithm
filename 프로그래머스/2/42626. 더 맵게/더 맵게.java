import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            pq.add(mix(num1, num2));
            count++;
        }
        
        if (pq.isEmpty() || pq.peek() < K) {
            return -1;
        }
        
        return count;
    }
    
    private static int mix(int a, int b) {
        return a + (2 * b);
    }
}