class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] combinationsAtIndex = new int[s.length() + 1];
        combinationsAtIndex[0] = 1;
        combinationsAtIndex[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int chIndex = i - 1;
            char thisCh = s.charAt(chIndex);
            char prevCh = s.charAt(chIndex - 1);

            if (thisCh != '0') {
                combinationsAtIndex[i] += combinationsAtIndex[i - 1];
            }

            int combined = Integer.parseInt("" + prevCh + "" + thisCh);
            if (combined <= 26 && combined >= 10) {
                combinationsAtIndex[i] += combinationsAtIndex[i - 2];
            }
        }


        return combinationsAtIndex[s.length()];
     }
}
