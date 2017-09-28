import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

class book implements Comparable<book> {
	String nameBook;
	String autors;

	book(String nameBook, String autors) {

		this.nameBook = nameBook;
		this.autors = autors;
	}

	@Override
	public int compareTo(book o) {
		int res = this.autors.compareTo(o.autors);
		if (res == 0) {
			return this.nameBook.compareTo(o.nameBook);
		} else {
			return res;
		}
	}

}

class Main {
	static BufferedReader br;
	static LinkedList<book> shelving;
	static LinkedList<book> mesa;
	public static book findBook(String libro) {
		for (int i = 0; i < shelving.size(); i++) {
			if (shelving.get(i).nameBook.equals(libro)) {
				return shelving.get(i);
			}
		}
		return null;
	}

	public static void main(String argslength[]) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		shelving = new LinkedList<>();
		mesa = new LinkedList<>();
		while (!(line = br.readLine()).equals("END")) {
			String[] date = line.split("by");
			String nameBook = date[0];
			String autor = date[1].replace(".", "").replace(",", "").trim().replace(" ", "");
			shelving.add(new book(nameBook.trim(), autor.trim()));
		}
		Collections.sort(shelving);
		LinkedList<book> auxSheving = (LinkedList<book>) shelving.clone();
		while (!(line = br.readLine()).equals("END")) {

			if (line.equals("SHELVE")) {
				Collections.sort(mesa);
				while (!mesa.isEmpty()) {
					book auxBook = mesa.pop();
					auxSheving.add(auxBook);
					Collections.sort(auxSheving);
					for (int i = 0; i < auxSheving.size(); i++) {
						if (auxSheving.get(i).equals(auxBook)) {
							if (i == 0) {
								System.out.println("Put " + auxBook.nameBook + " first");
							} else {
								System.out.println(
										"Put " + auxBook.nameBook + " after " + auxSheving.get(i - 1).nameBook);
							}
							break;
						}
					}
				}

				System.out.println("END");

			} else {
				String action = line.substring(0, line.indexOf('"')).trim();
				String auxNameBook = line.substring(line.indexOf("\""), line.length()).trim();
				if (action.equals("BORROW")) {
					for (int i = 0; i < auxSheving.size(); i++) {
						if (auxSheving.get(i).nameBook.equals(auxNameBook)) {

							auxSheving.remove(auxSheving.get(i));
							break;
						}
					}
				} else {
					book auxBook = findBook(auxNameBook);
					mesa.add(auxBook);

				}

			}

		}

	}
}
