import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int N, M;
    static Queue<Integer> rowsQue = new LinkedList<>(); // 0
    static Queue<Integer> colsQue = new LinkedList<>(); // 1
    static PriorityQueue<Integer> rowsPr = new PriorityQueue<>();
    static PriorityQueue<Integer> colsPr = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 열 개수
        M = Integer.parseInt(inputs[1]); // 행 개수

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            if (a == 0) {
                rowsPr.offer(b);
            } else {
                colsPr.offer(b);
            }
        }

        while (!rowsPr.isEmpty()) {
            rowsQue.offer(rowsPr.poll());
        }
        rowsQue.offer(M);

        while (!colsPr.isEmpty()) {
            colsQue.offer(colsPr.poll());
        }
        colsQue.offer(N);

        System.out.println(answer());
    }

    static int answer() {
        int answer = 0;
        int prevRowIdx = 0;
        while (!rowsQue.isEmpty()) {
            int nowRowIdx = rowsQue.poll();
            int prevColIdx = 0;
            for (int i = 0; i < colsQue.size(); i++) {
                int nowColIdx = colsQue.poll();
                answer = Math.max(answer, getArea(prevRowIdx, nowRowIdx, prevColIdx, nowColIdx));
                colsQue.offer(nowColIdx);
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