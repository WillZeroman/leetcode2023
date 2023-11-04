package io.github.willzeroman;

import java.util.Arrays;

public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energySum = Arrays.stream(energy).sum();
        int ans = Math.max(energySum - initialEnergy + 1, 0);
        int sum = initialExperience;
        for (int i = 0; i < experience.length; i++) {
            if (sum <= experience[i]) {
                int diff = experience[i] - sum + 1;
                sum += diff;
                ans += diff;
            }
            sum += experience[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinNumberOfHours().minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println(new MinNumberOfHours().minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));
        //1
        //1
        //[1,1,1,1]
        //[1,1,1,50]
        System.out.println(new MinNumberOfHours().minNumberOfHours(1, 1, new int[]{1,1,1,1}, new int[]{1,1,1,50}));
    }
}
