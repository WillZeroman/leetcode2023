package io.github.willzeroman;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                ans = Math.max(ans, h);
            }
        }
        return ans;
    }

    public int hIndex_counter(int[] citations) {
        int[] counter = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                counter[citations.length]++;
            } else {
                counter[citations[i]]++;
            }
        }
        System.out.println(Arrays.toString(counter));
        int ans = 0;
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += counter[i];
            if (sum >= i) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex_counter(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{1, 3, 1}));
        System.out.println(new HIndex().hIndex_counter(new int[]{1, 3, 1}));
    }
}
