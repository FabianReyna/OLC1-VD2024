/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author fabian
 */
public class Errores {

    private String tipo;
    private String desc;
    private int linea;
    private int columna;

    public Errores(String tipo, String desc, int linea, int columna) {
        this.tipo = tipo;
        this.desc = desc;
        this.linea = linea;
        this.columna = columna;
    }

    public Object[] getError() {
        return new Object[]{0, this.tipo, this.desc, this.linea, this.columna};
    }

}
