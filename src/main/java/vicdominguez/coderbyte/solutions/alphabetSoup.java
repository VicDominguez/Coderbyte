package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class alphabetSoup implements Runnable {
    /*
    Have the function AlphabetSoup(str) take the str string parameter being passed
    and return the string with the letters in alphabetical order (ie. hello becomes ehllo).
    Assume numbers and punctuation symbols will not be included in the string.
     */

    //A better algorithm could be written like quicksort, or use library functions like Array.sort, but I prefered
    //do it by myself with the first idea that come to my brain.
    private static String AlphabetSoup(String input) {
        StringBuilder output = new StringBuilder();
        output.append(input.charAt(0));
        for (int index = 1; index < input.length(); index++) {
            Character item = input.charAt(index);
            boolean stop = false;
            for (int internalIndex = 0; internalIndex < output.length() && !stop; internalIndex++) {
                if (item < output.charAt(internalIndex)) {
                    output.insert(internalIndex, item);
                    stop = true;
                }
            }
            if (!stop)
                output.append(item);
        }
        return output.toString();
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce a string to sort");
        System.out.print(AlphabetSoup(s.nextLine()));
    }
}
