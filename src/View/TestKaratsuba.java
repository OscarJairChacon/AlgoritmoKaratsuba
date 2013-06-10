/*
 * Calculadora Karatsuba
 * Esta clase simula la Interface de Usuario.
 */

package View;

import Model.ModelKaratsuba;
import Multiplicator.CalculaKaratsuba;
import java.math.BigInteger;
import java.util.Scanner;

public class TestKaratsuba {

    public static void main(String[] args) {
        
        String num1=null;
        String num2=null;
        String continua=null;
        BigInteger numero1;
        BigInteger numero2;
        
        Scanner sc= new Scanner(System.in);
        ModelKaratsuba mdk = new ModelKaratsuba();
        System.out.println("-----------------------------------------");
        System.out.println("* Bienvenido a la Calculadora Karatsuba *");
        System.out.println("-----------------------------------------\n");
        System.out.println("Digite el 1er numero:");
        num1=sc.nextLine();
        numero1=mdk.CompruebaIngresoDatos(num1);
      
        System.out.println("\nDigite el 2do numero:");
        num2=sc.nextLine();
        numero2=mdk.CompruebaIngresoDatos(num2);
       
        CalculaKaratsuba calculadora = new CalculaKaratsuba();
        System.out.println("\nEl producto Karatsuba es: "+ calculadora.calculaKaratsuba(numero1, numero2)+"\n");
        
        System.out.println("¿Desea Calcular mas numeros?, Y,N");
        continua=sc.nextLine();
        if(continua.charAt(0)=='Y' || continua.charAt(0)=='y'){
            TestKaratsuba.main(args);
        }else
        {
            System.out.println("Muchas Gracias.,");
            System.exit(0);
        }
        
        
        
        
        

       
       
                
        
        
        
        
        
        
        
        
    }
}
