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

            int diff = Math.abs(inputs[0].length() - inputs[1].length());
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                tmp.append("0");
            }

            StringBuilder a;
            StringBuilder b;
            if (inputs[0].length() > inputs[1].length()) {
                a = new StringBuilder(inputs[0]);
                b = new StringBuilder(tmp + inputs[1]);
            } else {
                a = new StringBuilder(tmp + inputs[0]);
                b = new StringBuilder(inputs[1]);
            }

            a = a.reverse();
            b = b.reverse();

            boolean isUp = false;
            StringBuilder added = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                int add = (a.charAt(i) - '0') + (b.charAt(i) - '0');
                if (isUp) {
                    add += 1;
                    isUp = false;
                }

                if (add >= 2) {
                    isUp = true;
                    added.append(add - 2);
                } else {
                    added.append(add);
                }
            }

            if (isUp) {
                added.append("1");
            }

            while (added.length() > 1) {
                int lastIdx = added.length() - 1;
                if (added.charAt(lastIdx) == '0') {
                    added.deleteCharAt(lastIdx);
                } else {
                    break;
                }
            }
            sb.append(added.reverse()).append("\n");
        }

        System.out.println(sb);

    }
}