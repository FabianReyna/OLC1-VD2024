/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;

/**
 *
 * @author fabian
 */
// E -> E + E
public class Suma extends Instruccion {

    private Instruccion opIzq;
    private Instruccion opDer;

    public Suma(Instruccion opIzq, Instruccion opDer, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.opIzq = opIzq;
        this.opDer = opDer;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var valorIzq = this.opIzq.interpretar(arbol, tabla);
        if (valorIzq instanceof Errores) {
            return valorIzq;
        }

        var valorDer = this.opDer.interpretar(arbol, tabla);
        if (valorDer instanceof Errores) {
            return valorDer;
        }

        var tipoIzq = opIzq.tipo.getTipo();
        var tipoDer = opDer.tipo.getTipo();

        switch (tipoIzq) {
            case ENTERO -> {
                switch (tipoDer) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (int) valorIzq + (int) valorDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (int) valorIzq + (double) valorDer;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "SUMA ENTRE TIPOS INVALIDA",
                                this.linea, this.col);
                    }
                }
            }

            case DECIMAL -> {
                switch (tipoDer) {
                    case ENTERO -> {
                        this.tipo.setTipo(tipoDato.ENTERO);
                        return (double) valorIzq + (int) valorDer;
                    }
                    case DECIMAL -> {
                        this.tipo.setTipo(tipoDato.DECIMAL);
                        return (double) valorIzq + (double) valorDer;
                    }
                    default -> {
                        return new Errores("SEMANTICO", "SUMA ENTRE TIPOS INVALIDA",
                                this.linea, this.col);
                    }
                }
            }

            default -> {
                return new Errores("SEMANTICO", "SUMA ENTRE TIPOS INVALIDA",
                        this.linea, this.col);
            }
        }

    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // E -> E1 + E2
        // E1 -> algo
        // E2 -> algo

        String nodoE0 = "n" + arbol.getContador();
        String nodoE1 = "n" + arbol.getContador();
        String nodoMas = "n" + arbol.getContador();
        String nodoE2 = "n" + arbol.getContador();

        String resultado = "";
        // generar nodos
        resultado += nodoE0 + "[label=\"EXPRESION\"];\n";
        resultado += nodoE1 + "[label=\"EXPRESION\"];\n";
        resultado += nodoMas + "[label=\"+\"];\n";
        resultado += nodoE2 + "[label=\"EXPRESION\"];\n";
        // hacer uniones
        resultado += nodoE0 + " -> " + nodoE1 + ";\n";
        resultado += nodoE0 + " -> " + nodoMas + ";\n";
        resultado += nodoE0 + " -> " + nodoE2 + ";\n";

        // E1 -> produce
        resultado += this.opIzq.generarAST(arbol, nodoE1);

        // E2 -> produce
        resultado += this.opDer.generarAST(arbol, nodoE2);

        // anterior -> e0
        resultado += anterior + " -> " + nodoE0 + ";\n";
        return resultado;
    }

}
