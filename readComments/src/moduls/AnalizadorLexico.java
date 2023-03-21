package moduls;

import java.io.*; import java.util.*;
public class AnalizadorLexico {
    public int linea = 1;
    private char vistazo = ' ';
    private Hashtable palabras = new Hashtable();  

    void reservar(Palabra t) { palabras.put(t.lexema, t); }
    void reservar(Simbolos j) { palabras.put(j.lexema, j); }
    void reservar(leerComentarios j) { palabras.put(j.lexema, j); }
    public AnalizadorLexico() {
        reservar( new Palabra(Etiqueta.TRUE, "true") );
        reservar( new Palabra(Etiqueta.FALSE, "false") );
        reservar( new Simbolos(Etiqueta.SUMA, "+") );
        reservar( new Simbolos(Etiqueta.RESTA, "-") );
        reservar( new Simbolos(Etiqueta.DIVICION, "/") );
        reservar( new Simbolos(Etiqueta.MULTIPLICACION, "*") );
        reservar( new Simbolos(Etiqueta.MENORQUE, "<") );
        reservar( new Simbolos(Etiqueta.MAYORQUE, ">") );
        reservar( new Simbolos(Etiqueta.MENORIGUALQUE, "<=") );
        reservar( new Simbolos(Etiqueta.MAYORIGUALQUE, ">=") );
        reservar( new Simbolos(Etiqueta.IGUAL, "=") );
        reservar( new Simbolos(Etiqueta.COMPARACION, "==") );  
        reservar( new leerComentarios(Etiqueta.DOCUMENTACION, "//") );
        reservar( new leerComentarios(Etiqueta.DOCUMENTACION, "/*") );  
    }

    public Token explorar() throws IOException {
        for( ; ; vistazo = (char)System.in.read() ) {
            if( vistazo == ' ' || vistazo == '\t' ) continue;
            else if( vistazo == '\n' ) linea = linea + 1;
            else break;
        }
        if( Character.isDigit(vistazo) ) {
            int v = 0;
            do {
                v = 10*v + Character.digit(vistazo, 10);
                vistazo = (char)System.in.read();
            } while( Character.isDigit(vistazo) );
            Num valor = new Num(v);
            System.out.println(valor.getCadena());
            return valor ;
        }
        if( Character.isLetter(vistazo) ) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(vistazo);
                vistazo = (char)System.in.read();
            } while( Character.isLetterOrDigit(vistazo) );
            String s = b.toString();
            var w = (Palabra)palabras.get(s);
            if (w != null ) {
                System.out.println(w.getLexema());
                return w;
            }
            w = new Palabra(Etiqueta.ID, s);
            palabras.put(s,w);
            System.out.println(w.getLexema());
            return w;
        }
        if(Character.isLetterOrDigit(vistazo)==false){

            StringBuffer b = new StringBuffer();
            do {

                b.append(vistazo);
                vistazo = (char)System.in.read();  

            } while(  vistazo != '\r'  );

            int i;
			
            if (b.length()> 1){

                for( i=0; i<b.length();i++){
					
                    for (int k=1; k<=b.length(); k++){
                        
                        if (b.charAt(i)=='/' & (b.charAt(k)=='/' || b.charAt(k)=='*')){
                            String s = String.valueOf(b.charAt(i)) + String.valueOf(b.charAt(k));
                            var w = (leerComentarios)palabras.get(s);
                                if (w != null ) {
                                    System.out.println(w.getLexema());
                                    return w;
                                }
                            w = new leerComentarios(Etiqueta.ID, s);
                            palabras.put(s,w);
                            System.out.println(w.getLexema());
                            return w;

                        } else if ((b.charAt(i)=='<' || b.charAt(i)=='>' || b.charAt(i)=='=') & (b.charAt(k)=='=')){    

                            String s = String.valueOf(b.charAt(i)) + String.valueOf(b.charAt(k));
                            var w = (Simbolos)palabras.get(s);

                                if (w != null ) {
                                    System.out.println(w.getLexema());
                                    return w;
                                }

                            w = new Simbolos(Etiqueta.ID, s);
                            palabras.put(s,w);
                            System.out.println(w.getLexema());
                            return w;
                        }else if ((b.charAt(i)=='+'|| b.charAt(i)=='-'|| b.charAt(i)=='*'|| b.charAt(i)=='/' || b.charAt(i)=='<' || b.charAt(i)=='>' || b.charAt(i)=='=')
                        & b.charAt(k) != '=') {

                        String s = String.valueOf(b.charAt(i));
                        var w = (Simbolos)palabras.get(s);

                            if (w != null ) {
                                System.out.println(w.getLexema());
                                return w;
                            }

                        w = new Simbolos(Etiqueta.ID, s);
                        palabras.put(s,w);
                        System.out.println(w.getLexema());
                        return w; 

                        }
                    }
                }
                
            
            }  else  {  

                    for( i=0; i<b.length();i++){
                        
                        if (b.charAt(i)=='+'|| b.charAt(i)=='-'|| b.charAt(i)=='*'|| b.charAt(i)=='/' || b.charAt(i)=='<' || b.charAt(i)=='>' || b.charAt(i)=='=') {
                                String s = String.valueOf(b.charAt(i));
                            var w = (Simbolos)palabras.get(s);
                            if (w != null ) {
                                System.out.println(w.getLexema());
                                return w;
                            }
                            w = new Simbolos(Etiqueta.ID, s);
                            palabras.put(s,w);
                            System.out.println(w.getLexema());
                            return w;
                        }

                    }
                    
				}
                
	    }
            
          

        
    Token t = new Token(vistazo);
    System.out.println(t.getEtiqueta());
    vistazo = ' ';
    return t;
    }

    public Hashtable getPalabras(){


        return palabras;
    }
}
