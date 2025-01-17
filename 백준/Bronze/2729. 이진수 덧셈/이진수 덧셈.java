import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");

            BigInteger b1 = new BigInteger(inputs[0], 2);
            BigInteger b2 = new BigInteger(inputs[1], 2);

            sb.append(b1.add(b2).toString(2)).append("\n");
        }

        System.out.println(sb);
    }
}