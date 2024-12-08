import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    static List<String> list = new ArrayList<>();
    static List<Integer> open = new ArrayList<>();
    static List<Integer> close = new ArrayList<>();

    static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();

        // 여는 괄호와 닫는 괄호 쌍 인덱스 저장
        getPairs(cArr);

        // 첫 번째 괄호 쌍 제거
        // 첫 번째 괄호 쌍 그대로 둔 상태에서, 두 번째 괄호 쌍 제거
        // 첫 번째와 두 번째 괄호 쌍 그대로 둔 상태에서, 세 번째 괄호 쌍 제거
        // ...
        for (int i = 0; i < open.size(); i++) {
            dfs(cArr, i);
        }

        // 괄호를 제거했다는 의미로 배열에 "."를 저장했으므로
        // "."를 제외한 문자열을 생성하여 result에 저장
        // result는 TreeSet이므로 오름차순 정렬이 된다.
        for (int i = 0; i < list.size(); i++) {
            result.add(removeDot(list.get(i).toCharArray()));
        }

        // 괄호 싸응ㄹ 제거해서 나올 수 있는 서로 다른 식을 사전순으로 출력
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static void getPairs(char[] arr) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> openList = new ArrayList<>();
        List<int[]> closeList = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                int[] info = new int[]{count++, i};
                stack.push(info);
                openList.add(info);
            } else if (arr[i] == ')') {
                int[] pop = stack.pop();
                closeList.add(new int[]{pop[0], i});
            }
        }

        Collections.sort(openList, (a, b) -> a[0] - b[0]);
        Collections.sort(closeList, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < openList.size(); i++) {
            open.add(openList.get(i)[1]);
            close.add(closeList.get(i)[1]);
        }
    }

    static String removeDot(char[] arr) {
        StringBuilder buffer = new StringBuilder();
        for (char c : arr) {
            if (c != '.') {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    static void dfs(char[] arr, int depth) {
        if (depth >= open.size()) {
            return;
        }

        // cloneArr은 괄호를 제거한 배열
        char[] cloneArr = arr.clone();

        // 쌍이 되는 괄호 추출
        int openIdx = open.get(depth);
        int closeIdx = close.get(depth);

        // 괄호 제거
        cloneArr[openIdx] = '.';
        cloneArr[closeIdx] = '.';
        list.add(String.valueOf(cloneArr));

        // 괄호 제거 or 괄호 제거 X
        dfs(cloneArr, depth + 1); // 현재 depth에 존재하는 괄호를 제거하거나
        dfs(arr, depth + 1); // 현재 depeth에 존재하는 괄호를 제거하지 않거나
    }

}