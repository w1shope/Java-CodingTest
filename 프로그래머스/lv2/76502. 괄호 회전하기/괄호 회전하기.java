import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        LinkedList<Character> list = new LinkedList<>();
        strToList(s, list);

        int count = 0;
        for (int x = 0; x < list.size(); x++) {
            if (isCorrectBracket(list))
                count++;
            Collections.rotate(list, -1);
        }

        return count;
    }

    private void strToList(String s, LinkedList<Character> list) {
        for (char c : s.toCharArray())
            list.add(c);
    }

    private boolean isCorrectBracket(LinkedList<Character> list) {
        Stack<Character> stack = new Stack<>();
        for (Character c : list) {
            if (c == '(' || c == '[' || c == '{')
                stack.add(c);
            else {
                switch (c) {
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(')
                            return false;
                        stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[')
                            return false;
                        stack.pop();
                        break;
                    default:
                        if (stack.isEmpty() || stack.peek() != '{')
                            return false;
                        stack.pop();
                }
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }
}