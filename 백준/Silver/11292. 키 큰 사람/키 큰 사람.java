import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            double max = 0.0;
            ArrayList<String> list = new ArrayList<>();
            StringTokenizer st;
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double temp = Double.parseDouble(st.nextToken());
                if (temp > max) {
                    max = temp;
                    list.clear();
                    list.add(name);
                } else if (temp == max) {
                    list.add(name);
                }
            }

            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }




}