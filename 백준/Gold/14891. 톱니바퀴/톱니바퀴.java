import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int N = 4; // 톱니바퀴 개수
    static List<List<Integer>> gears = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            gears.add(new ArrayList<>());
        }

        // 톱니 정보 저장
        for (int i = 0; i < N; i++) {
            for (char c : br.readLine().toCharArray()) {
                gears.get(i).add(c - '0');
            }
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수
        for (int i = 0; i < k; i++) {
            String[] inputs = br.readLine().split(" ");
            int gearNumber = Integer.parseInt(inputs[0]) - 1; // 회전할 바퀴
            // 회전 방향
            // -1 : 반시계, 1 : 시계
            int rotation = Integer.parseInt(inputs[1]);
            rotate(gearNumber, rotation);
        }

        // 12시 방향의 값을 기준으로 결과를 계산한다.
        int sum = 0;
        for (int i = 0; i < N; i++) {
            List<Integer> gear = gears.get(i);
            if (gear.get(0) == 1) { // S극
                sum += (int) Math.pow(2, i);
            }
        }

        System.out.println(sum);
    }

    static void rotate(int idx, int rotation) {
        int[] rotationInfo = rotationInfo(idx, rotation);
        for (int i = 0; i < N; i++) {
            List<Integer> gear = gears.get(i);
            if (rotationInfo[i] == -1) { // 반시계
                gear.add(gear.remove(0));
            } else if (rotationInfo[i] == 1) { // 시계
                gear.add(0, gear.remove(7));
            }
        }
    }

    static int[] rotationInfo(int idx, int rotation) {
        // 선택한 기어는 반드시 회전한다.
        // 선택한 기어 원본과 비교하여 인접한 극이 다르다면, 선택한 기어의 반대 방향으로 회전한다.
        // 주변 기어의 주변 기어도 회전 가능 여부를 확인한다.

        int[] info = new int[N];
        info[idx] = rotation;
        List<Integer> gear = gears.get(idx);

        // gear 톱니바퀴의 왼쪽 톱니바퀴를 탐색하며 회전 위치 저장
        int tmpRotation = rotation;
        List<Integer> tmpGear = new ArrayList<>(gear);
        for (int i = idx - 1; i >= 0; i--) {
            List<Integer> adjacent = gears.get(i);
            if (tmpGear.get(6) == adjacent.get(2)) { // 인접한 극이 같은 경우 회전하지 않는다.
                info[i] = 0;
            } else {
                // 인접한 톱니는 반대 방향으로 회전한다.
                info[i] = tmpRotation == 1 ? -1 : 1;
            }

            // 인접한 톱니바퀴가 회전하지 않는다면, 왼쪽 나머지 인접한 바퀴도 회전하지 않는다.
            if (info[i] == 0) {
                break;
            }

            // 현재 바퀴가 회전했다면, 회전 정보를 갱신한다.
            tmpRotation = info[i];
            tmpGear = adjacent;
        }

        // idx 기준으로 오른쪽 톱니바퀴를 탐색하며 회전 위치 저장
        tmpRotation = rotation;
        tmpGear = new ArrayList<>(gear);
        for (int i = idx + 1; i < N; i++) {
            List<Integer> adjacent = gears.get(i);
            if (tmpGear.get(2) == adjacent.get(6)) { // 인접한 극이 같을 경우
                info[i] = 0; // 회전하지 않는다.
            } else {
                // 인접한 톱니는 반대 방향으로 회전한다.
                info[i] = tmpRotation == 1 ? -1 : 1;
            }

            // 현재 바퀴가 회전하지 않을경우, 나머지 오른쪽 바퀴도 회전하지 않는다.
            if (info[i] == 0) {
                break;
            }

            // 현재 바퀴가 회전했다면, 회전 정보를 갱신한다.
            tmpRotation = info[i];
            tmpGear = adjacent;
        }

        return info;
    }
}