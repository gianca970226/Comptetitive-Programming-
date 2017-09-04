
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
		String valor;
		int n = 0;
		int dia = 1;

		while ((valor = br.readLine()) != null) {
			n = Integer.parseInt(valor);

			int cantidad = 0;
			String inicio = "10:00";
			int valorInicio = 600;
			String resInicio = "";
			TreeMap<Integer, LinkedList<String>> mapa = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				readLine();
				String aux = next();
				String[] arreglo1 = aux.split(":");
				int valor3 = Integer.parseInt(arreglo1[0]) * 60 + Integer.parseInt(arreglo1[1]);
				LinkedList<String> list = new LinkedList<>();
				list.add(aux);
				list.add(next());
				if (mapa.containsKey(valor3)) {
					String[] arreglo3 = mapa.get(valor3).getLast().split(":");
					int auxValor3 = Integer.parseInt(arreglo3[0]) * 60 + Integer.parseInt(arreglo3[1]);
					String[] arreglo4 = list.getLast().split(":");
					int auxValor4 = Integer.parseInt(arreglo4[0]) * 60 + Integer.parseInt(arreglo4[1]);
					
					if(auxValor4>auxValor3) 
					{
						mapa.put(valor3, list);
					}

				} else {
					mapa.put(valor3, list);
				}
			}
			int cont = 0;
			int valorAnteriorI = 0;
			int valorAnteriorF = 0;
			LinkedList<Integer> eliminar = new LinkedList<>();
			for (Integer valor45 : mapa.keySet()) {
				if (cont != 0) {
					if (valor45 >= valorAnteriorI && valor45 <= valorAnteriorF) {
						String auxV = mapa.get(valor45).getLast();
						String[] arreglo2 = auxV.split(":");
						int auxDato = Integer.parseInt(arreglo2[0]) * 60 + Integer.parseInt(arreglo2[1]);

						if (auxDato > valorAnteriorF) {
							mapa.get(valorAnteriorI).removeLast();
							mapa.get(valorAnteriorI).addLast(auxV);
							eliminar.add(valor45);
							valorAnteriorF = auxDato;
							// mapa.remove(valor45);
						} else {
							eliminar.add(valor45);

						}
					} else {
						valorAnteriorI = valor45;
						String[] arreglo1 = mapa.get(valor45).getLast().split(":");
						valorAnteriorF = Integer.parseInt(arreglo1[0]) * 60 + Integer.parseInt(arreglo1[1]);
					}

				} else {
					valorAnteriorI = valor45;
					String[] arreglo1 = mapa.get(valor45).getLast().split(":");
					valorAnteriorF = Integer.parseInt(arreglo1[0]) * 60 + Integer.parseInt(arreglo1[1]);
					cont++;
				}
			}
			for (int i = 0; i < eliminar.size(); i++) {
				 mapa.remove(eliminar.get(i));
			}

			for (Integer valor45 : mapa.keySet()) {
				// System.out.println(mapa.get(valor45).getFirst() + "-" +
				// mapa.get(valor45).getLast());
				String auxInicio = mapa.get(valor45).getFirst();
				String[] arreglo = auxInicio.split(":");
				int auxValor = Integer.parseInt(arreglo[0]) * 60 + Integer.parseInt(arreglo[1]) - valorInicio;
				if (auxValor > cantidad) {
					cantidad = auxValor;
					resInicio = inicio;
				}
				String auxFin = mapa.get(valor45).getLast();
				String[] arreglo1 = auxFin.split(":");
				valorInicio = Integer.parseInt(arreglo1[0]) * 60 + Integer.parseInt(arreglo1[1]);
				inicio = auxFin;
			}
			int valorFinal = 1080 - valorInicio;
			if (valorFinal > cantidad) {
				cantidad = valorFinal;
				resInicio = inicio;
			}
			if (cantidad / 60 > 0) {
				System.out.println("Day #" + dia++ + ": the longest nap starts at " + resInicio + " and will last for "
						+ (int) (cantidad / 60) + " hours and " + cantidad % 60 + " minutes.");
			} else {
				System.out.println("Day #" + dia++ + ": the longest nap starts at " + resInicio + " and will last for "
						+ cantidad + " minutes.");
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