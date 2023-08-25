class Solution {
    public String solution(String s) {
        String answer = "";

        boolean isUpper = true;
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                answer += " ";
                isUpper = true;
            }
            else {
                if(isUpper)
                    answer += Character.toUpperCase(c);
                else
                    answer += Character.toLowerCase(c);
                isUpper = !isUpper;
            }
        }

        return answer;
    }
}