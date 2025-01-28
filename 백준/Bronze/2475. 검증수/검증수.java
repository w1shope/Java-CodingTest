import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (String input : br.readLine().split(" ")) {
            sum += (int) Math.pow(Integer.parseInt(input), 2);
        }

        System.out.println(sum % 10);
    }
}