import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = st.countTokens();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[n - 1]);
        return sb.toString();
    }
}