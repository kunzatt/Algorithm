import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int n = people.length;
        int idx = 0;
        
        Arrays.sort(people);
        
        for (int i = n - 1; i >= idx; i--) {
            int sum = people[i];
            sum += people[idx];
            if (sum > limit) {
                count++;
                continue;
            } else {
                idx++;
                count++;
                continue;
            }
        }
        
        return count;
    }
}