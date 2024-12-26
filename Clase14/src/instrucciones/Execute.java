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
// EXECUTE id()
// EXECUTE id(parametros)
// id = exp
public class Execute extends Instruccion {

    private String id;
    private LinkedList<HashMap> parametros;

    public Execute(String id, LinkedList<HashMap> parametros, int linea, int col) {
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
            newTabla.setNombre("Execute " + id);

            /*En un lenguaje convencional aqui se deberia validar que la cantidad
        de parametros coincida, pero en el proyecto los parametros pueden tener
        un valor por defecto, por lo tanto no es 100 obligatorio que la cantidad
        de parametros de la funcion y de su llamada coincidan*/
            
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

                var valor = (Instruccion) this.parametros.get(i).get("expresion");
                var resValor = valor.interpretar(arbol, newTabla);
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

        @Override
    public String generarAST(Arbol arbol, String anterior) {
        return "";
    }
}

/*
int miFuncion(int a = 10, int b){
...
}

clase Metodo -> parametros
[
    {
        id: <String>,
        tipo:  <Tipo>,
        expresion: <Instruccion>
    },
    {
        id: <String>,
        tipo:  <Tipo>,
        expresion: null
    }
]


EXECUTE miFuncion(parametro1=10, parametro2=20);
clase Execute -> parametros  
[
    {
        id: <String>,
        expresion: <Instruccion>
    },
    {
        id: <String>,
        expresion: <Instruccion>
    }
]

 */
 /*

int qwe = 100;

int a (as:int=exp, ab:int){
...
a2();
}

string a2 (){
 a3();
}

bool a3 (){

}



run main a();


 */
