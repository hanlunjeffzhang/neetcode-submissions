class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (!counter.containsKey(hand[i])) {
                counter.put(hand[i], 0);
            }
            counter.put(hand[i], counter.get(hand[i]) + 1);
        }
        while (!counter.isEmpty()) {
            int start = counter.firstKey();
            int width = counter.get(start);

            for (int i = start; i < groupSize + start; i++) {
                if (!counter.containsKey(i) || counter.get(i) < width) {
                    return false;
                }

                int afterDeduction = counter.get(i) - width;
                if (afterDeduction == 0) {
                    counter.remove(i);
                } else {
                    counter.put(i, afterDeduction);
                }
            }
        }
        return true;
    }
}
