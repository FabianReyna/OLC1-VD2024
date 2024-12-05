/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisis;

/**
 *
 * @author fabian
 */
public class Generador {

    public static void main(String[] args) {
        generarCompilador();
    }

    private static void generarCompilador() {
        try {
            String ruta = "src/analisis/";
            /*
            archivo de jflex
            -d -> en donde crear el archivo compilado
            ruta donde se generara el archivo compilado
             */
            String Flex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(Flex);

            /*
            destdir -> indica la ruta donde vamos a generar la salida
            la ruta de la salida
            -parser indica el nombre del archivo compilado
            ruta del archivo cup
             */
            String Cup[] = {"-destdir", ruta, "-parser", "parser",
                ruta + "sintactico.cup"};
            java_cup.Main.main(Cup);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
