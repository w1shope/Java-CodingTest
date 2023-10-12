import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String first = input.charAt(0) + "";
            String last = input.charAt(input.length() - 1) + "";
            sb.append(first + last + "\n");
        }
        System.out.println(sb);
    }
}