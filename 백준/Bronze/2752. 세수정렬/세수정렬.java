import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(input[i]);

        Arrays.stream(arr).sorted().forEach(num -> System.out.print(num + " "));
    }
}