/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import simbolo.Arbol;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author fabian
 */
public class Nativo extends Instruccion {

    public Object valor;

    public Nativo(Object valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        return this.valor;

    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // NATIVO
        // valor
        // NATIVO -> VALOR
        //ANTERIOR -> NATIVO

        String nodoNativo = "n" + arbol.getContador(); //n1
        String nodoValor = "n" + arbol.getContador(); //n2

        String resultado = "";
        resultado += nodoNativo + "[label=\"NATIVO\"];\n";
        resultado += nodoValor + "[label=\"" + this.valor.toString() + "\"];\n";
        resultado += nodoNativo + " -> " + nodoValor + ";\n";
        resultado += anterior + " -> " + nodoNativo + ";\n";
        return resultado;

    }

}
