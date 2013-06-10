/*
 * Calculadora Karatsuba
 * Esta clase valida caracter a caracter de la cadena digitada.
 * Si en la cadena ecuentra todos los caracteres numericos lo castea a BigInteger
 * Si encuentra letras o caracteres especiales envia el mensaje del error y retorna al main TestKaratsuba().
 * Para la operacion de grandes numeros, es importante utilizar BigInteger.
 */
package Model;

import View.TestKaratsuba;
import java.math.BigInteger;

public class ModelKaratsuba {

    public BigInteger CompruebaIngresoDatos(String cadena) {

        int i;
        BigInteger bigEntero;
        String mensaje = "\n Debe ingresar numeros enteros positivos.Se encontraron ";

        
        try {
            for (i = 0; i < cadena.length(); i++) {
                //evalua si son numeros
                if (cadena.charAt(i) > 47 && cadena.charAt(i) < 58) {   
                    bigEntero = new BigInteger(cadena);
                    return bigEntero;
                //evalua si son letras    
                } else if (cadena.charAt(i) > 64 && cadena.charAt(i) < 91 || (cadena.charAt(i) > 96) && (cadena.charAt(i) < 123)) {   
                    System.out.println(mensaje + "letras\n");
                    TestKaratsuba.main(null);
                //evalua si la cadena enpieza con el signo menos(-)
                } else if (cadena.charAt(i) == 45) {                                                 
                    System.out.println(mensaje + "signo negativo\n");
                    TestKaratsuba.main(null);
                // evalua caracteres especiales
                } else {                                                 
                    System.out.println(mensaje + "caracteres no validos\n"); 
                    TestKaratsuba.main(null);
                }
            }
        } catch (Exception e) {
            //evalua espacio en blanco
            System.out.println(mensaje + "caracteres no validos\n");   
            TestKaratsuba.main(null);
        }
        return null;
    }
}
