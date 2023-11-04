package io.github.willzeroman;

import java.util.Arrays;

public class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            ans[i] = query(nums, query);
        }
        return ans;
    }

    private int query(int[] nums, int query) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] < query ? left + 1 : left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AnswerQueries().answerQueries(new int[]{4,5,2,1},new int[]{3,10,21})));
        System.out.println(Arrays.toString(new AnswerQueries().answerQueries(new int[]{2,3,4,5},new int[]{1})));
    }
}
