import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] rows;
    static int[] cols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 열 개수
        M = Integer.parseInt(inputs[1]); // 행 개수
        rows = new int[M + 1];
        cols = new int[N + 1];

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            inputs = br.readLine().split(" ");
            int rowOrCol = Integer.parseInt(inputs[0]);
            int idx = Integer.parseInt(inputs[1]);
            if (rowOrCol == 0) { // 행 자르기
                rows[idx] = 1;
            } else { // 열 자르기
                cols[idx] = 1;
            }
        }

        // 마지막 행, 열을 포함한 종이 크기를 고려한다.
        rows[M] = 1;
        cols[N] = 1;

        System.out.println(answer());
    }

    static int answer() {
        int answer = 0;

        int prevRowIdx = 0;
        for (int nowRowIdx = 0; nowRowIdx <= M; nowRowIdx++) {
            if (rows[nowRowIdx] == 0) { // 행 자르기 기준선이 아니라면
                continue;
            }

            int prevColIdx = 0;
            for (int nowColIdx = 0; nowColIdx < cols.length; nowColIdx++) {
                if (cols[nowColIdx] == 0) { // 열 자르기 기준선이 아니라면
                    continue;
                }

                // 이전 선(행, 열)과 현재 선(행, 열)로 종이를 만들어서 크기를 구한 후, 
                // 크기를 비교하여 갱신한다.
                answer = Math.max(answer, getArea(prevRowIdx, nowRowIdx, prevColIdx, nowColIdx));
                prevColIdx = nowColIdx;
            }
            prevRowIdx = nowRowIdx;
        }

        return answer;
    }

    static int getArea(int startRowIdx, int endRowIdx, int startColIdx, int endColIdx) {
        return (endRowIdx - startRowIdx) * (endColIdx - startColIdx);
    }

}