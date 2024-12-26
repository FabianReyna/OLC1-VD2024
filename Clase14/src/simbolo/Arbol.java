/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.LinkedList;
import instrucciones.Metodo;

/**
 *
 * @author fabian
 */
public class Arbol {

    private LinkedList<Instruccion> instrucciones;
    private String consola;
    private LinkedList<Errores> errores;
    private tablaSimbolos tablaGlobal;
    private LinkedList<Instruccion> funciones;
    public int contador;

    public Arbol(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
        consola = "";
        this.errores = new LinkedList<>();
        this.funciones = new LinkedList<>();
        this.contador = 0;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public int getContador() {
        this.contador++;
        return contador;
    }

    public String getConsola() {
        return consola;
    }

    public LinkedList<Errores> getErrores() {
        return errores;
    }

    public tablaSimbolos getTablaGlobal() {
        return tablaGlobal;
    }

    public LinkedList<Instruccion> getFunciones() {
        return funciones;
    }

    public void setFunciones(LinkedList<Instruccion> funciones) {
        this.funciones = funciones;
    }

    public void addFunciones(Instruccion funcion) {
        this.funciones.add(funcion);
    }

    public Instruccion getFuncion(String id) {
        for (var i : this.funciones) {
            if (i instanceof Metodo metodo) {
                if (metodo.id.equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return null;
    }

    public void setTablaGlobal(tablaSimbolos tablaGlobal) {
        this.tablaGlobal = tablaGlobal;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void Print(String valor) {
        this.consola += valor + "\n";
    }

    public void AddErrores(Errores e) {
        this.errores.add(e);
    }

}
