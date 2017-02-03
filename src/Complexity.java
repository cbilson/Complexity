import java.util.ArrayList;

/**
 * Created by cbilson on 2/2/2017.
 */
public class Complexity {
    public static void main(String[] args) {
        String s = "string";
        System.out.println(s + ": " + computeComplexity(s));

        s = "letter";
        System.out.println(s + ": " + computeComplexity(s));
    }

    private static int computeComplexity(String s) {
        ArrayList<Character> found = new ArrayList<Character>();
        for (char c : s.toCharArray())
            if (!found.contains(c))
                found.add(c);

        return found.size();
    }
}
