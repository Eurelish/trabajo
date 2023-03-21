package moduls;

public class leerComentarios extends Token {
    public final String lexema;
    public leerComentarios(int j, String s) {
        super(j); lexema = new String(s);
    }
    public String getLexema() {
        String cadena="";
        if(lexema.equals("//")) cadena="Etiqueta.DOCUMENTACION";
        else if (lexema.equals("/*")) cadena="Etiqueta.DOCUMENTACION";      
        return "("+cadena+" , "+lexema+")";
    }
}
