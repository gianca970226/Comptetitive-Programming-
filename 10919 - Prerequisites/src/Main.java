
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
		String valor = "";
		while (!(valor = br.readLine()).equals("0")) {
			tokenize(valor);
			int numMaterias = nextInt();
			int categorias = nextInt();
			LinkedList<Integer> materias = new LinkedList<>();
			readLine();
			for (int i = 0; i < numMaterias; i++) {
				materias.add(nextInt());
			}

			HashMap<Integer, LinkedList<Integer>> requeridas = new HashMap<>();

			for (int i = 0; i < categorias; i++) {

				readLine();
				int numMateriasCategoria = nextInt();
				int numMateriasRequerida = nextInt();
				LinkedList<Integer> aux = new LinkedList<>();
				aux.add(numMateriasRequerida);
				for (int j = 0; j < numMateriasCategoria; j++) {
					aux.add(nextInt());
				}
				requeridas.put(i, aux);
			}
			Boolean bandera=true;
			
			for(Integer x:requeridas.keySet()) 
			{
				int cantidad=requeridas.get(x).getFirst();
				for (int i = 1; i < requeridas.get(x).size(); i++) {
					if(materias.contains(requeridas.get(x).get(i))) 
					{
						cantidad--;
					}
				}
				if(cantidad>0) 
				{
					bandera=false;
				}
				
			}
			if(bandera) 
			{
				System.out.println("yes");
			}else 
			{
				System.out.println("no");
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