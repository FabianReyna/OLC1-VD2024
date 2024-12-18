/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author fabian
 */
// console.log(EXP)
public class Print extends Instruccion {

    private Instruccion expresion;

    public Print(Instruccion expresion, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valor = this.expresion.interpretar(arbol, tabla);
        if (valor instanceof Errores) {
            return valor;
        }
        arbol.Print(valor.toString());
        return null;
    }

}
