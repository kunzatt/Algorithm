import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;        
        int start = 0;
        List<Integer> list = new ArrayList<>();
        
        while (start < len) {
            
            for (int i = 0; i < len; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    if (progresses[i] > 100) {
                        progresses[i] = 100;
                    }
                }
            }
            
            int count = 0;
            while (start < len && progresses[start] >= 100) {
                count++;
                start++;
            }
            
            if (count > 0) {
                list.add(count);
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}