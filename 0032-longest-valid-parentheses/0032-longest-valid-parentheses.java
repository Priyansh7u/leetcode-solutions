import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for valid substring length calculation
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Pop the matching '(' or the base marker
                
                if (stack.isEmpty()) {
                    // If empty, push current index as the new base for future valid substrings
                    stack.push(i);
                } else {
                    // Calculate valid substring length
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}