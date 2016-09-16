import java.util.Scanner;

public class BDAYCAKE {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); in.nextLine();
		int[] missedCakes = new int[30*12];
		for (int i = 0; i < n; i++) {
			String ln = in.nextLine();
			int dd = (ln.charAt(0) - '0') * 10 + (ln.charAt(1) - '0');
			int mm = (ln.charAt(2) - '0') * 10 + (ln.charAt(3) - '0');
			int day = (mm - 1) * 30 + dd - 1;
			for (int j = 0; j < 30; j++) {
				int d = day - j;
				if (d < 0) d += 30*12;
				missedCakes[d]++;
			}
		}
		int best = 0;
		for (int i = 1; i < missedCakes.length; i++) {
			if (missedCakes[best] > missedCakes[i]) {
				best = i;
			}
		}
		int dd = best % 30 + 1;
		int mo = best / 30 + 1;
		if (dd < 10) System.out.print("0" + dd);
		else System.out.print(dd);
		if (mo < 10) System.out.println("0" + mo);
		else System.out.println(mo);
	}

}
