package FunktionaleProgrammierung;

import FunktionaleProgrammierung.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hilfsklasse {

	public static ArrayList<String> readTXT(File f) {

		ArrayList<String> al = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			/* Ich mag meinen Dozenten, der ist toll */
			while ((s = br.readLine()) != null) {
				al.add(s);
			}
			br.close();
		} catch (IOException e) {

		}
		return al;
	}

	
	/*
	 * Befehl zum Aufrufen:
	 * ArrayList<String> daten = readTXT(new File("Personensatz.txt"));
	 * 
	 * Bitte darauf achten, dass die Personensatz-Datei im richtigen Verzeichnis
	 * (Projektverzeichnis) liegt
	 */

	public static Person ausString(String s) {
		String[] parts = s.split(";");
		// Teile 0 = Nr. Ã¼berspringen wir
		String anrede = parts[1];
		String vorname = parts[2];
		String name = parts[3];
		String stadt = parts[4];
		Integer alter = Integer.valueOf(parts[5]);
		String bundesland = parts[6];
		return new Person(anrede, vorname, name, stadt, alter, bundesland);
	}

}