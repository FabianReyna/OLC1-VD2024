
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
import instrucciones.If;
import instrucciones.For;
import expresiones.Nativo;
import expresiones.Suma;
import expresiones.Resta;
import expresiones.NegacionUnaria;
import expresiones.Equals;
import expresiones.AccesoVar;
import expresiones.Menor;
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
    "\000\040\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\004\003\000\002\004\003\000" +
    "\002\004\004\000\002\005\006\000\002\006\006\000\002" +
    "\007\005\000\002\010\011\000\002\011\015\000\002\012" +
    "\003\000\002\014\003\000\002\014\003\000\002\014\003" +
    "\000\002\014\003\000\002\013\004\000\002\013\005\000" +
    "\002\013\005\000\002\013\005\000\002\013\005\000\002" +
    "\013\003\000\002\013\003\000\002\013\003\000\002\013" +
    "\003\000\002\013\003\000\002\013\003\000\002\013\005" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\024\003\017\007\014\011\012\024\023\025" +
    "\006\026\025\027\015\032\013\033\020\001\002\000\030" +
    "\002\ufffe\003\ufffe\007\ufffe\011\ufffe\022\ufffe\024\ufffe\025" +
    "\ufffe\026\ufffe\027\ufffe\032\ufffe\033\ufffe\001\002\000\004" +
    "\007\105\001\002\000\004\007\ufff1\001\002\000\004\010" +
    "\104\001\002\000\026\002\000\003\017\007\014\011\012" +
    "\024\023\025\006\026\025\027\015\032\013\033\020\001" +
    "\002\000\030\002\ufffa\003\ufffa\007\ufffa\011\ufffa\022\ufffa" +
    "\024\ufffa\025\ufffa\026\ufffa\027\ufffa\032\ufffa\033\ufffa\001" +
    "\002\000\004\012\101\001\002\000\004\012\073\001\002" +
    "\000\004\017\071\001\002\000\004\007\uffef\001\002\000" +
    "\004\010\070\001\002\000\004\010\067\001\002\000\004" +
    "\007\uffee\001\002\000\030\002\ufff9\003\ufff9\007\ufff9\011" +
    "\ufff9\022\ufff9\024\ufff9\025\ufff9\026\ufff9\027\ufff9\032\ufff9" +
    "\033\ufff9\001\002\000\004\010\066\001\002\000\004\012" +
    "\027\001\002\000\004\002\026\001\002\000\004\007\ufff0" +
    "\001\002\000\004\002\001\001\002\000\004\007\014\001" +
    "\002\000\004\010\031\001\002\000\022\004\032\005\035" +
    "\006\033\007\041\012\037\015\034\030\036\031\040\001" +
    "\002\000\016\010\uffe7\013\uffe7\014\uffe7\015\uffe7\020\uffe7" +
    "\023\uffe7\001\002\000\016\010\uffe6\013\uffe6\014\uffe6\015" +
    "\uffe6\020\uffe6\023\uffe6\001\002\000\022\004\032\005\035" +
    "\006\033\007\041\012\037\015\034\030\036\031\040\001" +
    "\002\000\016\010\uffe8\013\uffe8\014\uffe8\015\uffe8\020\uffe8" +
    "\023\uffe8\001\002\000\016\010\uffe5\013\uffe5\014\uffe5\015" +
    "\uffe5\020\uffe5\023\uffe5\001\002\000\022\004\032\005\035" +
    "\006\033\007\041\012\037\015\034\030\036\031\040\001" +
    "\002\000\016\010\uffe4\013\uffe4\014\uffe4\015\uffe4\020\uffe4" +
    "\023\uffe4\001\002\000\016\010\uffe3\013\uffe3\014\uffe3\015" +
    "\uffe3\020\uffe3\023\uffe3\001\002\000\014\010\043\014\044" +
    "\015\046\020\045\023\047\001\002\000\004\007\014\001" +
    "\002\000\022\004\032\005\035\006\033\007\041\012\037" +
    "\015\034\030\036\031\040\001\002\000\022\004\032\005" +
    "\035\006\033\007\041\012\037\015\034\030\036\031\040" +
    "\001\002\000\022\004\032\005\035\006\033\007\041\012" +
    "\037\015\034\030\036\031\040\001\002\000\022\004\032" +
    "\005\035\006\033\007\041\012\037\015\034\030\036\031" +
    "\040\001\002\000\016\010\uffe9\013\uffe9\014\044\015\046" +
    "\020\uffe9\023\uffe9\001\002\000\016\010\uffeb\013\uffeb\014" +
    "\uffeb\015\uffeb\020\uffeb\023\uffeb\001\002\000\016\010\uffea" +
    "\013\uffea\014\044\015\046\020\uffea\023\uffea\001\002\000" +
    "\016\010\uffec\013\uffec\014\uffec\015\uffec\020\uffec\023\uffec" +
    "\001\002\000\004\013\ufff2\001\002\000\004\013\056\001" +
    "\002\000\004\021\057\001\002\000\024\003\017\007\014" +
    "\011\012\024\023\025\006\026\025\027\015\032\013\033" +
    "\020\001\002\000\026\003\017\007\014\011\012\022\062" +
    "\024\023\025\006\026\025\027\015\032\013\033\020\001" +
    "\002\000\030\002\uffff\003\uffff\007\uffff\011\uffff\022\uffff" +
    "\024\uffff\025\uffff\026\uffff\027\uffff\032\uffff\033\uffff\001" +
    "\002\000\030\002\ufff3\003\ufff3\007\ufff3\011\ufff3\022\ufff3" +
    "\024\ufff3\025\ufff3\026\ufff3\027\ufff3\032\ufff3\033\ufff3\001" +
    "\002\000\014\013\064\014\044\015\046\020\045\023\047" +
    "\001\002\000\016\010\uffe2\013\uffe2\014\uffe2\015\uffe2\020" +
    "\uffe2\023\uffe2\001\002\000\016\010\uffed\013\uffed\014\uffed" +
    "\015\uffed\020\uffed\023\uffed\001\002\000\030\002\ufffd\003" +
    "\ufffd\007\ufffd\011\ufffd\022\ufffd\024\ufffd\025\ufffd\026\ufffd" +
    "\027\ufffd\032\ufffd\033\ufffd\001\002\000\030\002\ufff8\003" +
    "\ufff8\007\ufff8\011\ufff8\022\ufff8\024\ufff8\025\ufff8\026\ufff8" +
    "\027\ufff8\032\ufff8\033\ufff8\001\002\000\030\002\ufffb\003" +
    "\ufffb\007\ufffb\011\ufffb\022\ufffb\024\ufffb\025\ufffb\026\ufffb" +
    "\027\ufffb\032\ufffb\033\ufffb\001\002\000\022\004\032\005" +
    "\035\006\033\007\041\012\037\015\034\030\036\031\040" +
    "\001\002\000\016\010\ufff5\013\ufff5\014\044\015\046\020" +
    "\045\023\047\001\002\000\022\004\032\005\035\006\033" +
    "\007\041\012\037\015\034\030\036\031\040\001\002\000" +
    "\014\013\075\014\044\015\046\020\045\023\047\001\002" +
    "\000\004\021\076\001\002\000\024\003\017\007\014\011" +
    "\012\024\023\025\006\026\025\027\015\032\013\033\020" +
    "\001\002\000\026\003\017\007\014\011\012\022\100\024" +
    "\023\025\006\026\025\027\015\032\013\033\020\001\002" +
    "\000\030\002\ufff4\003\ufff4\007\ufff4\011\ufff4\022\ufff4\024" +
    "\ufff4\025\ufff4\026\ufff4\027\ufff4\032\ufff4\033\ufff4\001\002" +
    "\000\022\004\032\005\035\006\033\007\041\012\037\015" +
    "\034\030\036\031\040\001\002\000\014\013\103\014\044" +
    "\015\046\020\045\023\047\001\002\000\004\010\ufff7\001" +
    "\002\000\030\002\ufffc\003\ufffc\007\ufffc\011\ufffc\022\ufffc" +
    "\024\ufffc\025\ufffc\026\ufffc\027\ufffc\032\ufffc\033\ufffc\001" +
    "\002\000\004\017\106\001\002\000\022\004\032\005\035" +
    "\006\033\007\041\012\037\015\034\030\036\031\040\001" +
    "\002\000\014\010\ufff6\014\044\015\046\020\045\023\047" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\024\002\023\003\007\004\003\005\021\006" +
    "\006\007\015\010\010\011\020\014\004\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\020\004\060\005\021\006\006\007\015\010\010" +
    "\011\020\014\004\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\007" +
    "\027\001\001\000\002\001\001\000\004\013\041\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\013\064\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\013\062" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\007\053\012\054\001\001\000\004\013\052" +
    "\001\001\000\004\013\051\001\001\000\004\013\050\001" +
    "\001\000\004\013\047\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\022\003\057" +
    "\004\003\005\021\006\006\007\015\010\010\011\020\014" +
    "\004\001\001\000\020\004\060\005\021\006\006\007\015" +
    "\010\010\011\020\014\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\013\071\001\001\000\002\001\001\000\004" +
    "\013\073\001\001\000\002\001\001\000\002\001\001\000" +
    "\022\003\076\004\003\005\021\006\006\007\015\010\010" +
    "\011\020\014\004\001\001\000\020\004\060\005\021\006" +
    "\006\007\015\010\010\011\020\014\004\001\001\000\002" +
    "\001\001\000\004\013\101\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\013\106\001\001\000\002\001\001" });

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
          case 7: // INSTRUCCION ::= SIF 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // INSTRUCCION ::= CFOR 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // INSTRUCCION ::= error FINCADENA 
            {
              Instruccion RESULT =null;
		 RESULT = null; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // IMPRESION ::= IMPRIMIR PAR1 EXPRESION PAR2 
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
          case 11: // DECLARACION ::= TIPOS ID IGUAL EXPRESION 
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
          case 12: // ASIGNACION ::= ID IGUAL EXPRESION 
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
          case 13: // SIF ::= IF PAR1 EXPRESION PAR2 LLAVE1 INSTRUCCIONES LLAVE2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> b = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new If(a, b, aleft, aright ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SIF",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // CFOR ::= FOR PAR1 ASIGNACION FINCADENA EXPRESION FINCADENA ACTUALIZA_FOR PAR2 LLAVE1 INSTRUCCIONES LLAVE2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Instruccion c = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> d = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new For(a, b, c, d, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("CFOR",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ACTUALIZA_FOR ::= ASIGNACION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ACTUALIZA_FOR",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // TIPOS ::= INT 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.ENTERO); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // TIPOS ::= DOUBLE 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.DECIMAL); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // TIPOS ::= STRING 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.CADENA); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // TIPOS ::= BOOL 
            {
              Tipo RESULT =null;
		 RESULT = new Tipo(tipoDato.BOOLEANO); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPOS",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPRESION ::= MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new NegacionUnaria(a, aleft, aright);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPRESION ::= EXPRESION MAS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Suma(a, b, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXPRESION ::= EXPRESION MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Resta(a, b, aleft, aright);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXPRESION ::= EXPRESION EQUALS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Equals(a, b, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXPRESION ::= EXPRESION MENOR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Menor(a, b, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXPRESION ::= ENTERO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(Integer.parseInt(a),new Tipo(tipoDato.ENTERO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXPRESION ::= CADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(a,new Tipo(tipoDato.CADENA), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // EXPRESION ::= DECIMAL 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(new Double(a),new Tipo(tipoDato.DECIMAL), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // EXPRESION ::= TRUE 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(true,new Tipo(tipoDato.BOOLEANO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // EXPRESION ::= FALSE 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nativo(false,new Tipo(tipoDato.BOOLEANO), aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // EXPRESION ::= ID 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new AccesoVar(a, aleft, aright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // EXPRESION ::= PAR1 EXPRESION PAR2 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = a; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
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