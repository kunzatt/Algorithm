import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] arr : clothes) {
            String type = arr[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int ans = 1;
        for (int i : map.values()) {
            ans *= (i + 1);
        }
        return ans - 1;
    }
}