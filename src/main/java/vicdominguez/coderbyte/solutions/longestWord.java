package vicdominguez.coderbyte.solutions;

import java.util.Scanner;

public class longestWord implements Runnable {
    /*
    Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string.
    If there are two or more words that are the same length, return the first word from the string with that length.
    Ignore punctuation and assume sen will not be empty.
     */

    public static String longestWord(String sen) {
        String[] pieces = sen.split(" ");
        int maxSize = 0, indexToReturn = 0;
        for (int index = 0; index < pieces.length; index++) {
            pieces[index] = clearPiece(pieces[index]);
            if (pieces[index].length() > maxSize) {
                indexToReturn = index;
                maxSize = pieces[index].length();
            }
        }
        return pieces[indexToReturn];
    }

    private static String clearPiece(String item) {
        int index = 0;
        boolean stop = false;
        for (; index < item.length() && !stop; index++) {
            if (!((Character.isLetter(item.charAt(index))) || Character.isDigit(item.charAt(index)))) {
                stop = true;
                index--;
            }
        }
        return item.substring(0, index);
    }

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce a sentence");
        System.out.print(longestWord(s.nextLine()));
    }
}
