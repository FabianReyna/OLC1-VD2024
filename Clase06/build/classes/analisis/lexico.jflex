package analisis;

//importaciones si fuesen necesarias
import java_cup.runtime.Symbol;
import excepciones.Errores;
import java.util.LinkedList;

%%

//codigo de usuario, si fuese necesario
%{
    public LinkedList<Errores> erroresLexicos = new LinkedList<>();
%}


%init{
yyline = 1;
yycolumn = 1;
erroresLexicos = new LinkedList<>();
%init}


// declaracion de caracteristicas propias de jflex
%cup
%class scanner //nombre de la clase
%public //tipo de la clase
%line //conteo de lineas
%char //conteo de caracteres
%column //conteo de columnas
%full //reconocimiento de caracteres
//%debug //para tener salida en la consola
%ignorecase //quitar distincion entre mayusculas y minusculas


// simbolos del sistema
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"
MAS = "+"
MENOS = "-"
IGUAL = "="
EQUALS = "=="
BLANCOS = [\ \r\t\f\n]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = [\"]((\\\")|[^\"\n]*)[\"]

//palabras reservadas
IMPRIMIR = "imprimir"
%%
<YYINITIAL> {IMPRIMIR} {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}
<YYINITIAL> {DECIMAL} {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO} {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}
<YYINITIAL> {CADENA} {String cadena = yytext(); 
                        cadena=cadena.substring(1, cadena.length() - 1);
                        return new Symbol(sym.CADENA, yyline, yycolumn, cadena);}

<YYINITIAL> {FINCADENA} {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR1} {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR2} {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}
<YYINITIAL> {BLANCOS} {}
<YYINITIAL> {MAS} {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
<YYINITIAL> {MENOS} {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}
<YYINITIAL> {EQUALS} {return new Symbol(sym.EQUALS, yyline, yycolumn, yytext());}
<YYINITIAL> {IGUAL} {return new Symbol(sym.IGUAL, yyline, yycolumn, yytext());}

<YYINITIAL> . {erroresLexicos.add(new Errores("LEXICO",
                "El caracter " +yytext()+" no pertenece al lenguaje",
                yyline, yycolumn));}

