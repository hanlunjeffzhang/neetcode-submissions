/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            starts[i] = interval.start;
            ends[i] = interval.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int endIndex = 0;
        int count = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (starts[i] < ends[endIndex]) {
                count++;
            } else {
                endIndex++;
            }
        }

        return count;
    }
}
