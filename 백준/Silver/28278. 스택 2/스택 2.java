import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String input = br.readLine();

            if (input.startsWith("1")) {
                stack.push(input.split(" ")[1]);
            } else if (input.startsWith("2")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            } else if (input.startsWith("3")) {
                sb.append(stack.size()).append("\n");
            } else if (input.startsWith("4")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}