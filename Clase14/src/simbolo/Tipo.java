/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simbolo;

/**
 *
 * @author fabian
 */
public class Tipo {

    private tipoDato tipo;

    public Tipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public tipoDato getTipo() {
        return tipo;
    }

    public void setTipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public String getTipoString() {
        return switch (this.tipo) {
            case tipoDato.ENTERO -> "int";
            case tipoDato.DECIMAL -> "double";
            case tipoDato.CADENA -> "string";
            case tipoDato.BOOLEANO -> "boolean";
            case tipoDato.CARACTER -> "char";
            case tipoDato.VOID -> "void";
            default -> "";
        };
    }

}
