package io.github.willzeroman;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 */
public class MinSubarray {
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x += nums[i];
            x %= p;
        }
        if (x == 0) {
            return 0;
        }
        // <value,index>
        Map<Integer, Integer> map = new HashMap<>();
        int y = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(y, i);
            y = (y + nums[i]) % p;
            if (map.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - map.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubarray().minSubarray(new int[]{3, 1, 4, 2}, 6));
    }
}
