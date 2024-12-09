/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patroninterprete;


/**
 *
 * @author fabian
 */
public class PatronInterprete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*try {
            String texto = "imprimir(\"Mi cadena\");imprimir(2+\"hola mundo\");imprimir(3.33);";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            parser p = new parser(s);
            var resultado = p.parse();

            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new tablaSimbolos();

            for (var a : ast.getInstrucciones()) {
                var res = a.interpretar(ast, tabla);
                //System.out.println(res);
            }
            System.out.println(ast.getConsola());

        } catch (Exception e) {
            System.out.println(e);
        }*/
        Interfaz i = new Interfaz();
        i.setVisible(true);
        
    }
}
