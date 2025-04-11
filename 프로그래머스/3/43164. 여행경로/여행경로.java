import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<String> answers;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(answers);
        
        return answers.get(0).split(" ");
    }
    
    public void dfs(String start, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            answers.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}