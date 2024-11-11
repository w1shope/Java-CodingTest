import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    static int N;
    static Map<Character, Double> map = new HashMap<>();
    static Stack<Double> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] cArr = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }

        for (char c : cArr) {
            if (map.containsKey(c)) { // 숫자라면
                stack.push(map.get(c));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(getCalculateResult(num2, num1, c));
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));

    }

    static double getCalculateResult(double num1, double num2, char operator) {
        switch (operator) {
            case '/':
                return num1 / num2;
            case '*':
                return num1 * num2;
            case '-':
                return num1 - num2;
            case '+':
                return num1 + num2;
        }
        return -1;
    }
}