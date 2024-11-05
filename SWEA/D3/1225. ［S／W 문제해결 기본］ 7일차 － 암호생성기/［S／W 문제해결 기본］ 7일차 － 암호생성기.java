import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    static Deque<Integer> dq;
    static int SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            br.readLine();

            String[] inputArr = br.readLine().split(" ");
            dq = new ArrayDeque<>();
            for (int i = 0; i < SIZE; i++) {
                dq.offer(Integer.parseInt(inputArr[i]));
            }
            sb.append(answer() + "\n");
        }

        System.out.println(sb);
    }

    static String answer() {
        int minus = 1;
        while (true) {
            if (dq.peekLast() <= 0) { // 종료조건
                dq.pollLast();
                dq.offer(0);
                return getStringResult();
            }
            dq.offer(dq.poll() - minus++);
            if (minus > 5) {
                minus = 1;
            }
        }
    }

    static String getStringResult() {
        StringBuilder result = new StringBuilder();
        for(int value : dq) {
            result.append(value + " ");
        }
        return result.toString();
    }

}