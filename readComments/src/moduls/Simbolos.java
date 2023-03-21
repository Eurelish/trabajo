package moduls;

public class Simbolos extends Token {
    public final String lexema;
    public Simbolos(int j, String s) {
        super(j); lexema = new String(s);
    }
    public String getLexema() {
        String cadena="";
        if(lexema.equals("-")) cadena="Etiqueta.RESTA";
        else if (lexema.equals("+")) cadena="Etiqueta.SUMA";
        else if (lexema.equals("*")) cadena="Etiqueta.MULTIPLICACION";
        else if (lexema.equals("/")) cadena="Etiqueta.DIVICION";
        else if (lexema.equals("<")) cadena="Etiqueta.MENORQUE";
        else if (lexema.equals(">")) cadena="Etiqueta.MAYORQUE";
        else if (lexema.equals("<=")) cadena="Etiqueta.MENORIGUALQUE";
        else if (lexema.equals(">=")) cadena="Etiqueta.MAYORIGUALQUE";
        else if (lexema.equals("=")) cadena="Etiqueta.IGUAL";
        else if (lexema.equals("==")) cadena="Etiqueta.COMPARACION";
        return "("+cadena+" , "+lexema+")";
    }
}
