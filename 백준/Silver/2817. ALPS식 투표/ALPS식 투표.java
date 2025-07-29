import java.io.*;
import java.util.*;

public class Main {
    static class Staff {
        String name;
        int votes;
        int chips;
        
        Staff(String name, int votes) {
            this.name = name;
            this.votes = votes;
            this.chips = 0;
        }
    }
    
    static class Score {
        double value;
        int staffIdx;
        
        Score(double value, int staffIdx) {
            this.value = value;
            this.staffIdx = staffIdx;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        List<Staff> staffs = new ArrayList<>();
        List<Score> scores = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());
            
            if (votes >= x * 0.05) {
                staffs.add(new Staff(name, votes));
            }
        }
        
        for (int i = 1; i <= 14; i++) {
            for (int j = 0; j < staffs.size(); j++) {
                scores.add(new Score((double)staffs.get(j).votes / i, j));
            }
        }
        
        scores.sort((a, b) -> {
            if (a.value != b.value) {
                return Double.compare(b.value, a.value);
            }
            return staffs.get(a.staffIdx).name.compareTo(staffs.get(b.staffIdx).name);
        });
        
        for (int i = 0; i < Math.min(14, scores.size()); i++) {
            staffs.get(scores.get(i).staffIdx).chips++;
        }
        
        staffs.sort((a, b) -> a.name.compareTo(b.name));
        
        for (Staff staff : staffs) {
            System.out.println(staff.name + " " + staff.chips);
        }
    }
}