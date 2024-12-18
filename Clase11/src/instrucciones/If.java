/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author fabian
 */
// IF ( EXP ) { INSTRUCCIONES }
public class If extends Instruccion {

    private Instruccion condicion;
    private LinkedList<Instruccion> instrucciones;


    public If(Instruccion condicion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores) {
            return cond;
        }

        // la condicion debe de ser booleano
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO",
                    "La expresion del IF debe ser de tipo booleano",
                    this.linea,
                    this.col);
        }

        // tenemos un bloque, entonces tenemos que crear un nuevo entorno
        var nuevaTabla = new tablaSimbolos(tabla);

        if ((boolean) cond) {
            // ejecutar las instrucciones
            for (var i : this.instrucciones) {
                var resultado = i.interpretar(arbol, nuevaTabla);
                if(resultado instanceof Errores){
                    arbol.AddErrores((Errores) resultado);
                }
            }
        }
        return null;

    }

}
/*
imprimir("Ejemplo de bloques");
imprimir("Hola"-10);
int a = 10;
int b = 20;
imprimir(a);
imprimir(a+b);
*/