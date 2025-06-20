import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = 1;
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            
            String[] names = new String[n];
            String[][] msgs = new String[n][];
            
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                names[i] = name;
                msgs[i] = new String[n-1];
                for (int j = 0; j < n-1; j++) {
                    msgs[i][j] = sc.next();
                }
            }
            
            List<String> nasty = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (msgs[i][j].equals("N")) {
                        int writer = (i - (j + 1) + n) % n;
                        nasty.add(names[writer] + " was nasty about " + names[i]);
                    }
                }
            }
            
            System.out.println("Group " + g);
            if (nasty.isEmpty()) {
                System.out.println("Nobody was nasty");
            } else {
                for (String s : nasty) {
                    System.out.println(s);
                }
            }
            System.out.println();
            g++;
        }
    }
}