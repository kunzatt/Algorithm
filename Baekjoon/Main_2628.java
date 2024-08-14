import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2628 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> xlist = new ArrayList<>();
		ArrayList<Integer> ylist = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 1) {
				xlist.add(b);
			}
			if(a == 0) {
				ylist.add(b);
			}
		}
		xlist.add(r);
		ylist.add(c);
		int[] xarr = new int[xlist.size()+1];
		int[] yarr = new int[ylist.size()+1];
		xarr[0] = 100;
		yarr[0] = 100;
		int xmax = 0;
		int ymax = 0;
		Collections.sort(xlist);
		Collections.sort(ylist);
		
		for (int i = 0; i < xlist.size(); i++) {
			xarr[0] = Math.min(xarr[0], xlist.get(i));
		}
		for (int i = 0; i < xlist.size()-1; i++) {
			xarr[i+1] = Math.abs(xlist.get(i+1)-xlist.get(i));
		}
		for (int i = 0; i < ylist.size(); i++) {
			yarr[0] = Math.min(yarr[0], ylist.get(i));
		}
		for (int i = 0; i < ylist.size()-1; i++) {
			yarr[i+1] = Math.abs(ylist.get(i+1)-ylist.get(i));
		}
		
		for (int i = 0; i < xarr.length; i++) {
			xmax = Math.max(xmax, xarr[i]);
		}
		for (int i = 0; i < yarr.length; i++) {
			ymax = Math.max(ymax, yarr[i]);
		}		
		System.out.println(xmax*ymax);

	}

}
