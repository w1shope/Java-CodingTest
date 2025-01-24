import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    sb.append(operators.pop());
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && comparePriority(operators.peek()) >= comparePriority(c)) {
                    sb.append(operators.pop());
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            sb.append(operators.pop());
        }

        System.out.println(sb);
    }

    static int comparePriority(char op) {
        if (op == '(' || op == ')') {
            return 0;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return 2;
    }
}