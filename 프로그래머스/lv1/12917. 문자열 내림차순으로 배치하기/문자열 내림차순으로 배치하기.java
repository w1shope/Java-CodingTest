class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();
        s.chars().boxed().sorted((n1, n2) -> n2 - n1).forEach(num -> sb.append((char) num.intValue()));
        return sb.toString();
    }
}