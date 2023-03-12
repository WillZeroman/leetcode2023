package io.github.willzeroman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 */
public class FindLongestSubarray {
    public String[] findLongestSubarray(String[] array) {
        int[] preSum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            preSum[i] = Character.isDigit(array[i].charAt(0)) ? 1 : -1;
        }
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1];
        }
        System.out.println(Arrays.toString(preSum));
        //<value,Index>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int startIndex = array.length;
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                int left = map.get(preSum[i]);
                int len = i - left;
                if (ans < len) {
                    ans = len;
                    startIndex = left + 1;
                } else if (ans == len) {
                    startIndex = Math.min(startIndex, left + 1);
                }
            } else {
                map.put(preSum[i], i);
            }
        }

        return ans != 0 ? Arrays.copyOfRange(array, startIndex, startIndex + ans) : new String[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindLongestSubarray()
                .findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
        System.out.println(Arrays.toString(new FindLongestSubarray()
                .findLongestSubarray(new String[]{"A", "M"})));

    }
}
