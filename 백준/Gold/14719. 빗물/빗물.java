import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int width, height;
    static int[] arr;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        height = Integer.parseInt(inputs[0]);
        width = Integer.parseInt(inputs[1]);

        arr = new int[width];

        inputs = br.readLine().split(" ");
        for (int x = 0; x < width; x++) {
            arr[x] = Integer.parseInt(inputs[x]);
        }

        for (int x = 1; x < width - 1; x++) {
            int left = maxHeight(0, x - 1);
            int right = maxHeight(x + 1, width - 1);
            int min = Math.min(left, right);

            if (min - arr[x] > 0) {
                sum += min - arr[x];
            }
        }

        System.out.println(sum);
    }

    static int maxHeight(int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int x = left; x <= right; x++) {
            max = Math.max(max, arr[x]);
        }
        return max;
    }
}