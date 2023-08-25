class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();

        for(char c : s.toCharArray()) {
            if('a' <= c && c <= 'z') {
                c += n;
                sb.appendCodePoint('a' + (c-'a') % 26);
            } else if('A' <= c && c <= 'Z') {
                c += n;
                sb.appendCodePoint('A' + (c-'A') % 26);
            } else
                sb.append(c);
        }

        return sb.toString();
    }
}