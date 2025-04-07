import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] sol = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0] - 1;
            int j = commands[t][1] - 1;
            int k = commands[t][2] - 1;
            int length = j - i + 1;
            int[] ans = new int[length];
            for (int s = 0; s < length; s++) {
                ans[s] = array[i + s];
            }
            Arrays.sort(ans);
            sol[t] = ans[k];
        }
        return sol;
    }
}