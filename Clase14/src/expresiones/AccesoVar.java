/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author fabian
 */
// int a = 10;    console.log(a);
//ID
public class AccesoVar extends Instruccion {

    private String id;

    public AccesoVar(String id, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = tabla.getVariable(id);
        if (valor == null) {
            return new Errores("SEMANTICO", "Variable no existente",
                    this.linea, this.col);
        }
        
        this.tipo.setTipo(valor.getTipo().getTipo());
        return valor.getValor();
    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // E -> ID -> valor
        return "";
    }

}
