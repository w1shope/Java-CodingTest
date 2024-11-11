import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int temp = 1;
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if (arr[i - 1] == '(') {
                    answer += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (arr[i - 1] == '[') {
                    answer += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }

        System.out.println(answer);
    }
}