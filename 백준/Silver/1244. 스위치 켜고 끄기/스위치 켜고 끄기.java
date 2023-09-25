import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        light = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            light[i] = Integer.parseInt(input[i]);

        int personNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < personNum; i++) {
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);
            changeSwitch(gender, num);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 20) {
                sb.append("\n");
                count = 0;
            }
            sb.append(light[i] + " ");
            count++;
        }
        System.out.println(sb);
    }

    private static void changeSwitch(int gender, int num) {
        switch (gender) {
            case 1:
                for (int i = num - 1; i < light.length; i += num)
                    light[i] = light[i] == 1 ? 0 : 1;
                break;
            default:
                light[num - 1] = light[num - 1] == 1 ? 0 : 1;
                for (int i = 1; ; i++) {
                    if ((num - 1) - i < 0 || (num - 1) + i >= light.length)
                        return;
                    int num1 = (num - 1) - i;
                    int num2 = (num - 1) + i;
                    if (light[num1] != light[num2]) {
                        return;
                    } else {
                        light[num1] = light[num1] == 1 ? 0 : 1;
                        light[num2] = light[num2] == 1 ? 0 : 1;
                    }
                }
        }
    }
}
