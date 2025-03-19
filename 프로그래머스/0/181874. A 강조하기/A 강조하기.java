class Solution {
    public String solution(String str) {
        char[] ch = str.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                ch[i] = Character.toLowerCase(ch[i]);
            }
            if (ch[i] == 'a') ch[i] = 'A';            
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
}