package Übungsblatt7;

import Prog1tools.IOTools;

import javax.print.attribute.standard.Finishings;
import java.io.*;

public class Aufgabe23 {

    public Aufgabe23(File R, File OZ, File OT) throws IOException {
        try {
            if (!OZ.exists()) {
                OZ.createNewFile();
            }
            if (!OT.exists()) {
                OT.createNewFile();
            }

            StreamTokenizer st = new StreamTokenizer(new FileReader(R));
            st.eolIsSignificant(true);

            PrintWriter oz = new PrintWriter (OZ);
            PrintWriter ot = new PrintWriter (OT);

            while (true) {
                int i = st.nextToken();

                if (i == StreamTokenizer.TT_EOF) {
                    System.out.println("Ende");
                    break;
                } else if (i == StreamTokenizer.TT_NUMBER) {
                    oz.print(Double.toString(st.nval));
                } else if( i == StreamTokenizer.TT_WORD) {
                    System.out.println("Wort: " + st.sval);
                    ot.print(st.sval);
                } else if ( i == StreamTokenizer.TT_EOL) {
                    System.out.println("Zeilenumbruch");
                    ot.println();
                    oz.println();
                }
            }
            oz.close();
            ot.close();


        } catch (IOException e){
            System.out.println("No file found");
        }
    }

    public static void main(String[] args) throws IOException {
        File R = new File(IOTools.readLine("File to Read from: "));
        File OZ = new File(IOTools.readLine("File to Write Numbers: "));
        File OT = new File(IOTools.readLine("File to Write Text: "));

        Aufgabe23 aufgabe23 = new Aufgabe23(R, OZ, OT);
    }
}
