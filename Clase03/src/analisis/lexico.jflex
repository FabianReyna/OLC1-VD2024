package analisis;

// importaciones
import java_cup.runtime.Symbol;

%%

// codigo de usuario, si es necesario
%{
    String cadena = "";
%}

%init{
    yyline = 1;
    yycolumn = 1;
%init}

// declaracion de caractisticas de JFLEX
%cup // vamos a usar cup para la parte sintactica
%class scanner // nombre de la clase del compilado
%public // tipo de clase
%line // conteo de lineas
%char // conteo de caracteres
%column // conteo de columnas
%full // reconocimiento de caracteres
//%debug // imprime en consola que reconoce
%ignorecase //quitar la distincion entre mayusculas y minusculas

// creacion de estados (si es necesario)
%state CADENA

// simbolos del sistema
PAR1 = "("
PAR2 = ")"
FINCADENA = ";"
MAS = "+"
MENOS = "-"
MULT = "*"
DIV = "/"
BLANCOS = [\ \r\t\f\n]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+

// Palabras reservadas
IMPRIMIR = "imprimir"

%%
// primero se ponen las reservadas <NOMBRE_TOKEN, LEXEMA>
<YYINITIAL> {IMPRIMIR}  {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());}

<YYINITIAL> {DECIMAL}  {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}
<YYINITIAL> {ENTERO}  {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}

//SIMBOLOS
<YYINITIAL> {FINCADENA}  {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}
<YYINITIAL> {MAS}  {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
<YYINITIAL> {MENOS}  {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}
<YYINITIAL> {MULT}  {return new Symbol(sym.MULT, yyline, yycolumn, yytext());}
<YYINITIAL> {DIV}  {return new Symbol(sym.DIV, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR1}  {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());}
<YYINITIAL> {PAR2}  {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());}

<YYINITIAL> {BLANCOS}  {}

// Moverme a estado cadena
<YYINITIAL> [\"]    {yybegin(CADENA); cadena=""; }

<CADENA> {
    [\"]    {String temporal = cadena; cadena = "";
            yybegin(YYINITIAL);
            return new Symbol(sym.CADENA, yyline, yycolumn, temporal);}
    [^\"]   {cadena+=yytext();}
}