import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String month = input[0];
        int d = Integer.parseInt(input[1].substring(0, input[1].length() - 1));
        int y = Integer.parseInt(input[2]);
        String[] time = input[3].split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        
        String[] mn = {"January", "February", "March", "April", "May", "June", 
                       "July", "August", "September", "October", "November", "December"};
        int[] md = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
            md[1] += 1;
        }
        
        int tt = 0;
        for (int day : md) {
            tt += day;
        }
        tt *= 24 * 60;
        
        int idx = 0;
        for (int i = 0; i < 12; i++) {
            if (mn[i].equals(month)) {
                idx = i;
                break;
            }
        }
        
        int ct = 0;
        for (int i = 0; i < idx; i++) {
            ct += md[i];
        }
        ct = (ct + d - 1) * 24 * 60 + h * 60 + m;
        
        System.out.println((double)ct / tt * 100);
    }
}