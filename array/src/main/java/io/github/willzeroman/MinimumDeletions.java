package io.github.willzeroman;

public class MinimumDeletions {
    public int minimumDeletions(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }
        int countB = 0;
        int ans = countA;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countA--;
            } else {
                countB++;
            }
            ans = Math.min(ans, countB + countA);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDeletions().minimumDeletions("aababbab"));
        System.out.println(new MinimumDeletions().minimumDeletions("aaa"));
        System.out.println(new MinimumDeletions().minimumDeletions("bbaaaaabb"));
    }
}
