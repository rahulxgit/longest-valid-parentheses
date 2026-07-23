# Longest Valid Parentheses

LeetCode 32. Given a string of just `(` and `)`, find the length of the longest substring that's valid (well-formed) parentheses.

Example:
```
")()())" -> 4   (the "()()" part)
"(()"    -> 2
""       -> 0
```

## How it works

I used the stack-of-indices trick instead of tracking characters directly. The stack holds indices, and it always represents "the index right before the current run of unmatched stuff started."

Steps:
1. Push `-1` onto the stack first, as a base. This matters because if the whole string is valid starting from index 0, we still need something to subtract from.
2. Walk through the string. For every `(`, push its index.
3. For every `)`, pop the stack first.
   - If the stack is now empty, that `)` had nothing to pair with, so it becomes the new base — push its index.
   - Otherwise, whatever's on top of the stack now marks the boundary right before the current valid run, so `i - stack.peek()` gives the length of that run.

It's O(n) time since each index is pushed and popped at most once, and O(n) space in the worst case (e.g. a string of all `(`).

I also thought about the DP approach (dp[i] = length of valid substring ending at i) but the stack version felt more intuitive to trace through by hand, so that's what I went with.

## Files

- `LongestValidParentheses.java` — the solution, has a `main` with a few quick checks
- `LongestValidParenthesesTest.java` — separate test file with more edge cases

## Running it

```bash
javac LongestValidParentheses.java LongestValidParenthesesTest.java
java LongestValidParenthesesTest
```

If it prints `all tests passed` at the end, you're good.
