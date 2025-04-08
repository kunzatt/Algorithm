import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 2];
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && arr[i - 1] > 0) {
                arr[i]++;
                arr[i - 1]--;
                continue;
            }
            if(arr[i] < 0 && arr[i + 1] > 0) {
                arr[i]++;
                arr[i + 1]--;
                continue;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0) count++;
        }
        return count;
    }
}