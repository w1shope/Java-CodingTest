import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (char c : br.readLine().toCharArray()) {
            sb.append(c);
            count++;
            if (count % 10 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}