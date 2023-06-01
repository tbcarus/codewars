package FindOdd;

//Given an array of integers, find the one that appears an odd number of times.
//
//        There will always be only one integer that appears an odd number of times.
//
//        Examples
//        [7] should return 7, because it occurs 1 time (which is odd).
//        [0] should return 0, because it occurs 1 time (which is odd).
//        [1,1,2] should return 2, because it occurs 1 time (which is odd).
//        [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
//        [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {
        Map<Integer, Boolean> map = new HashMap();
        int number = 0;
        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, !map.get(i));
            } else {
                map.put(i, true);
            }
        }
        for(Map.Entry<Integer, Boolean> m : map.entrySet()) {
            if (m.getValue()) {
                number = m.getKey();
            }
        }
        return number;
    }
}
