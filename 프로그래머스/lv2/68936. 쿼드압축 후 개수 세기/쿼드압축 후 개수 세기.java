class Solution {
    private static int zero;
    private static int one;

    public int[] solution(int[][] arr) {
        int length = arr.length;
        traverse(arr, 0, 0, length);
        return new int[]{zero, one};
    }

    private void traverse(int[][] arr, int x, int y, int length) {
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (arr[y][x] != arr[i][j]) {
                    length /= 2;
                    traverse(arr, x, y, length);
                    traverse(arr, x + length, y, length);
                    traverse(arr, x, y + length, length);
                    traverse(arr, x + length, y + length, length);
                    return;
                }
            }
        }
        if(arr[y][x] == 0)
            zero++;
        else
            one++;
    }
}