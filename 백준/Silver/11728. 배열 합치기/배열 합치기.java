import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static Queue<Integer> que = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (String num : br.readLine().split(" "))
            que.offer(Integer.parseInt(num));

        for (String num : br.readLine().split(" "))
            que.offer(Integer.parseInt(num));
        
        while (!que.isEmpty())
            sb.append(que.poll() + " ");

        System.out.println(sb);
    }
}