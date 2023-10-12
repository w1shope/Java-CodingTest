import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String input = br.readLine();
        for (int i = 0; i <= input.length() / 10; i++) {
            if (10 * i + 10 < input.length())
                sb.append(input.substring(10 * i, (10 * i) + 10) + "\n");
            else
                sb.append(input.substring(10 * i, input.length()) + "\n");
        }
        System.out.println(sb);
    }
}