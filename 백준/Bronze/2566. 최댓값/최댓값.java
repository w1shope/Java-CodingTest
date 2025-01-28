import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return b[2] - a[2];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                pq.offer(new int[]{i, j, Integer.parseInt(st.nextToken())});
            }
        }

        int[] max = pq.poll();
        System.out.println(max[2]);
        System.out.println(max[0] + " " + max[1]);
    }

}