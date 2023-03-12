package io.github.willzeroman;

public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k;
        int countW = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                countW++;
            }
        }
        int ans = countW;
        while (right < blocks.length()) {
            if(blocks.charAt(right) == 'W'){
                
            }
        }
        return ans;
    }
}
