import java.util.ArrayList;

public class Complexity {
    public static void main(String[] args) {
        String s = "uncopyrightable";
        System.out.println(s + ": " + numberOfMoves(s) + " moves");

        s = "aaabbbccc";
        System.out.println(s + ": " + numberOfMoves(s) + " moves");
    }

    private static int numberOfMoves(String s) {
        int moves = 0;
        while (true) {

            ArrayList<Character> found = new ArrayList<>();
            ArrayList<Integer> counts = new ArrayList<>();
            int highestCount = 0;
            int highestCountIndex = 0;
            for (char c : s.toCharArray()) {
                int index;
                int count;

                if (!found.contains(c)) {
                    index = found.size();
                    count = 1;
                    found.add(c);
                    counts.add(count); // initial count for this character
                } else {
                    index = found.indexOf(c);
                    count = counts.get(index) + 1;
                    counts.set(index, count); // increment count
                }

                // keep track of the highest count we've seen for a given char
                if (count > highestCount) {
                    highestCount = count;
                    highestCountIndex = index;
                }
            }

            // If score <= 2, we're done
            if (found.size() <= 2)
                return moves;

            // Otherwise, remove the 1st occurrence of the most common char
            moves++;
            char mostCommon = found.get(highestCountIndex);
            s = s.replaceFirst(Character.toString(mostCommon), "");
            System.out.println("\t" + moves + ": " + s);
        }
    }
}
