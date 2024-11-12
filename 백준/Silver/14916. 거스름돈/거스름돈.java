import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(bfs(n));
    }

    static int bfs(int money) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{money, 0}); // {남은 돈, 동전 개수}
        boolean[] visited = new boolean[money + 1];
        visited[money] = true;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            if (poll[0] == 0) { // 남은 돈이 0원이라면
                return poll[1]; // 동전 개수 반환
            }

            // 5원 이상 남았다면
            if (poll[0] - 5 >= 0 && !visited[poll[0] - 5]) {
                que.offer(new int[]{poll[0] - 5, poll[1] + 1});
                visited[poll[0] - 5] = true;
            }

            // 2원 이상 남았다면
            if (poll[0] - 2 >= 0 && !visited[poll[0] - 2]) {
                que.offer(new int[]{poll[0] - 2, poll[1] + 1});
                visited[poll[0] - 2] = true;
            }

        }
        return -1;
    }
}