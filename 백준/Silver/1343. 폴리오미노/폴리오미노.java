import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), "\\.+", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.contains(".")) {
                sb.append(token);
                continue;
            }

            int length = token.length();
            while (true) {
                if (length == 0)
                    break;
                if (length % 2 != 0) {
                    System.out.println(-1);
                    return;
                } else {
                    if (length >= 4) {
                        length -= 4;
                        sb.append("AAAA");
                    } else if (length >= 2) {
                        length -= 2;
                        sb.append("BB");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}