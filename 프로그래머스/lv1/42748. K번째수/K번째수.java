import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] result = new int[commands.length];

        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0] - 1;
            int j = commands[t][1] - 1;
            int k = commands[t][2] - 1;

            int[] sliceArr = Arrays.copyOfRange(array, i, j + 1);
            Arrays.sort(sliceArr);
            result[t] = sliceArr[k];
        }

        return result;
    }
}