import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 저장
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        // 1 ~ N 원소값 저장
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i + "");
        }

        int rotateCount = 0;

        // m번만큼 반복하며, 원하는 숫자를 찾는다.
        for (String findNumber : br.readLine().split(" ")) {

            // 왼쪽으로 회전하였을 때, 원하는 숫자를 찾기 위한 회전 횟수
            int leftRotateCount = 0;
            for (String number : dq) {
                if (number.equals(findNumber)) {
                    break;
                }
                leftRotateCount++;
            }

            // 오른쪽으로 회전하였을 때, 원하는 숫자를 찾기 위한 회전 횟수
            int rightRotateCount = dq.size() - leftRotateCount;
            
            if (leftRotateCount < rightRotateCount) { // 왼쪽으로 회전
                for (int i = 0; i < leftRotateCount; i++) {
                    dq.offer(dq.poll());
                }
                rotateCount += leftRotateCount;
            } else { // 오른쪽으로 회전
                for (int i = 0; i < rightRotateCount; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                rotateCount += rightRotateCount;
            }

            dq.poll(); // 첫 번째 원소 추출
        }

        System.out.println(rotateCount);
    }
}