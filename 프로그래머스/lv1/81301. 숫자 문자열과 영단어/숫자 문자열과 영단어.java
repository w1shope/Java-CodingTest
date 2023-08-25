class Solution {
    private static final String[] words = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    public int solution(String s) {
        for(int num = 0; num <= 9; num++) {
            if(s.contains(words[num]))
                s = s.replace(words[num], String.valueOf(num));
        }

        return Integer.parseInt(s);
    }
}