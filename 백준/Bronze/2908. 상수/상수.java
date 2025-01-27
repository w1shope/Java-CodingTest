import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        sb = sb.reverse();

        String[] split = sb.toString().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        System.out.println(a > b ? a : b);
    }
}