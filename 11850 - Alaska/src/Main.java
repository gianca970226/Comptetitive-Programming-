import java.io.*;
import java.util.*;

public class Main {

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}

	void solve() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("src//input"));
		pw = new PrintWriter(System.out);

		int n = 0;
		while ((n = lineAsInt()) != 0) {
			LinkedList<Integer> estaciones = new LinkedList<>();
			int valor = lineAsInt();

				estaciones.add(valor);
				for (int i = 0; i < n - 1; i++) {
					estaciones.add(lineAsInt());
				}
			
			 Collections.sort(estaciones);
			int valor2 = 0;
			for (int i = 0; i < estaciones.size() ; i++) {
				valor2 = estaciones.get(i);
				if (i != estaciones.size() - 1) {
					if (valor2 + 200 < estaciones.get(i + 1)) {
						break;
					}
				}
			}
			if ((1422-valor2)*2<200) {
				System.out.println("POSSIBLE");
			} else {
				System.out.println("IMPOSSIBLE");
			}

		}

	}

	void tokenize(String s) throws Exception {
		st = new StringTokenizer(s);
	}

	char[] lineAsCharArray() throws Exception {
		return br.readLine().toCharArray();
	}

	int lineAsInt() throws Exception {
		return Integer.parseInt(br.readLine());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	String next() throws Exception {
		return st.nextToken();
	}

	void readLine() throws Exception {
		st = new StringTokenizer(br.readLine());
	}

	void skipLine() throws Exception {
		br.readLine();
	}

}