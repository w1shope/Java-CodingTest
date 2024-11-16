import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, L; // 신호등 개수, 도로 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        L = Integer.parseInt(inputs[1]);

        int position = 0; // 현재 위치
        int time = 0; // 현재 시간

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int D = Integer.parseInt(inputs[0]); // 신호등 위치
            int R = Integer.parseInt(inputs[1]); // 빨간불 지속 시간
            int G = Integer.parseInt(inputs[2]); // 초록불 지속 시간

            time += D - position; // 현재 위치에서 신호등까지 이동
            position = D; // 신호등이 현재 위치

            int gap = time % (R + G);
            if (gap < R) { // 현재 빨간불
                time += R - gap; // 기다린 시간
            }
        }

        // 마지막 신호등 위치에서 도착 지점까지 바로 이동
        System.out.println(time + (L - position));
    }
}