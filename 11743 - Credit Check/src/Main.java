
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
		//br = new BufferedReader(new FileReader("src/input"));
		pw = new PrintWriter(System.out);
		int n = lineAsInt();
		for (int i = 0; i < n; i++) {
			int[] arreglo = new int[16];
			readLine();
			String bloque = next();
			arreglo[0] = Integer.parseInt(bloque.charAt(0) + "");
			arreglo[1] = Integer.parseInt(bloque.charAt(1) + "");
			arreglo[2] = Integer.parseInt(bloque.charAt(2) + "");
			arreglo[3] = Integer.parseInt(bloque.charAt(3) + "");
			bloque = next();
			arreglo[4] = Integer.parseInt(bloque.charAt(0) + "");
			arreglo[5] = Integer.parseInt(bloque.charAt(1) + "");
			arreglo[6] = Integer.parseInt(bloque.charAt(2) + "");
			arreglo[7] = Integer.parseInt(bloque.charAt(3) + "");
			bloque = next();
			arreglo[8] = Integer.parseInt(bloque.charAt(0) + "");
			arreglo[9] = Integer.parseInt(bloque.charAt(1) + "");
			arreglo[10] = Integer.parseInt(bloque.charAt(2) + "");
			arreglo[11] = Integer.parseInt(bloque.charAt(3) + "");
			bloque = next();
			arreglo[12] = Integer.parseInt(bloque.charAt(0) + "");
			arreglo[13] = Integer.parseInt(bloque.charAt(1) + "");
			arreglo[14] = Integer.parseInt(bloque.charAt(2) + "");
			arreglo[15] = Integer.parseInt(bloque.charAt(3) + "");
			int[] arreglo2 = new int[8];
			int contador = 0;
			int valorA=0;
			int valorB=0;
			int valorC=0;
			for (int j = 0; j < arreglo.length; j++) {
				arreglo2[contador] = arreglo[j] * 2;
				j++;
				contador++;
			}
			for (int j = 1; j < arreglo.length; j++) {
				valorB+= arreglo[j];
				j++;
				
			}
			for (int j = 0; j < arreglo2.length; j++) {
				if(arreglo2[j]>9) 
				{
					valorA+=(arreglo2[j]/10)+arreglo2[j]%10;
				}else 
				{
					valorA+=arreglo2[j];
				}
			}
			valorC=valorA+valorB;
			String resutaldo=toString().valueOf(valorC);
			if(resutaldo.charAt(resutaldo.length()-1)=='0') 
			{
				System.out.println("Valid");
			}else 
			{
				System.out.println("Invalid");
			}
		}

		br.close();
		pw.close();

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