class Solution {
    public int[] solution(int brown, int yellow) {
        int width = (brown - 2) / 2;
        int height = 3;
        while(true) {
            if((width - 2) * (height - 2) == yellow)
                return new int[]{width, height};
            width -= 1;
            height += 1;
        }
    }
}