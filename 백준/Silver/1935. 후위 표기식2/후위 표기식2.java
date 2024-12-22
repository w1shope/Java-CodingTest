import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Map<Character, Double> map = new HashMap<>();
        char c = 'A';
        for (int i = 0; i < n; i++) {
            Double num = Double.parseDouble(br.readLine());
            map.put(c++, num);
        }

        Stack<Double> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                stack.push(map.get(ch));
            } else {
                Double num1 = stack.pop();
                Double num2 = stack.pop();
                Double result = calculate(num2, num1, ch);
                stack.push(result);
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }

    static Double calculate(Double a, Double b, char ch) {
        if (ch == '+') {
            return a + b;
        } else if (ch == '-') {
            return a - b;
        } else if (ch == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }
}