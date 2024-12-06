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

        char[] cArr = br.readLine().toCharArray();

        // 알파벳에 대응되는 숫자 저장
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((char) ('A' + i), Integer.parseInt(br.readLine()));
        }

        // 후위 연산 진행
        Stack<Double> stack = new Stack<>();
        for (char c : cArr) {
            if (c >= 'A' && c <= 'Z') { // 피연산자라면
                stack.push((double) map.get(c));
            } else { // 연산자라면
                double num1 = stack.pop();
                double num2 = stack.pop();
                if (c == '+') {
                    stack.push(num2 + num1);
                } else if (c == '-') {
                    stack.push(num2 - num1);
                } else if (c == '/') {
                    stack.push(num2 / num1);
                } else if (c == '*') {
                    stack.push(num2 * num1);
                }
            }
        }

        // 마지막 원소가 계산 결과임
        System.out.println(String.format("%.2f", stack.pop()));
    }

}