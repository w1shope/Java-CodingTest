import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int num : arr) {
            if (st.isEmpty() || st.peek() != num) {
                st.push(num);
            }
        }

        int[] result = new int[st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            result[i--] = st.pop();
        }

        return result;
    }
}