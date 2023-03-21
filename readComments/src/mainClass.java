import moduls.AnalizadorLexico;
import moduls.Token;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
// trabajo presentado por Johan Arrias Alejandro gil y Harol Arboleda
public class mainClass {
    public static void main(String ar[]) throws IOException {
        String salida;
        String lexema;
        AnalizadorLexico aL = new AnalizadorLexico();
        aL.explorar();
        Hashtable palSalida= aL.getPalabras();
        Enumeration elements = palSalida.elements();
        while (elements.hasMoreElements()) {
            System.out.println(""+"hashtable valores: " + ((Token) elements.nextElement()).getEtiqueta());
        }

        Enumeration llaves = palSalida.keys();
        while (llaves.hasMoreElements()) {
            System.out.println(""+"hashtable llaves: " + llaves.nextElement());
        }
    }
}
