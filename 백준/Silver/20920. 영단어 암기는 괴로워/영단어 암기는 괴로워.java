import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String,Integer>> sortWords = new ArrayList<>(words.entrySet());
        sortWords.sort((a,b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue();
            }
            if (b.getKey().length() != a.getKey().length()) {
                return b.getKey().length() - a.getKey().length();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String,Integer> entry : sortWords) {
            bw.write(entry.getKey() + "\n");
        }
        bw.flush();
    }
}