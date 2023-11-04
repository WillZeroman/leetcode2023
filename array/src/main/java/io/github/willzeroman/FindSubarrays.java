package io.github.willzeroman;

import java.util.HashSet;
import java.util.Set;

public class FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            int sum = nums[i] + nums[i+1];
            if(!set.add(sum)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FindSubarrays().findSubarrays(new int[]{4,2,4}));
        System.out.println(new FindSubarrays().findSubarrays(new int[]{1,2,3,4,5}));
    }
}
