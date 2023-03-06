package io.github.willzeroman;

public class CountTriplets {
    public int countTriplets(int[] nums) {
        int len = 1 << 16;
        int[] cnt = new int[len];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                cnt[nums[i] & nums[j]]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < len; j++) {
                if((nums[i] & j) == 0){
                    ans += cnt[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountTriplets().countTriplets(new int[]{2,1,3}));
    }
}
