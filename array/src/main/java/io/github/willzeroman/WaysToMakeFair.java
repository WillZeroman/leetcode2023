package io.github.willzeroman;

/**
 * https://leetcode.cn/problems/ways-to-make-a-fair-array/
 */
public class WaysToMakeFair {
    /**
     * O(n)、O(1)
     *
     * @param nums
     * @return
     */
    public int waysToMakeFair(int[] nums) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        int ans = 0;
        int preOddSum = 0;
        int preEvenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum -= nums[i];
            } else {
                oddSum -= nums[i];
            }
            int currentOddSum = preOddSum + evenSum;
            int currentEvenSum = preEvenSum + oddSum;
            if (currentEvenSum == currentOddSum) {
                ans++;
            }
            if (i % 2 == 0) {
                preEvenSum += nums[i];
            } else {
                preOddSum += nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToMakeFair().waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(new WaysToMakeFair().waysToMakeFair(new int[]{1,1,1}));
        System.out.println(new WaysToMakeFair().waysToMakeFair(new int[]{1,2,3}));
    }
}
