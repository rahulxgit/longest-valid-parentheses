import java.util.ArrayDeque;
import java.util.Deque;

// LeetCode 32 - Longest Valid Parentheses
// Approach: stack of indices. Keep a "base" index at the bottom so we can
// always compute length as (current index - index below top of stack).
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // dummy base, handles the case where valid substring starts at index 0

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
                continue;
            }

            // c == ')'
            stack.pop();

            if (stack.isEmpty()) {
                // nothing left to match this ')' with, so it becomes the new base
                stack.push(i);
            } else {
                int len = i - stack.peek();
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses sol = new LongestValidParentheses();

        System.out.println(sol.longestValidParentheses("(()"));    // expect 2
        System.out.println(sol.longestValidParentheses(")()())")); // expect 4
        System.out.println(sol.longestValidParentheses(""));       // expect 0
        System.out.println(sol.longestValidParentheses("()(())")); // expect 6
        System.out.println(sol.longestValidParentheses(")("));     // expect 0
    }
}
