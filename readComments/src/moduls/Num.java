package moduls;


public class Num extends Token {
    public final int valor;
    public Num(int v) {
        super(Etiqueta.NUM);
        valor = v;
    }

    public String getCadena() {
        return "(Etiqueta.NUM , "+valor+")";
    }
}