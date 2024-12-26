/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;

/**
 *
 * @author fabian
 */
// esta es la de ustedes
// let/const    id  :    int/double... ;
// MUTABILIDAD  id  :    TIPO           ;
// let/const    id  :    int/double... = EXP ;
// MUTABILIDAD  id  :    TIPO          = EXP ;
// este es el del ejemplo
// TIPOS id = EXP ;
public class Declaracion extends Instruccion {

    private String identificador;
    private Instruccion valor;

    public Declaracion(String identificador, Instruccion valor, Tipo tipo, int linea, int col) {
        super(tipo, linea, col);
        this.identificador = identificador;
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        // validar el valor recibido
        var valorInterpretado = this.valor.interpretar(arbol, tabla);
        if (valorInterpretado instanceof Errores) {
            return valorInterpretado;
        }

        // tipos
        if (this.valor.tipo.getTipo() != this.tipo.getTipo()) {
            return new Errores("SEMANTICO", "Tipos erroneos", this.linea, this.col);
        }

        // validar la existencia de la variable y declarar la variable
        if (tabla.setVariable(new Simbolo(this.tipo, this.identificador, valorInterpretado))) {
            // dio true, entonces si se declaro la variable
            return null;
        }
        return new Errores("SEMANTICO", "La variable " + this.identificador + " ya existe", this.linea, this.col);

    }

    @Override
    public String generarAST(Arbol arbol, String anterior) {
        // DECLARACION -> TIPOS ID IGUAL EXPRESION ;
        String nodoDeclaracion = "n" + arbol.getContador();
        String nodoTipos = "n" + arbol.getContador();
        String nodoTipos2 = "n" + arbol.getContador();

        String nodoId = "n" + arbol.getContador();
        String nodoId2 = "n" + arbol.getContador();

        String nodoIgual = "n" + arbol.getContador();
        String nodoExpresion = "n" + arbol.getContador();
        String nodoPuntoComa = "n" + arbol.getContador();

        String resultado = "";
        resultado += nodoDeclaracion + "[label=\"DECLARACION\"];\n";
        resultado += nodoTipos + "[label=\"TIPOS\"];\n";
        resultado += nodoTipos2 + "[label=\"" + this.tipo.getTipoString() + "\"];\n";

        resultado += nodoId + "[label=\"ID\"];\n";
        resultado += nodoId2 + "[label=\"" + this.identificador + "\"];\n";

        resultado += nodoIgual + "[label=\"=\"];\n";
        resultado += nodoExpresion + "[label=\"EXPRESION\"];\n";
        resultado += nodoPuntoComa + "[label=\";\"];\n";

        resultado += anterior + " -> " + nodoDeclaracion + ";\n";
        resultado += nodoDeclaracion + " -> " + nodoTipos + ";\n";
        resultado += nodoDeclaracion + " -> " + nodoId + ";\n";
        resultado += nodoDeclaracion + " -> " + nodoIgual + ";\n";
        resultado += nodoDeclaracion + " -> " + nodoExpresion + ";\n";
        resultado += nodoDeclaracion + " -> " + nodoPuntoComa + ";\n";

        resultado += nodoTipos + " -> " + nodoTipos2 + ";\n";
        resultado += nodoId + " -> " + nodoId2 + ";\n";

        resultado += this.valor.generarAST(arbol, nodoExpresion);

        return resultado;
    }

}
