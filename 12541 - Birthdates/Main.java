import java.io.*;
import java.sql.Date;
import java.util.*;

public class Main {
	

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;
	public static void main(String[] args) throws Exception{
		new Main().solve();
	}
	
	void solve() throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("src/input"));
		pw = new PrintWriter(System.out);
		
		int n = 1;
		n=lineAsInt();
		LinkedList<String []>lista= new LinkedList<>();
		for (int i = 0; i < n; i++) {
			readLine();
			String [] arr= new String[4];
			for (int j = 0; j < 4; j++) {
				arr[j]=next();	
			}
			lista.add(arr);
			
		}
		Date FechaMinima = new Date(Integer.parseInt(lista.getFirst()[3]), Integer.parseInt(lista.getFirst()[2]), Integer.parseInt(lista.getFirst()[1]));
		Date fechaMaxima=FechaMinima;
	
		String maximoRes=lista.getFirst()[0];
		String minimoRes=lista.getFirst()[0];
		
		for (int i = 0; i < lista.size(); i++) {
			if(FechaMinima.after(new Date(Integer.parseInt(lista.get(i)[3]), Integer.parseInt(lista.get(i)[2]), Integer.parseInt(lista.get(i)[1])))) 
			{
				FechaMinima= new Date(Integer.parseInt(lista.get(i)[3]), Integer.parseInt(lista.get(i)[2]), Integer.parseInt(lista.get(i)[1]));
				minimoRes=lista.get(i)[0];
			}
			if(fechaMaxima.before(new Date(Integer.parseInt(lista.get(i)[3]), Integer.parseInt(lista.get(i)[2]), Integer.parseInt(lista.get(i)[1])))) 
			{
				fechaMaxima= new Date(Integer.parseInt(lista.get(i)[3]), Integer.parseInt(lista.get(i)[2]), Integer.parseInt(lista.get(i)[1]));
				maximoRes=lista.get(i)[0];
			}
		}

		System.out.println(maximoRes);
		System.out.println(minimoRes);
		
		br.close();
		pw.close();
		
	}
	
	void tokenize(String s) throws Exception{
		st = new StringTokenizer(s);
	}
	
	char[] lineAsCharArray() throws Exception{
		return br.readLine().toCharArray();
	}
	
	int lineAsInt() throws Exception{
		return Integer.parseInt(br.readLine());
	}
	
	long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	String next() throws Exception{
		return st.nextToken();
	}
	
	void readLine() throws Exception{
		st = new StringTokenizer(br.readLine());
	}
	
	void skipLine() throws Exception{
		br.readLine();
	}
	
}
