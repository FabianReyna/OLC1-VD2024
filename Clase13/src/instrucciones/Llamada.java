/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import abstracto.Instruccion;
import excepciones.Errores;
import java.util.HashMap;
import java.util.LinkedList;
import simbolo.Arbol;
import simbolo.Simbolo;
import simbolo.Tipo;
import simbolo.tablaSimbolos;
import simbolo.tipoDato;

/**
 *
 * @author fabian
 */
public class Llamada extends Instruccion{
        private String id;
    private LinkedList<HashMap> parametros;

    public Llamada(String id, LinkedList<HashMap> parametros, int linea, int col) {
        super(new Tipo(tipoDato.VOID), linea, col);
        this.id = id;
        this.parametros = parametros;
    }

    @Override
    public Object interpretar(Arbol arbol, tablaSimbolos tabla) {
        var busqueda = arbol.getFuncion(id);
        if (busqueda == null) {
            return new Errores("SEMANTICO", "Funcion no existente",
                    this.linea, this.col);
        }

        if (busqueda instanceof Metodo metodo) {
            var newTabla = new tablaSimbolos(arbol.getTablaGlobal());
            newTabla.setNombre("Llamada " + id);

            
            // declarando parametros
            for (int i = 0; i < metodo.parametros.size(); i++) {
                var identificador = (String) metodo.parametros.get(i).get("id");
                var tipo = (Tipo) metodo.parametros.get(i).get("tipo");
                var expresion = (Instruccion) metodo.parametros.get(i).get("expresion");

                Object valExp = null;

                // validar la expresion
                if (expresion != null) {
                    valExp = expresion.interpretar(arbol, newTabla);
                    if (valExp instanceof Errores) {
                        return valExp;
                    }
                    if (tipo.getTipo() != expresion.tipo.getTipo()) {
                        return new Errores("SEMANTICO", "Error en el parametro",
                                this.linea, this.col);
                    }
                }

                // no se declaro ?
                if (!newTabla.setVariable(new Simbolo(tipo, identificador, valExp))) {
                    return new Errores("SEMANTICO", "Error en el parametro",
                            this.linea, this.col);
                }

            }

            // reasignar su valor
            for (int i = 0; i < this.parametros.size(); i++) {
                var variable = newTabla.getVariable((String) this.parametros.get(i).get("id"));
                if (variable == null) {
                    return new Errores("SEMANTICO", "Parametro no existente",
                            this.linea, this.col);
                }
                /*
                La llamada es ligeramente diferente al execute
                El execute viene unicamente en un entorno global, por lo tanto, 
                se puede interpretar con newTabla (un entorno que solo posee 
                acceso al entorno global y al de los parametros).
                
                Pero la llamada convencional debemos usar 2 entornos:
                   1. El entorno donde se hace la llamada (tabla)
                   2. El entorno que se crea para la funcion (newTabla)
                
                Entonces necesitamos que el valor del parametro se interprete con
                el entorno llamado tabla pero se va a declarar en el entorno newTabla
                Que son entornos totalmente diferentes
                
                */
                var valor = (Instruccion) this.parametros.get(i).get("expresion");
                var resValor = valor.interpretar(arbol, tabla);
                if (resValor instanceof Errores) {
                    return resValor;
                }

                //validar tipos
                if (valor.tipo.getTipo() != variable.getTipo().getTipo()) {
                    return new Errores("SEMANTICO", "El tipo del parametro y su valor no coinciden",
                            this.linea, this.col);
                }

                variable.setValor(resValor);
            }

            //validar que no hayan parametros como null
            for (int i = 0; i < metodo.parametros.size(); i++) {
                var identificador = (String) metodo.parametros.get(i).get("id");
                var resultado = newTabla.getVariable(identificador);
                if (resultado == null) {
                    return new Errores("SEMANTICO", "Parametro no declarado",
                            this.linea, this.col);
                }

                if (resultado.getValor() == null) {
                    return new Errores("SEMANTICO", "Parametro sin valor declarado",
                            this.linea, this.col);
                }

            }

            var resultadoMetodo = metodo.interpretar(arbol, newTabla);
            if (resultadoMetodo instanceof Errores) {
                return resultadoMetodo;
            }
        }
        return null;
    }
}
