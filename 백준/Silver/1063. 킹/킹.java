import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String k = s[0];
        String p = s[1];
        int n = Integer.parseInt(s[2]);
        
        int kx = k.charAt(0) - 'A';
        int ky = k.charAt(1) - '1';
        int px = p.charAt(0) - 'A';
        int py = p.charAt(1) - '1';
        
        for(int i = 0; i < n; i++) {
            String m = br.readLine();
            int dx = 0, dy = 0;
            
            if(m.contains("R")) dx = 1;
            if(m.contains("L")) dx = -1;
            if(m.contains("B")) dy = -1;
            if(m.contains("T")) dy = 1;
            
            int nkx = kx + dx;
            int nky = ky + dy;
            
            if(nkx < 0 || nkx >= 8 || nky < 0 || nky >= 8) continue;
            
            if(nkx == px && nky == py) {
                int npx = px + dx;
                int npy = py + dy;
                if(npx < 0 || npx >= 8 || npy < 0 || npy >= 8) continue;
                px = npx;
                py = npy;
            }
            
            kx = nkx;
            ky = nky;
        }
        
        System.out.println((char)('A' + kx) + "" + (ky + 1));
        System.out.println((char)('A' + px) + "" + (py + 1));
    }
}