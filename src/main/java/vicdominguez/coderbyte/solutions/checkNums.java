package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class checkNums implements Runnable {
    /*
    Have the function CheckNums(num1,num2) take both parameters being passed and return the string true if num2 is greater than num1, otherwise return the string false.
    If the parameter values are equal to each other then return the string -1.
     */
    private static String checkNums(int num1, int num2) {
        String output;
        if (num1 > num2)
            output = "false";
        else {
            if (num1 == num2)
                output = "-1";
            else
                output = "true";
        }
        return output;
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two integers");
        System.out.print(checkNums(s.nextInt(), s.nextInt()));
    }
}
