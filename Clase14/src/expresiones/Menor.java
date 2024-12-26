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
import static simbolo.tipoDato.DECIMAL;
import static simbolo.tipoDato.ENTERO;

/**
 *
 * @author fabian
 */
public class Menor extends Instruccion {

    private Instruccion opIzq;
    private Instruccion opDer;

    public Menor(Instruccion opIzq, Instruccion opDer, int linea, int col) {
        super(new Tipo(tipoDato.BOOLEANO), linea, col);
        this.opIzq = opIzq;
        this.opDer = opDer;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var cond1 = this.opIzq.interpretar(arbol, tabla);
        if (cond1 instanceof Errores) {
            return cond1;
        }

        var cond2 = this.opDer.interpretar(arbol, tabla);
        if (cond2 instanceof Errores) {
            return cond2;
        }

        var comparando1 = this.opIzq.tipo.getTipo();
        var comparando2 = this.opDer.tipo.getTipo();

        return switch (comparando1) {
            case ENTERO ->
                switch (comparando2) {
                    case ENTERO ->
                        (int) cond1 < (int) cond2;
                    case DECIMAL ->
                        (int) cond1 < (double) cond2;
                    default ->
                        new Errores("SEMANTICO",
                        "Relacional Invalido",
                        this.linea,
                        this.col);
                };
            case DECIMAL ->
                switch (comparando2) {
                    case ENTERO ->
                        (double) cond1 < (int) cond2;
                    case DECIMAL ->
                        (double) cond1 < (double) cond2;
                    default ->
                        new Errores("SEMANTICO",
                        "Relacional Invalido",
                        this.linea,
                        this.col);
                };
            default ->
                new Errores("SEMANTICO",
                "Relacional Invalido",
                this.linea,
                this.col);
        };

    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // E -> E < E
        return "";
    }

}
