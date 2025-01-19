import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int[] nums = {4, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(333_334);

        String input = br.readLine();
        boolean first = true; 

        for (char c : input.toCharArray()) {
            calculate(sb, c - '0', first);
            first = false;
        }

        System.out.println(sb);
    }

    static void calculate(StringBuilder sb, int num, boolean first) {
        for (int i = 0; i < 3; i++) {
            if (num - nums[i] >= 0) {
                num -= nums[i];
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        if (first) {
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() == 0) {
                sb.append(0); 
            }
        }
    }
}