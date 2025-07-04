import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int o = 0;
        int r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                o++;
            } else {
                if (o > 0) {
                    o--;
                } else {
                    r++;
                }
            }
        }
        
        System.out.println(o + r);
    }
}