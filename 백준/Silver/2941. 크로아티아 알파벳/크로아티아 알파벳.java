import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = new char[str.length()];
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		}
		
		int count = 0;
		
		for (int i = 0; i < ch.length - 2; i++) {
			if (ch[i] == 'd' && ch[i + 1] == 'z' && ch[i + 2] == '=') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
				ch[i+2] = 0;
			}			
		}
		
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] == 'c' && ch[i + 1] == '=') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 'c' && ch[i + 1] == '-') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 'd' && ch[i + 1] == '-') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 'l' && ch[i + 1] == 'j') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 'n' && ch[i + 1] == 'j') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 's' && ch[i + 1] == '=') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
			if (ch[i] == 'z' && ch[i + 1] == '=') {
				count++;
				ch[i] = 0;
				ch[i+1] = 0;
			}
		}
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != 0) count++;
		}
		
		System.out.println(count);

	}

}
