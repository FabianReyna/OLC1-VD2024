"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ejemploJison2 = void 0;
class ejemploJison {
    start() {
        try {
            let parser = require('./analizador.js');
            let resultado = parser.parse('evAluar{1+2};imprimir{\"hola mundo\"};evaluar{(3*5)+(1/3)};');
            //console.log(resultado);
        }
        catch (e) {
            console.log(e);
        }
    }
}
exports.ejemploJison2 = new ejemploJison();
exports.ejemploJison2.start();
