import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            
            // 종료 조건
            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true; // 올바른 괄호 여부
            for (char c : input.toCharArray()) {
                // 여는 괄호
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                // 닫는 괄호
                if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && isCorrect) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}