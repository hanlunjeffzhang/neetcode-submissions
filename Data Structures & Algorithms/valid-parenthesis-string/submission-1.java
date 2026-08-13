class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '(':
                    min++;
                    max++;
                    break;
                case ')':
                    min--;
                    max--;
                    break;
                default: // "*"
                    max++;
                    min = Math.max(0, min - 1);
                    break;
            }
            if (max < 0) {
                return false;
            }
        }
        return 0 <= max && 0 >= min;
    }
}
