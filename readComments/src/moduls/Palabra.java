package moduls;

public class Palabra extends Token {
    public final String lexema;
    public Palabra(int t, String s) {
        super(t); lexema = new String(s);
    }
    public String getLexema() {
        String cadena="";
        if(lexema.equals("true")) cadena="Etiqueta.TRUE";
        else if (lexema.equals("false")) cadena="Etiqueta.FALSE";
        else cadena="Etiqueta.ID";
        return "("+cadena+" , "+lexema+")";
    }
}
