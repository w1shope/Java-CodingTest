import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int[] arr = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            int val = Integer.parseInt(inputs[i]);
            sb.append(arr[i] - val).append(" ");
        }

        System.out.println(sb);
    }
}