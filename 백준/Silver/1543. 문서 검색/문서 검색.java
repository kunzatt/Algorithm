import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String str = br.readLine();

        int count = 0;
        int index = 0;

        while (index <= doc.length() - str.length()) {
            if (doc.substring(index, index + str.length()).equals(str)) {
                count++;
                index += str.length();
            } else {
                index++;
            }
        }

        System.out.println(count);
    }
}