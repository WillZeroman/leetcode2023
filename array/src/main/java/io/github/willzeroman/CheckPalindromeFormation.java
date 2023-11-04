package io.github.willzeroman;

public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        for (int i = 0; i <= a.length(); i++) {
            String aPrefix = a.substring(0,i);
            String asuffix = a.substring(i,a.length());
            String bPrefix = b.substring(0,i);
            String bsuffix = b.substring(i,b.length());
            if(isPalindrome(aPrefix+bsuffix) || isPalindrome(bPrefix+asuffix)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPalindromeFormation_best(String a, String b) {
        return checkConcatenation(a, b) || checkConcatenation(b, a);
    }

    public boolean checkConcatenation(String a, String b) {
        int n = a.length();
        int left = 0, right = n - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return checkSelfPalindrome(a, left, right) || checkSelfPalindrome(b, left, right);
    }

    public boolean checkSelfPalindrome(String a, int left, int right) {
        while (left < right && a.charAt(left) == a.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new CheckPalindromeFormation().checkPalindromeFormation("x","y"));
        System.out.println(new CheckPalindromeFormation().checkPalindromeFormation("abdef","fecab"));
        System.out.println(new CheckPalindromeFormation().checkPalindromeFormation("abc","abc"));
    }
}
