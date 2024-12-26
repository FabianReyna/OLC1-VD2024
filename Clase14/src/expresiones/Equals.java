/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresiones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.*;
import static simbolo.tipoDato.DECIMAL;
import static simbolo.tipoDato.ENTERO;

/**
 *
 * @author fabian
 */
// E -> E == E 
// SIEMPRE actualizar el tipo
// RETORNAR el resultado
public class Equals extends Instruccion {

    private Instruccion expIzq;
    private Instruccion expDer;

    public Equals(Instruccion expIzq, Instruccion expDer, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.expIzq = expIzq;
        this.expDer = expDer;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var res1 = this.expIzq.interpretar(arbol, tabla);
        if (res1 instanceof Errores) {
            return res1;
        }

        var res2 = this.expDer.interpretar(arbol, tabla);
        if (res2 instanceof Errores) {
            return res1;
        }

        var tipo1 = this.expIzq.tipo.getTipo();
        var tipo2 = this.expDer.tipo.getTipo();

        switch (tipo1) {
            case ENTERO -> {
                return switch (tipo2) {
                    case ENTERO ->
                        (int) res1 == (int) res2;
                    case DECIMAL ->
                        (int) res1 == (double) res2;
                    default ->
                        new Errores("SEMANTICO", "COMBINACION DE RELACIONAL == INVALIDA",
                        this.linea, this.col);
                };
            }

            case DECIMAL -> {
                return switch (tipo2) {
                    case ENTERO ->
                        (double) res1 == (int) res2;
                    case DECIMAL ->
                        (double) res1 == (double) res2;
                    default ->
                        new Errores("SEMANTICO", "COMBINACION DE RELACIONAL == INVALIDA",
                        this.linea, this.col);
                };
            }
            case CADENA -> {
                switch (tipo2) {
                    case CADENA:
                        return ((String) res1).equals((String) res2);
                    default:
                        return new Errores("SEMANTICO", "COMBINACION DE RELACIONAL == INVALIDA",
                                this.linea, this.col);
                }
            }
            default -> {
                return new Errores("SEMANTICO", "COMBINACION DE RELACIONAL == INVALIDA",
                        this.linea, this.col);
            }
        }
    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // E -> LOGICAS -> E == E
        return "";
    }

}
