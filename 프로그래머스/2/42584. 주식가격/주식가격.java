import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        
        for (int i = 0; i < len; i++) {
            int count = 0;
            
            for (int j = i + 1; j < len; j++) {
                count++;
                if (prices[i] > prices[j]) break;                
            }
            
            ans[i] = count;
        }
        
        return ans;        
    }
}