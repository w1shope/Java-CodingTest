import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(bfs(sc.nextInt()));
    }

    static int bfs(int money) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{money, 0}); // {남은 잔액, 동전 개수}
        boolean[] visited = new boolean[money + 1];
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int remainMoney = poll[0];
            int exchangeCoin = poll[1];
            if (remainMoney == 0) {
                return exchangeCoin;
            }

            // 5원으로 거슬러 준다
            if (remainMoney - 5 >= 0 && !visited[remainMoney - 5]) {
                que.offer(new int[]{remainMoney - 5, exchangeCoin + 1});
                visited[remainMoney - 5] = true;
            }
            // 2원으로 거슬러 준다
            if (remainMoney - 2 >= 0 && !visited[remainMoney - 2]) {
                que.offer(new int[]{remainMoney - 2, exchangeCoin + 1});
                visited[remainMoney - 2] = true;
            }
        }

        return -1;
    }
}