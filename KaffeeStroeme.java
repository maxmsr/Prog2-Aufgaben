
// Ben�tigte Bibliothek
import java.io.*;
import Prog1tools.IOTools;

public class KaffeeStroeme {
	
	static void zeichenStrom (File s, File z) {
		try {
			// Auslese-Variable definieren
			FileReader fr = new FileReader( s );
			// Schreib-Variable definieren
			FileWriter fw = new FileWriter( z );
			
			while (true) {
				// Auslesen des chat aus Startdatei
				int c = fr.read();
				
				System.out.print(c);
				
				// Das Zeichen, dass der LeseStrom fertig ist
				if (c == -1)
					break;
				
				// Schreiben des char als int in Datei
				fw.write(c);
				
			}
			
			fr.close();
			fw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void zeilenStrom (File l, File s) {
		
		try {
			// Auslesevariable definieren
			FileReader fr = new FileReader ( l );
			BufferedReader br = new BufferedReader ( fr ) ;
			
			// Schreibvariable definieren
			BufferedWriter bw = new BufferedWriter( new FileWriter (s) );
			
			while (true) {
				// Auslesen der Zeilen aus Datei
				String str = br.readLine();
				
				System.out.println(str);
				
				if (str == null)
					break;
				
				// Schreiben eines Strings in Datei
				bw.write(str);
				// Zeilenumbruch am Ende einf�gen
				bw.newLine();
				
			}
			// Str�me schlie�en weil flei�ig
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void zeilenStrom2 (File l, File s) {
		
		try {
			// Auslesevariable definieren
			FileReader fr = new FileReader ( l );
			BufferedReader br = new BufferedReader ( fr ) ;
			
			// Schreibvariable definieren
			PrintWriter pw = new PrintWriter(s);
					
			while (true) {
				// Auslesen der Zeilen aus Datei
				String str = br.readLine();
				
				System.out.println(str);
				
				if (str == null)
					break;
				
				// Schreiben eines Strings in Datei inklusive Zeilenumbruch
				pw.println(str);
				
			}
			// Str�me schlie�en weil flei�ig
			br.close();
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void streamTokenizer (File l, File s) {
		try {
			// Auslesevariable definieren
			StreamTokenizer st = new StreamTokenizer (new FileReader (l) );
			// Auslesevariable einstellen, dass Zeilenumbr�che erkannt werden
			st.eolIsSignificant(true);
			
			// Schreibvariable
			PrintWriter pw = new PrintWriter (s);
			
			while (true) {
				// Nehme n�chste Zeichenkette
				int i = st.nextToken();
				
				// Teste ob Ende der Datei
				if (i == StreamTokenizer.TT_EOF) {
					System.out.println("Ende");
					break;
				}
				
				// Teste Zeichenkette eine Nummer ist
				else if (i == StreamTokenizer.TT_NUMBER) {
					System.out.println("Zahl: " + st.nval);
					pw.print(Double.toString(st.nval));
				}
				
				// Teste Zeichenkette ein String ist
				else if( i == StreamTokenizer.TT_WORD) {
					System.out.println("Wort: " + st.sval);
					pw.print(st.sval);
				}
				
				// Teste ob gerade ein Zeilenumbruch ist
				else if ( i == StreamTokenizer.TT_EOL) {
					System.out.println("Zeilenumbruch");
					pw.println();
				}
				
			}
			// Str�me schlie�en
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	static void dateiStrom (File f) {
		
		try {
			// Schreibvariable definieren
			DataOutputStream dos = new DataOutputStream( new FileOutputStream ( f ) );
			// Schreiben in Datei
			dos.writeInt( IOTools.readInt("Integerzahl: "));
			dos.writeDouble( IOTools.readDouble("Doublezahl: "));
			dos.writeBoolean(true);
			// Datei/Strom schlie�en
			dos.close();
			
			// Lesevariable definieren
			DataInputStream dis = new DataInputStream( new FileInputStream ( f ) );
			// Lesen aus Datei
			System.out.println( dis.readInt() );
			System.out.println( dis.readDouble() );
			System.out.println( dis.readBoolean() );
			// Datei/Strom schlie�en
			dis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// implements Serializable erwirkt Serialisieren (dass man es abspeichern kann)
	static class Person implements Serializable {
		String name;
		public Person () {
			name = IOTools.readLine("Name: ");
		}
	}
	
	static void objektStrom ( File f ) {
		try {
			// Speichervariable definieren
			ObjectOutputStream oos = new ObjectOutputStream ( new FileOutputStream ( f ) );
			
			// Schreiben in Datei
			oos.writeObject( new Person() );
			
			// Datei/Strom schlie�en
			oos.close();
			
			// Lesevariable definieren
			ObjectInputStream ois = new ObjectInputStream ( new FileInputStream ( f ) );
			
			// Lesen von Datei (Typecast n�tig)
			Person p = (Person) ois.readObject();
			
			System.out.println( p.name );
			
			// Datei / Strom schlie�en
			ois.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		// Die nachfolgende Exception ist notwendig, bei ObjectInputStreams
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// Entweder in try/catch || throws IOException
	public static void main(String[] args) 
			throws IOException{
		
		// Dateiverkn�pfung (Pfade m�glich mit Klasse PATH)
		File s = new File ("start.txt");
		File z = new File ("ziel.txt");
		File f = new File ("file.dat");
		
		if (s.exists()==false)
			s.createNewFile();
		
		if (!z.exists())
			z.createNewFile();
		
		if (!f.exists())
			f.createNewFile();
		
		KaffeeStroeme.streamTokenizer(s,z);
	}

}
