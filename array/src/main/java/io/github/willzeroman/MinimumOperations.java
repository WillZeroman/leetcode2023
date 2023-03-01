package io.github.willzeroman;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperations().minimumOperations(new int[]{1,5,0,3,5}));
    }
}
