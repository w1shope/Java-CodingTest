import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] inputArr = getInput(br);
            int N = inputArr[0];
            int M = inputArr[1];
            int[] arrA = getInput(br);
            int[] arrB = getInput(br);
            Arrays.sort(arrB);

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arrA[i] > arrB[j]) {
                        answer++;
                    } else {
                        break;
                    }
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    static int[] getInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}