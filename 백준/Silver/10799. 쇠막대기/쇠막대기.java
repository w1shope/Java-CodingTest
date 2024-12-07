import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 0;
        char prev = ' ';
        for (char now : input.toCharArray()) {
            if (now == '(') {
                stack.push('(');
                prev = now;
            } else {
                stack.pop();
                if (prev == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
            prev = now;
        }

        System.out.println(result);
    }
}