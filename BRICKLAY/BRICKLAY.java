import java.util.Scanner;

public class BRICKLAY {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int w = in.nextInt(), h = in.nextInt();
		int bs = 0, hs = 0;
		for (int l = 0; l < h; l++) {
			if ((w & 1) == 0) {
				if ((l & 1) == 0) {
					bs += w/2;
				}
				else {
					bs += w/2 - 1;
					hs += 2;
				}
			}
			else {
				bs += w/2;
				hs += 1;
			}
		}
		System.out.println(bs + " " + hs);
	}

}
