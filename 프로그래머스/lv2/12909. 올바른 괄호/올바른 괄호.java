import java.util.Stack;

class Solution {
    boolean solution(String s) {
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < brackets.length; i++) {
            char bracket = brackets[i];
            if (bracket == '(')
                stack.add(bracket);
            else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }
}