import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] arr;
    private static int[] mistake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        mistake = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(input[i - 1]);

        setMistakeCount();

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            sb.append(getMistakeCount(x, y) + "\n");
        }

        System.out.println(sb);
    }

    private static void setMistakeCount() {
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                mistake[i] = ++count;
            else
                mistake[i] = count;
        }
        mistake[mistake.length - 1] = count;
    }

    private static int getMistakeCount(int x, int y) {
        if (x == y)
            return 0;
        return mistake[y - 1] - mistake[x - 1];
    }
}