package vicdominguez.coderbyte.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class kaprekarsConstant implements Runnable {
    /*
    Have the function KaprekarsConstant(num) take the num parameter being passed which will be a 4-digit number with at least two distinct digits.
    Your program should perform the following routine on the number:
        Arrange the digits in descending order and in ascending order (adding zeroes to fit it to a 4-digit number),
        and subtract the smaller number from the bigger number.
        Then repeat the previous step.
    Performing this routine will always cause you to reach a fixed number: 6174.
    Then performing the routine on 6174 will always give you 6174 (7641 - 1467 = 6174).
    Your program should return the number of times this routine must be performed until 6174 is reached.
    For example: if num is 3524 your program should return 3 because of the following steps: (1) 5432 - 2345 = 3087, (2) 8730 - 0378 = 8352, (3) 8532 - 2358 = 6174.
    */

    private static final int DIGIT_NUMBER = 4;

    private static int KaprekarsConstant(int num) {
        int counter = 0, nextNumber = num;
        boolean solution = false;
        do {
            nextNumber = sort(nextNumber, false) - sort(nextNumber, true);
            counter++;
            if (nextNumber == 6174)
                solution = true;
        } while (!solution);
        return counter;
    }

    private static int sort(int number, boolean ascending) {
        int wayIndex, digitsToFit, numberOfDigits = (int) (Math.log10(number) + 1);
        int[] digits = new int[DIGIT_NUMBER];

        for (int loopIndex = 0; loopIndex < numberOfDigits; loopIndex++, number /= 10)
            digits[DIGIT_NUMBER - 1 - loopIndex] = number % 10;

        digitsToFit = DIGIT_NUMBER - numberOfDigits;
        if (digitsToFit > 0) {
            for (; digitsToFit > 0; digitsToFit--)
                digits[digitsToFit - 1] = 0;
        }

        Arrays.sort(digits);

        wayIndex = (ascending ? 0 : DIGIT_NUMBER - 1);
        number = digits[wayIndex];
        for (int loopIndex = 1; loopIndex < DIGIT_NUMBER; loopIndex++) {
            if (ascending)
                wayIndex++;
            else
                wayIndex--;
            number *= 10;
            number += digits[wayIndex];
        }

        return number;
    }

    /*
    This was my first solution to that problem
    A recursive and more elegant solution is:
     */

    private static int DeviousBardSolution(int number) {
        if (number == 6174)
            return 0;

        int[] numArray = {number / 1000, number % 1000 / 100, number % 1000 % 100 / 10, number % 1000 % 100 % 10};
        int ascNum = 0, desNum = 0;
        Arrays.sort(numArray);
        for (int index = 0; index < DIGIT_NUMBER; index++) {
            desNum += (numArray[index] * (int) Math.pow(10, index));
            ascNum += (numArray[index] * (int) Math.pow(10, DIGIT_NUMBER - 1 - index));
        }
        return 1 + KaprekarsConstant(desNum - ascNum);
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.print(KaprekarsConstant(s.nextInt()));
    }

}

