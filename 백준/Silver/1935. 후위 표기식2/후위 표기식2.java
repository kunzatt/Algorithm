import java.util.*;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String s = sc.next();
       double[] v = new double[n];
       
       for(int i = 0; i < n; i++) {
           v[i] = sc.nextDouble();
       }
       
       Stack<Double> st = new Stack<>();
       
       for(char c : s.toCharArray()) {
           if(c >= 'A' && c <= 'Z') {
               st.push(v[c - 'A']);
           } else {
               double b = st.pop();
               double a = st.pop();
               switch(c) {
                   case '+': st.push(a + b); break;
                   case '-': st.push(a - b); break;
                   case '*': st.push(a * b); break;
                   case '/': st.push(a / b); break;
               }
           }
       }
       
       System.out.printf("%.2f", st.pop());
   }
}