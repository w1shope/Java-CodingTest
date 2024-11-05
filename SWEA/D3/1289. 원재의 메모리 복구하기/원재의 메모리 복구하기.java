import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static char[] original;
    static char[] newArr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            init(br.readLine().toCharArray());

            sb.append(answer() + "\n");
        }

        System.out.println(sb);


    }

    static void init(char[] arr) {
        N = arr.length;
        original = new char[N];
        for (int i = 0; i < N; i++) {
            original[i] = arr[i];
        }

        newArr = new char[N];
        for (int i = 0; i < N; i++) {
            newArr[i] = '0';
        }
    }

    static int answer() {
        int changeCount = 0;
        for (int i = 0; i < N; i++) {
            if (original[i] == newArr[i]) { // 비트가 같다면
                continue;
            }
            swap(original[i], i);
            changeCount++;
        }
        return changeCount;
    }

    static void swap(char c, int startIdx) {
        for (int i = startIdx; i < N; i++) {
            newArr[i] = c;
        }
    }
}