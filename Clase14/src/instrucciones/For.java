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
// for ( asignacion; condicion; actualizacion){INSTRUCCIONES}
public class For extends Instruccion {

    private Instruccion asignacion;
    private Instruccion condicion;
    private Instruccion actualizacion;
    private LinkedList<Instruccion> instrucciones;

    public For(Instruccion asignacion, Instruccion condicion, Instruccion actualizacion, LinkedList<Instruccion> instrucciones, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.asignacion = asignacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // asignacion a la variable
        var res1 = this.asignacion.interpretar(arbol, tabla);
        if (res1 instanceof Errores) {
            return res1;
        }

        // validar la condicion
        var cond = this.condicion.interpretar(arbol, tabla);
        if (cond instanceof Errores) {
            return cond;
        }
        if (this.condicion.tipo.getTipo() != tipoDato.BOOLEANO) {
            return new Errores("SEMANTICO",
                    "La condicion del ciclo for debe ser de tipo booleano",
                    this.linea,
                    this.col);
        }

        var nuevaTabla = new tablaSimbolos(tabla);

        while ((boolean) this.condicion.interpretar(arbol, nuevaTabla)) {
            var nuevaTabla2 = new tablaSimbolos(nuevaTabla);

            for (var i : this.instrucciones) {
                var resIns = i.interpretar(arbol, nuevaTabla2);
                // errores
            }
            var act = this.actualizacion.interpretar(arbol, nuevaTabla);
            if (act instanceof Errores) {
                return act;
            }
        }
        return null;
    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        return "";
    }

}
