package io.github.willzeroman;

public class CommonFactors {
    public int commonFactors(int a, int b) {
        int n = Math.min(a, b);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(a%i==0 && b%i==0){
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CommonFactors().commonFactors(6,12));
        System.out.println(new CommonFactors().commonFactors(25,30));
    }
}
