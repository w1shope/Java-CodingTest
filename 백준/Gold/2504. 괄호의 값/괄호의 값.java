import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> st = new Stack<>();
        boolean flag = false;
        int answer = 0;
        int cnt = 1;

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '(') {
                st.push(cur);
                cnt *= 2;
            } else if (cur == '[') {
                st.push(cur);
                cnt *= 3;
            } else {
                if (st.isEmpty()) {
                    flag = true;
                    break;
                }

                if (cur == ')') {
                    if (st.peek() != '(') {
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        answer += cnt;
                    }
                    cnt /= 2;
                    st.pop();
                } else if (cur == ']') {
                    if (st.peek() != '[') {
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        answer += cnt;
                    }
                    cnt /= 3;
                    st.pop();
                }
            }
        }

        if (flag || !st.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}