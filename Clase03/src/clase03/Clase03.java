package clase03;


import analisis.parser;
import analisis.parser;
import analisis.scanner;
import analisis.scanner;
import java.io.BufferedReader;
import java.io.StringReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author fabian
 */
public class Clase03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String texto = "imprimir(1+2+3);imprimir(-1+2*2+9/4);";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse().value;
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
    }

}
