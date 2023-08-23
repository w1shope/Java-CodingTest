class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];

        int width = (brown - 2) / 2;
        int height = 3;
        while (true) {
            if ((width - 2) * (height - 2) != yellow) {
                width -= 1;
                height += 1;
            } else {
                return new int[]{width, height};
            }
        }
    }
}