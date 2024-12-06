import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int openCnt = 0;
            boolean flag = true;

            String input = br.readLine();
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    openCnt++;
                } else {
                    openCnt--;
                    if (openCnt < 0) {
                        flag = false;
                        break;
                    }
                }
            }

            if (openCnt > 0 || !flag) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}