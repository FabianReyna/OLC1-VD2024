/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author fabian
 */

/*
void id (){instrucciones}
void id (parametros) {instrucciones}
 */
public class Metodo extends Instruccion {

    public String id;
    //parametros quedan pendientes
    public LinkedList<Instruccion> instrucciones;

    public Metodo(String id, LinkedList<Instruccion> instrucciones, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.id = id;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        for (var i : this.instrucciones) {
            var resultado = i.interpretar(arbol, tabla);
            //recuperacion de errores
        }
        return null;
    }
}
