import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] numbers;
    static int[] printNumbers;
    static boolean[] visited = new boolean[10_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);
        printNumbers = new int[M]; 

        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(numbers);

        recur(0, 0);
    }

    static void recur(int num, int depth) {
        if (depth == M) {
            for (int number : printNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            int number = numbers[i];
            if (!visited[number]) {
                if (num < number) { // 이전에 뽑힌 숫자보다 커야한다.
                    visited[number] = true;
                    printNumbers[depth] = number;
                    recur(number, depth + 1);
                    visited[number] = false;
                }
            }
        }
    }
}