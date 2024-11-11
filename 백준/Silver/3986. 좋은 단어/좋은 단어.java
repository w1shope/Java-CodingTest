import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N-- > 0) {
            char[] arr = br.readLine().toCharArray();
            stack = new Stack<>();
            if (isGoodWord(arr)) {
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean isGoodWord(char[] arr) {
        if (arr.length % 2 != 0) { // 홀수개의 문자
            return false;
        }

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        return stack.isEmpty();
    }
}