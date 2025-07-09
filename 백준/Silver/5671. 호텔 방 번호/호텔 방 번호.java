import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int count = 0;
            while (N <= M) {
                String number = Integer.toString(N);
                int score = 0;
                for (int i = 0; i < number.length() - 1; i++) {
                    for (int j = i + 1; j < number.length(); j++) {
                        if (number.charAt(i) == number.charAt(j)) {
                            score++;
                            break;
                        }
                    }
                }
                if (score == 0)
                    count++;
                N++;
            }
            System.out.println(count);

        }

    }
}