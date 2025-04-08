import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        switch((n - 1) % 8) {
            case 0: System.out.println(1); break;
            case 1: System.out.println(2); break;
            case 2: System.out.println(3); break;
            case 3: System.out.println(4); break;
            case 4: System.out.println(5); break;
            case 5: System.out.println(4); break;
            case 6: System.out.println(3); break;
            case 7: System.out.println(2); break;
        }

    }
}