// Quick sanity tests, run directly with java (no test framework needed).
// If nothing prints, all tests passed.
public class LongestValidParenthesesTest {

    public static void main(String[] args) {
        LongestValidParentheses sol = new LongestValidParentheses();

        check(sol.longestValidParentheses("(()"), 2, "basic case with one unmatched open");
        check(sol.longestValidParentheses(")()())"), 4, "leading unmatched close");
        check(sol.longestValidParentheses(""), 0, "empty string");
        check(sol.longestValidParentheses("()(())"), 6, "fully valid nested + sequential");
        check(sol.longestValidParentheses(")("), 0, "no valid pairs at all");
        check(sol.longestValidParentheses("()"), 2, "single pair");
        check(sol.longestValidParentheses("((("), 0, "only opens, nothing closes");
        check(sol.longestValidParentheses(")))"), 0, "only closes, nothing opens");
        check(sol.longestValidParentheses("()()"), 4, "two pairs back to back");

        System.out.println("all tests passed");
    }

    private static void check(int actual, int expected, String label) {
        if (actual != expected) {
            throw new AssertionError(label + " -> expected " + expected + " but got " + actual);
        }
    }
}
