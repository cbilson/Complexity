import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Complexity {
    private static boolean debug = false;

    public static void main(String[] args) throws FileNotFoundException {
        //debug = true;
        //test();

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("C:\\Users\\cbilson\\Complexity.txt"));

        int problems = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < problems; i++) {
            String s = scanner.nextLine();
            System.out.println(numberOfMoves(s));
        }
    }

    private static void test() {
        String s = "string";
        log(s + ": " + numberOfMoves(s) + " moves");

        s = "letter";
        log(s + ": " + numberOfMoves(s) + " moves");

        s = "aaabbb";
        log(s + ": " + numberOfMoves(s) + " moves");

        s = "aaabbbccc";
        log(s + ": " + numberOfMoves(s) + " moves");

        s = "uncopyrightable";
        log(s + ": " + numberOfMoves(s) + " moves");
    }

    private static int numberOfMoves(String s) {
        int moves = 0;
        while (true) {

            ArrayList<Character> found = new ArrayList<>();
            ArrayList<Integer> counts = new ArrayList<>();
            for (char c : s.toCharArray()) {
                if (!found.contains(c)) {
                    found.add(c);
                    counts.add(1); // initial count for this character
                } else {
                    int index = found.indexOf(c);
                    int count = counts.get(index) + 1;
                    counts.set(index, count); // increment count
                }
            }

            // If score <= 2, we're done
            if (found.size() <= 2)
                return moves;

            // Otherwise, find the smallest count
            moves++;
            int smallestCount = Collections.min(counts);
            int leastCommonIndex = counts.indexOf(smallestCount);
            char leastCommon = found.get(leastCommonIndex);
            s = s.replaceFirst(Character.toString(leastCommon), "");
            log("\t" + moves + ": " + s);
        }
    }

    private static void log(String s) {
        if (!debug) return;

        System.out.println(s);
    }
}
