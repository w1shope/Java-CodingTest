import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        String[] input = br.readLine().split(" ");
        int[] switchs = new int[n]; // 스위치 정보
        for (int i = 0; i < n; i++)
            switchs[i] = Integer.parseInt(input[i]);

        int persons = Integer.parseInt(br.readLine());
        for (int i = 0; i < persons; i++) {
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int switchNum = Integer.parseInt(input[1]) - 1;

            if (gender == 1)
                stateChangeByMan(switchs, switchNum);
            else
                stateChangeByWomen(switchs, switchNum);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 20) {
                sb.append("\n");
                count = 0;
            }
            sb.append(switchs[i] + " ");
            count++;
        }

        System.out.println(sb);
    }

    // 남자일 경우
    private static void stateChangeByMan(int[] switchs, int switchNum) {
        for (int i = switchNum; i < switchs.length; i += switchNum + 1) {
            if (switchs[i] == 1)
                switchs[i] = 0;
            else
                switchs[i] = 1;
        }
    }

    // 여자일 경우
    private static void stateChangeByWomen(int[] switchs, int switchNum) {
        int count = 1;
        while (true) {
            int leftSwitchNum = switchNum - count;
            int rightSwitchNum = switchNum + count;

            if (leftSwitchNum < 0 || rightSwitchNum >= switchs.length)
                break;

            if (switchs[leftSwitchNum] == switchs[rightSwitchNum]) {
                stateChange(switchs, leftSwitchNum);
                stateChange(switchs, rightSwitchNum);
            } else
                break;

            count += 1;
        }

        stateChange(switchs, switchNum);
    }

    // 전구 상태 변경 0 <-> 1
    private static void stateChange(int[] switchs, int switchNum) {
        if (switchs[switchNum] == 1)
            switchs[switchNum] = 0;
        else
            switchs[switchNum] = 1;
    }
}