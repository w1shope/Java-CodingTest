import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            for (String input : br.readLine().split(" ")) {
                sb.append(binarySearch(arr, Integer.parseInt(input)) ? 1 : 0).append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean binarySearch(int[] arr, int find) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (find > arr[mid]) {
                left = mid + 1;
            } else if (find < arr[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}