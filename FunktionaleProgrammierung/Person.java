package FunktionaleProgrammierung;

public class Person {

	public String anrede;
	public String vorname, name;
	public String stadt;
	public Integer alter;
	public String bundesland;

	public Person(String an, String v, String n, String s, Integer a, String b) {
		vorname = v;
		name = n;
		anrede = an;
		alter = a;
		stadt = s;
		bundesland = b;
	}

	public String toString() {
		if (anrede.equals("k.A."))
			return vorname + " " + name + " " + alter + " " + stadt + " " + bundesland;
		return anrede + " " + vorname + " " + name + " " + alter + " " + stadt + " " + bundesland;
	}
}