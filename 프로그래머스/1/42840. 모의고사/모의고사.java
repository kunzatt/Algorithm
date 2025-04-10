import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0;
        int count2 = 0;        
        int count3 = 0;     
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i % 5]) count1++;
            if (answers[i] == num2[i % 8]) count2++;
            if (answers[i] == num3[i % 10]) count3++;            
        }
        
        int max = 0;
        max = Math.max(max, Math.max(count1, Math.max(count2, count3)));
        if (max == count1) list.add(1);
        if (max == count2) list.add(2);
        if (max == count3) list.add(3);
        
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
        
    }
}