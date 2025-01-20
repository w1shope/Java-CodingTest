import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {

    static List<Stack<Character>> stacks = new ArrayList<>();
    static Map<Character, Integer> quackMap = Map.of(
            'q', 0,
            'u', 1,
            'a', 2,
            'c', 3,
            'k', 4
    );
    static char[] quacks = new char[]{'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char c : br.readLine().toCharArray()) {
            boolean isNewQuack = true;
            for (int i = 0; i < stacks.size(); i++) {
                Stack<Character> stack = stacks.get(i);

                int idx = quackMap.get(c) - 1;
                if (idx < 0) {
                    idx += 5;
                }

                if (stack.peek() == quacks[idx]) {
                    stack.push(c);
                    isNewQuack = false;
                    break;
                }
            }

            if (isNewQuack) {
                Stack<Character> stack = new Stack<>();
                stack.push('q');
                stacks.add(stack);
            }
        }

        int count = 0;
        char prev = 'q';
        for (Stack<Character> stack : stacks) {
            boolean isQuack = true;
            while (!stack.isEmpty()) {
                int idx = quackMap.get(prev) - 1;
                if (idx < 0) {
                    idx += 5;
                }

                char pop = stack.pop();
                if (pop != quacks[idx]) {
                    isQuack = false;
                    break;
                }

                prev = pop;
            }

            if (isQuack) {
                count++;
            }
        }

        if (count != stacks.size()) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}