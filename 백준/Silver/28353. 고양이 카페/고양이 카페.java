import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, K;
    static int[] catWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        K = inputArr[1];
        catWeights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(catWeights);

        int s = 0, e = N - 1;
        int answer = 0;
        while (s < e) {
            int weightSum = catWeights[s] + catWeights[e];
            if (weightSum <= K) {
                answer++;
                s++;
                e--;
            } else {
                e--;
            }
        }

        System.out.println(answer);
    }
}