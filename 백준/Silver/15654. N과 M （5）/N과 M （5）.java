import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] numbers; // 존재하는 숫자
    static int[] printNumbers; // 출력할 숫자
    static boolean[] visited = new boolean[10_001]; // 1 ~ 10_000

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);
        printNumbers = new int[M];

        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(numbers); // 오름차순 정렬

        recur(0);

        System.out.println(sb.toString());
    }

    static void recur(int depth) {
        if (depth == M) { // M개의 숫자를 모두 선택한 경우, 선택한 숫자들을 출력한다.
            for (int i = 0; i < M; i++) {
                sb.append(printNumbers[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) { // 초기에 입력받은 숫자들 중에서 선택한다.
            int number = numbers[i];
            if (!visited[number]) { // 뽑은 숫자를 방문하지 않은 경우에만 실행한다.
                visited[number] = true; // 방문 처리
                printNumbers[depth] = number; // 뽑은 숫자를 출력하기 위해 저장
                recur(depth + 1); // 뽑은 숫자 개수 + 1
                visited[number] = false;
            }
        }
    }
}