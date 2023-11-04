package io.github.willzeroman;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int sum = compute(satisfaction, i + 1);
            //System.out.println(sum);
            if (sum > ans) {
                ans = sum;
            }else if (sum < ans){
                break;
            }
        }
        return ans;
    }

    private int compute(int[] satisfaction, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += satisfaction[satisfaction.length - i - 1] * (len - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSatisfaction().maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(new MaxSatisfaction().maxSatisfaction(new int[]{4,3,2}));
        System.out.println(new MaxSatisfaction().maxSatisfaction(new int[]{-4,-3,-2}));
    }
}
