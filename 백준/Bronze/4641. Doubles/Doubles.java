import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true){
            int count = 0;
            int num = 0;
            int arr[] = new int[16];
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()){
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) return;
                arr[num] = token;
                num++;
            }
            
            Arrays.sort(arr);
            for(int j = 0; j < 16; j++){
                for(int k = j; k < 16; k++){
                    if(arr[k] == 0 || arr[j] == 0) continue;
                    if(arr[k] == arr[j] * 2)
                        count++;
                }
            }
            System.out.println(count);
        }

    }
}