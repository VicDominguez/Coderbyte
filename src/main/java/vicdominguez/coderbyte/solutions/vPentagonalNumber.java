package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class vPentagonalNumber implements Runnable
{
    private static long pentagonalNumber(int nivel)
    {
        long resultado = (((nivel - 1) * 5 * nivel) / 2)+ 1;
        System.out.println("La diferencia con el tope de long es " + (Long.MAX_VALUE - resultado));
        /*
        if(nivel ==1)
        return 1;
        else
        return (5 * (nivel-1)) * vPentagonalNumber(nivel-1)
         */
        //La formula iterativa por progesión aritmética es 1 + (((n-1)/2)*5n)
        return resultado;
    }

    public void run ()
    {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dame un nivel para calcular el vPentagonalNumber");
        int nivel = lector.nextInt();
        lector.close();
        long resultado = pentagonalNumber(nivel);
        System.out.println("El resultado es " + resultado);
    }
}
