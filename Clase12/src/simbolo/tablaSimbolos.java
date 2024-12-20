/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

import java.util.HashMap;

/**
 *
 * @author fabian
 */
public class tablaSimbolos {

    private HashMap<String, Simbolo> tablaActual;
    private String nombre;
    private tablaSimbolos tablaAnterior;

    public tablaSimbolos() {
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public tablaSimbolos(tablaSimbolos tablaAnterior) {
        this.tablaAnterior = tablaAnterior;
        this.tablaActual = new HashMap<>();
        this.nombre = "";
    }

    public HashMap<String, Simbolo> getTablaActual() {
        return tablaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public tablaSimbolos getTablaAnterior() {
        return tablaAnterior;
    }

    public void setTablaActual(HashMap<String, Simbolo> tablaActual) {
        this.tablaActual = tablaActual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean setVariable(Simbolo simbolo) {
        Simbolo busqueda = (Simbolo) this.tablaActual.get(simbolo.getId().toLowerCase());
        if (busqueda == null) {
            this.tablaActual.put(simbolo.getId().toLowerCase(), simbolo);
            return true;
        }
        return false;
    }

    public Simbolo getVariable(String id) {
        for (tablaSimbolos i = this; i != null; i = i.getTablaAnterior()) {
            Simbolo busqueda = (Simbolo) i.getTablaActual().get(id.toLowerCase());
            if (busqueda != null) {
                return busqueda;
            }
        }
        return null;
    }

}
