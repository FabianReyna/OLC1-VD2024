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

}
