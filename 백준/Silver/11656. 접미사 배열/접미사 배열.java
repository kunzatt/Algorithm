import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }
        
        Collections.sort(list);
        
        for (String str : list) {
            System.out.println(str);
        }
    }
}