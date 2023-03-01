package io.github.willzeroman;

import java.util.HashMap;
import java.util.Map;

public class LongestWPI {
    public int longestWPI(int[] hours) {
        if (hours == null) {
            return 0;
        }
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWPI().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(new LongestWPI().longestWPI(new int[]{6, 9, 9}));
        System.out.println(new LongestWPI().longestWPI(new int[]{9}));
    }
}
