import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            String[] splits = input.split(" ");
            s = splits[0];
            t = splits[1];

            sb.append(isSubString() ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }

    static boolean isSubString() {
        for (int i = 0; i < s.length(); i++) {
            int idx = t.indexOf(s.charAt(i) + "");
            if (idx == -1) { // 부분 문자열을 만들 수 없다.
                return false;
            }
            t = t.substring(idx + 1);
        }
        return true;
    }
}