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
%debug //para tener salida en la consola
%ignorecase //quitar distincion entre mayusculas y minusculas


// simbolos del sistema
LLAVE1 ="{"
LLAVE2 = "}"
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"
MAS = "+"
MENOS = "-"
IGUAL = "="
MENOR = "<"
EQUALS = "=="
BLANCOS = [\ \r\t\f\n]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = [\"]((\\\")|[^\"\n]*)[\"]
ID = [a-zA-Z][a-zA-Z0-9_]*

//palabras reservadas
IMPRIMIR = "imprimir"
INT = "int"
DOUBLE = "double"
STRING = "string"
TRUE = "true"
FALSE = "false"
IF = "if"
BOOL = "boolean"
FOR = "for"

%%
<YYINITIAL> {IMPRIMIR} {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}
<YYINITIAL> {INT} {return new Symbol(sym.INT, yyline, yycolumn, yytext());}
<YYINITIAL> {DOUBLE} {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
<YYINITIAL> {STRING} {return new Symbol(sym.STRING, yyline, yycolumn, yytext());}
<YYINITIAL> {TRUE} {return new Symbol(sym.TRUE, yyline, yycolumn, yytext());}
<YYINITIAL> {FALSE} {return new Symbol(sym.FALSE, yyline, yycolumn, yytext());}
<YYINITIAL> {IF} {return new Symbol(sym.IF, yyline, yycolumn, yytext());}
<YYINITIAL> {BOOL} {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());}
<YYINITIAL> {FOR} {return new Symbol(sym.FOR, yyline, yycolumn, yytext());}
<YYINITIAL> {ID} {return new Symbol(sym.ID, yyline, yycolumn, yytext());}
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
<YYINITIAL> {LLAVE1} {return new Symbol(sym.LLAVE1, yyline, yycolumn, yytext());}
<YYINITIAL> {LLAVE2} {return new Symbol(sym.LLAVE2, yyline, yycolumn, yytext());}
<YYINITIAL> {MENOR} {return new Symbol(sym.MENOR, yyline, yycolumn, yytext());}

<YYINITIAL> . {erroresLexicos.add(new Errores("LEXICO",
                "El caracter " +yytext()+" no pertenece al lenguaje",
                yyline, yycolumn));}