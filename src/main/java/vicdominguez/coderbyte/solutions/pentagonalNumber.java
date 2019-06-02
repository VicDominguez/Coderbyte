package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class pentagonalNumber implements Runnable {
    /*
    Recursive expression is:
        if level > 1 output = (5 * level - 1) * pentagonalNumber(level - 1)
        if level = 1 output = 1
    Iterative expression is 1 + ( ( (level - 1) / 2 ) * 5level)
    */
    private static long pentagonalNumber(int nivel) {
        return (((nivel - 1) * 5 * nivel) / 2) + 1;
    }

    public void run ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a number to compute pentagonalNumber");
        System.out.println(String.format("Output is %d", pentagonalNumber(sc.nextInt())));
        sc.close();
    }
}
