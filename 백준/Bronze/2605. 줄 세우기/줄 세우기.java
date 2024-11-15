import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수
        int[] pickNumbers = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) { // 1번 학생부터 순서대로 뽑은 순서를 저장
            pickNumbers[i] = Integer.parseInt(inputs[i]);
        }

        // 학생들이 밥먹는 순서 저장
        List<Integer> orders = new LinkedList<>();
        orders.add(1); // 1번 학생은 순서 상관 없이가장 먼저 먹는다.
        for (int i = 1; i < n; i++) {
            // 뽑은 종이 번호에 따라 앞으로 이동 가능
            int pickNumber = pickNumbers[i];
            orders.add(orders.size() - pickNumber, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int studentNumber : orders) {
            sb.append(studentNumber).append(" ");
        }
        System.out.println(sb);
    }
}