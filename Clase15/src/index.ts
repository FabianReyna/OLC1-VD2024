class ejemploJison {
    start(): any {
        try {
            let parser = require('./analizador.js')
            let resultado = parser.parse('evAluar{1+2};imprimir{\"hola mundo\"};evaluar{(3*5)+(1/3)};');
            //console.log(resultado);
    } catch (e: any) {
            console.log(e)
        }
    }
}
export const ejemploJison2 = new ejemploJison();
ejemploJison2.start();