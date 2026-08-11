class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                String sub = s.substring(j - 1, i);
                if (canSegment[j - 1] && wordSet.contains(sub)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
}
