   //importaciones o codigo js
%}

// ---------------- Analizador Lexico ----------------

//directiva lex para poder realizar analisis lexico
%lex
// no hacer distincion entre mayusculas y minusculas
%options case-insensitive

%%
//empezamos analizador

//palabras reservadas
"evaluar"       return 'TKEVALUAR';
"imprimir"      return 'TKIMPRIMIR';

//simbolos del sistema
"{"                     return 'LLAVE1';
"}"                     return 'LLAVE2';
";"                     return 'FINCADENA';
"+"                     return 'MAS';
"-"                     return 'MENOS';
"*"                     return 'MULT';
"/"                     return 'DIV';
"("                     return 'PAR1';
")"                     return 'PAR2';
[0-9]+"."[0-9]+         return 'DECIMAL';
[0-9]+                  return 'ENTERO';
[\"]([^\"\n])*[\"]      {
                            yytext = yytext.substr(1,yyleng-2);
                            return 'CADENA'
                        }

//espacios en blanco
[\ \r\t\f\t]            {};
[\ \n]                  {};

//fin de cadena
<<EOF>>                 return 'EOF'


%{
    // CODIGO JS SI FUESE NECESARIO
%}

//directiva lex pero para sintactico

/lex

//precedencias
%left 'MAS' 'MENOS'
%left 'MULT' 'DIV'
%right 'UMENOS'

//simbolo inicial

%start INICIO

%%

INICIO : INSTRUCCIONES EOF
;

INSTRUCCIONES : INSTRUCCIONES INSTRUCCION
              | INSTRUCCION
;

INSTRUCCION : EVALUAR
            | IMPRESION
;

EVALUAR : TKEVALUAR LLAVE1 EXPRESION LLAVE2 FINCADENA   {console.log($3);}
;

IMPRESION : TKIMPRIMIR LLAVE1 CADENA LLAVE2 FINCADENA   {console.log($3);}
;

EXPRESION : MENOS EXPRESION %prec UMENOS{   $$ = $2 * -1;          }
          | EXPRESION MAS EXPRESION     {   $$ = $1 + $3;          }
          | EXPRESION MENOS EXPRESION   {   $$ = $1 - $3;          }
          | EXPRESION MULT EXPRESION    {   $$ = $1 * $3;          }
          | EXPRESION DIV EXPRESION     {   $$ = $1 / $3;          }
          | PAR1 EXPRESION PAR2         {   $$ = $2;               }
          | ENTERO                      {   $$ = parseFloat($1);   }
          | DECIMAL                     {   $$ = parseFloat($1);   }
;