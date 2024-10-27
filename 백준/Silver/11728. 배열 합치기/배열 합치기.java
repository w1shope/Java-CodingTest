import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        M = inputArr[1];

        int[] arrA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] arrB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[] answer = new int[N + M];
        int pA = 0, pB = 0; // 배열 A와 B를 가리키는 포인터
        int answerIdx = 0; // 출력할 배열의 인덱스
        while (pA < N && pB < M) {
            if (arrA[pA] > arrB[pB]) {
                answer[answerIdx++] = arrB[pB++];
            } else {
                answer[answerIdx++] = arrA[pA++];
            }
        }

        if (pA == N) {
            for (int i = pB; i < M; i++) {
                answer[answerIdx++] = arrB[i];
            }
        } else {
            for (int i = pA; i < N; i++) {
                answer[answerIdx++] = arrA[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num + " ");
        }

        System.out.println(sb);
    }
}