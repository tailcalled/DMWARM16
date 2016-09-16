import java.util.Scanner;

public class PACHINKO {

	static Double[][][] probcache;
	static String[] board;
	static int[] score;
	static int w, h, b, n;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		w = in.nextInt(); h = in.nextInt(); b = in.nextInt(); n = in.nextInt(); in.nextLine();
		probcache = new Double[w][h][w]; /* x, y, input */
		board = new String[h];
		for (int i = 0; i < h; i++) {
			board[i] = in.nextLine();
			board[i] = board[i].substring(1, board[i].length() - 1);
		}
		score = new int[b];
		in.nextLine();
		for (int i = 0; i < b; i++) {
			String ch = in.next();
			score[ch.charAt(0) - 'a'] = in.nextInt();
		}
		double expected = 0.0;
		scoreCache = new Double[w];
		for (int i = 0; i < n; i++) {
			expected += score(in.nextInt() - 1);
		}
		/*for (int q = 0; q < h; q++) {
		for (int i = 0; i < w; i++) {
			System.out.print(probcache[i][q][0] + " ");
		}
		System.out.println();
		}*/
		System.out.println(expected);
	}
	
	private static Double[] scoreCache;
	private static double score(int input) {
		if (scoreCache[input] == null) {
			scoreCache[input] = 0.0;
			for (int i = 0; i < w; i++) {
				if (board[h - 1].charAt(i) != '|') {
					scoreCache[input] += probability(i, h - 1, input) * score[board[h - 1].charAt(i) - 'a'];
				}
			}
		}
		return scoreCache[input];
	}
	private static double probability(int x, int y, int input) {
		if (y == 0 && x == input) return 1;
		if (x < 0 || x >= w) return 0;
		if (y < 0 || y >= h) return 0;
		if (block(x, y)) return 0;
		if (probcache[x][y][input] == null) {
			probcache[x][y][input] = probability(x, y - 1, input);
			if (x == 1 && block(x - 1, y)) probcache[x][y][input] += probability(x - 1, y - 1, input);
			if (x == w - 2 && block(x + 1, y)) probcache[x][y][input] += probability(x + 1, y - 1, input);
			if (x < w - 2) {
				if (block(x + 1, y)) probcache[x][y][input] += 0.5 * probability(x + 1, y - 1, input);
			}
			if (x > 1) {
				if (block(x - 1, y)) probcache[x][y][input] += 0.5 * probability(x - 1, y - 1, input);
			}
		}
		return probcache[x][y][input];
	}
	private static boolean block(int x, int y) {
		return board[y].charAt(x) == '.' || board[y].charAt(x) == '|';
	}

}
