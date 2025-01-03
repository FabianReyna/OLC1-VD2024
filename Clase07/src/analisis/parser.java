
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analisis;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import abstracto.Instruccion;
import simbolo.*;
import excepciones.Errores;
import instrucciones.Print;
import instrucciones.Declaracion;
import instrucciones.AsignacionVar;
import expresiones.Nativo;
import expresiones.Suma;
import expresiones.Resta;
import expresiones.NegacionUnaria;
import expresiones.Equals;
import expresiones.AccesoVar;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\004\004\000\002\005\006\000" +
    "\002\006\006\000\002\007\005\000\002\011\003\000\002" +
    "\011\003\000\002\011\003\000\002\010\004\000\002\010" +
    "\005\000\002\010\005\000\002\010\005\000\002\010\003" +
    "\000\002\010\003\000\002\010\003\000\002\010\003\000" +
    "\002\010\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\016\003\016\007\012\011\017\021\005\022" +
    "\011\023\010\001\002\000\020\002\ufffe\003\ufffe\007\ufffe" +
    "\011\ufffe\021\ufffe\022\ufffe\023\ufffe\001\002\000\004\007" +
    "\ufff6\001\002\000\004\010\055\001\002\000\004\002\054" +
    "\001\002\000\004\007\ufff4\001\002\000\004\007\ufff5\001" +
    "\002\000\004\017\052\001\002\000\004\010\051\001\002" +
    "\000\004\010\050\001\002\000\020\002\000\003\016\007" +
    "\012\011\017\021\005\022\011\023\010\001\002\000\004" +
    "\010\046\001\002\000\004\012\043\001\002\000\004\007" +
    "\021\001\002\000\004\017\022\001\002\000\016\004\030" +
    "\005\027\006\026\007\023\012\031\015\024\001\002\000" +
    "\014\010\uffec\013\uffec\014\uffec\015\uffec\020\uffec\001\002" +
    "\000\016\004\030\005\027\006\026\007\023\012\031\015" +
    "\024\001\002\000\012\010\ufff8\014\033\015\035\020\034" +
    "\001\002\000\014\010\uffed\013\uffed\014\uffed\015\uffed\020" +
    "\uffed\001\002\000\014\010\uffef\013\uffef\014\uffef\015\uffef" +
    "\020\uffef\001\002\000\014\010\uffee\013\uffee\014\uffee\015" +
    "\uffee\020\uffee\001\002\000\016\004\030\005\027\006\026" +
    "\007\023\012\031\015\024\001\002\000\012\013\036\014" +
    "\033\015\035\020\034\001\002\000\016\004\030\005\027" +
    "\006\026\007\023\012\031\015\024\001\002\000\016\004" +
    "\030\005\027\006\026\007\023\012\031\015\024\001\002" +
    "\000\016\004\030\005\027\006\026\007\023\012\031\015" +
    "\024\001\002\000\014\010\uffeb\013\uffeb\014\uffeb\015\uffeb" +
    "\020\uffeb\001\002\000\014\010\ufff1\013\ufff1\014\ufff1\015" +
    "\ufff1\020\ufff1\001\002\000\014\010\ufff0\013\ufff0\014\033" +
    "\015\035\020\ufff0\001\002\000\014\010\ufff2\013\ufff2\014" +
    "\ufff2\015\ufff2\020\ufff2\001\002\000\014\010\ufff3\013\ufff3" +
    "\014\ufff3\015\ufff3\020\ufff3\001\002\000\016\004\030\005" +
    "\027\006\026\007\023\012\031\015\024\001\002\000\012" +
    "\013\045\014\033\015\035\020\034\001\002\000\004\010" +
    "\ufff9\001\002\000\020\002\ufffa\003\ufffa\007\ufffa\011\ufffa" +
    "\021\ufffa\022\ufffa\023\ufffa\001\002\000\020\002\uffff\003" +
    "\uffff\007\uffff\011\uffff\021\uffff\022\uffff\023\uffff\001\002" +
    "\000\020\002\ufffd\003\ufffd\007\ufffd\011\ufffd\021\ufffd\022" +
    "\ufffd\023\ufffd\001\002\000\020\002\ufffb\003\ufffb\007\ufffb" +
    "\011\ufffb\021\ufffb\022\ufffb\023\ufffb\001\002\000\016\004" +
    "\030\005\027\006\026\007\023\012\031\015\024\001\002" +
    "\000\012\010\ufff7\014\033\015\035\020\034\001\002\000" +
    "\004\002\001\001\002\000\020\002\ufffc\003\ufffc\007\ufffc" +
    "\011\ufffc\021\ufffc\022\ufffc\023\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\020\002\006\003\014\004\003\005\013\006" +
    "\005\007\012\011\017\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\014\004\046\005\013\006\005\007" +
    "\012\011\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\010\024\001" +
    "\001\000\002\001\001\000\004\010\041\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\010\031\001\001\000\002\001\001\000\004" +
    "\010\040\001\001\000\004\010\037\001\001\000\004\010" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\010" +
    "\043\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\010\052\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    scanner s;
    parser(scanner s){this.s = s;}
    
    public LinkedList<Errores> erroresSintacticos = new LinkedList<>();

    public void syntax_error(Symbol s){
        erroresSintacticos.add(new Errores("SINTACTICO RECUPERABLE",
        "No se esperaba el componente "+s.value,
        s.left,
        s.right));
    }

    public void unrecovered_syntax_error (Symbol s){
        erroresSintacticos.add(new Errores("SINTACTICO NO RECUPERABLE",
            "No se esperaba el componente "+s.value,
            s.left,
            s.right));
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {



  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> start_val = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= INSTRUCCIONES 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; RESULT.add(b); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new LinkedList<Instruccion>(); RESULT.add(a); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= IMPRESION FINCADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= DECLARACION FINCADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCCION ::= ASIGNACION FINCADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INSTRUCCION ::= error FINCADENA 
            {
              Instruccion RESULT =null;
		 RESULT = null; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // IMPRESION ::= IMPRIMIR PAR1 EXPRESION PAR2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Print(a, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("IMPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DECLARACION ::= TIPOS ID IGUAL EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Tipo a = (Tipo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion c = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Declaracion(b, c, a, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLARACION",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // ASIGNACION ::= ID IGUAL EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion c = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new AsignacionVar(a, c, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ASIGNACION",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // TIPOS ::= INT 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.ENTERO); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // TIPOS ::= DOUBLE 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.DECIMAL); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // TIPOS ::= STRING 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.CADENA); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESION ::= MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new NegacionUnaria(a, aleft, aright);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPRESION ::= EXPRESION MAS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Suma(a, b, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPRESION ::= EXPRESION MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Resta(a, b, aleft, aright);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPRESION ::= EXPRESION EQUALS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Equals(a, b, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPRESION ::= ENTERO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(Integer.parseInt(a),new Tipo(tipoDato.ENTERO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPRESION ::= CADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(a,new Tipo(tipoDato.CADENA), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPRESION ::= DECIMAL 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(new Double(a),new Tipo(tipoDato.DECIMAL), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPRESION ::= ID 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new AccesoVar(a, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXPRESION ::= PAR1 EXPRESION PAR2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
