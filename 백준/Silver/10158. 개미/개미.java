import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		if(((p+t)/w)%2 == 0) {
			p = (p+t)%(2*w);
		}else if(((p+t)/w)%2 == 1) {
			p = w - ((p+t)%(2*w)-w);
		}
		
		if(((q+t)/h)%2 == 0) {
			q = (q+t)%(2*h);
		}else if(((q+t)/h)%2 == 1) {
			q = h - ((q+t)%(2*h)-h);
		}
		sb.append(p).append(" ").append(q);
		System.out.println(sb);
	}

}
