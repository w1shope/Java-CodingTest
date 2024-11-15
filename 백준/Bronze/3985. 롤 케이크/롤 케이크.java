import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1]; // 1 ~ n

        int k = Integer.parseInt(br.readLine());
        int[] maybe = new int[k + 1];
        int[] real = new int[k + 1];
        int maybePerson = -1;
        int maxCount = -1;
        for (int i = 1; i <= k; i++) {
            String[] inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int e = Integer.parseInt(inputs[1]);
            maybe[i] = e - s + 1;
            if (maxCount < maybe[i]) {
                maxCount = maybe[i];
                maybePerson = i;
            }
            for (int j = s; j <= e; j++) {
                if (arr[j] == 0) {
                    arr[j] = i;
                    real[i]++;
                }
            }
        }

        int realPerson = 1;
        int realCount = real[1];
        for (int i = 2; i <= k; i++) {
            if (realCount < real[i]) {
                realCount = real[i];
                realPerson = i;
            }
        }

        System.out.println(maybePerson + "\n" + realPerson);
    }
}