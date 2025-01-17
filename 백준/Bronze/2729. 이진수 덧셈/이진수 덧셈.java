import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            int length = Math.abs(inputs[0].length() - inputs[1].length());
            if (inputs[0].length() > inputs[1].length()) {
                for (int i = 0; i < length; i++) {
                    b.append("0");
                }
            } else {
                for (int i = 0; i < length; i++) {
                    a.append("0");
                }
            }
            a.append(inputs[0]);
            b.append(inputs[1]);

            StringBuilder result = new StringBuilder();
            int carry = 0;
            for (int i = a.length() - 1; i >= 0; i--) {
                int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
                result.append(sum % 2);
                carry = sum / 2;
            }

            if (carry > 0) {
                result.append("1");
            }

            StringBuilder reverse = result.reverse();
            while (result.length() > 1) {
                if (reverse.charAt(0) == '1') {
                    break;
                }
                reverse.deleteCharAt(0);
            }

            sb.append(reverse).append("\n");
        }

        System.out.println(sb);
    }
}