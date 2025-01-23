import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong(), r = sc.nextLong();
		long x = Math.abs(sc.nextLong()), y = sc.nextLong();

		if (l > r) {
			long t = l;
			l = r;
			r = t;
		}

		if (r - l >= 2 * x || !(0 <= y && y < x)) {
			System.out.println("Unknwon Number");
			return;
		}

		long mod = ((l % x) + x) % x;
		long st = l + (mod <= y ? y - mod : x - mod + y);
		int count = 0;

		for (long i = st; i <= r; i += x)
			if ((((i % x) + x) % x) == y && ++count > 1) {
				System.out.println("Unknwon Number");
				return;
			}

		System.out.println(count == 0 ? "Unknwon Number" : st);
	}
}