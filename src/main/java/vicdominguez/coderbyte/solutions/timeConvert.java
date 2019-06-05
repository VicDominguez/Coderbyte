package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class timeConvert implements Runnable {
    /*
    Have the function TimeConvert(num) take the num parameter being passed and
    return the number of hours and minutes the parameter converts to (ie. if num = 63 then the output should be 1:3).
    Separate the number of hours and minutes with a colon.
    */

    private static String timeConvert(int num) {
        return (num / 60 + ":" + num % 60);
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce a integer");
        System.out.print(timeConvert(s.nextInt()));
    }
}
