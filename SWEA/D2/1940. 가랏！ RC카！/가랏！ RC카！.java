import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int n = Integer.parseInt(br.readLine()); // 커맨드 개수
            int moveDistance = 0; // 이동 거리
            int speed = 0;
            for (int i = 0; i < n; i++) {
                int[] inputArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                if (inputArr.length == 1) { //현재 속도
                    moveDistance += speed;
                } else {
                    int commandOrder = inputArr[0];
                    int order = inputArr[1];
                    if (commandOrder == 1) { // 가속
                        speed += order;
                        moveDistance += speed;
                    } else { // 감속
                        speed -= order;
                        if (speed < 0) {
                            speed = 0;
                        }
                        moveDistance += speed;
                    }
                }
            }

            sb.append(moveDistance + "\n");
        }

        System.out.println(sb);
    }
}