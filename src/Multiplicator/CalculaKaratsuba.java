/*
 * Calculadora Karatsuba
 * Para la operacion de grandes numeros, es importante utilizar BigInteger.
 * Las operaciones se hacen en bits para la recursion.
 */
package Multiplicator;

import java.math.BigInteger;

public class CalculaKaratsuba {

    public BigInteger calculaKaratsuba(BigInteger numero1, BigInteger numero2) {

        int posicionBit;
        BigInteger p, q, r, w, x, y, z, z1 ;

        //Condicion para evaluar el numero a su division minima. Util para recursion del algoritmo.
        if (numero1.bitLength() == 0 || numero2.bitLength() == 0) {
            return BigInteger.ZERO;
        } else if (numero1.bitLength() == 1) {
            return numero2;
        } else if (numero2.bitLength() == 1) {
            return numero1;
        }

        // mayor longitud de bit de los 2 numeros ingresados.
        posicionBit= Math.max(numero1.bitLength(), numero2.bitLength());
        // factor para dividir el numero
        posicionBit = (posicionBit / 2);
        /*
         * operaciones con bits --(division del numero en bits)
         * numero1 = w * 2^n + x                                        
         * numero2 = y * 2^n + z                                        
        */
        w = numero1.shiftRight(posicionBit);                            
        x = numero1.subtract(w.shiftLeft(posicionBit));
        y = numero2.shiftRight(posicionBit);
        z = numero2.subtract(y.shiftLeft(posicionBit));
        
        // Calculo del resultado parcial es recursivo
        p = calculaKaratsuba(w, y);                   //p=w*y            
        r = calculaKaratsuba(x.add(w), z.add(y));     //r=(x+w)*(z+y)    
        q = calculaKaratsuba(x, z);                   //q=x*z;
        z1 = r.subtract(p).subtract(q);               //z1=r-p-q
        
        //Resultado final de operaciones parciales
        return p.shiftLeft(2 * posicionBit).add(z1.shiftLeft(posicionBit)).add(q);
    }
}
