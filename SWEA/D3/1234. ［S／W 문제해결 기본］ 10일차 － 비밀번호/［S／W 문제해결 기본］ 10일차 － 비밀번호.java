import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            String[] inputArr = br.readLine().split(" ");
            sb.append("#" + t + " ").append(answer(inputArr[1]) + "\n");
        }

        System.out.println(sb);
    }

    static String answer(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder word = new StringBuilder();
        for (char c : stack) {
            word.append(c);
        }
        return word.toString();
    }

}