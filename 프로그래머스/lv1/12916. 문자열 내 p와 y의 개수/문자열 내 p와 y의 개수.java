class Solution {
    boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.toUpperCase(c) == 'P')
                count++;
            else if (Character.toUpperCase(c) == 'Y')
                count--;
        }

        if (count == 0)
            return true;
        return false;
    }
}