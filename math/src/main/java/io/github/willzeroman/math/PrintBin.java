package io.github.willzeroman.math;

public class PrintBin {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder("0.");
        while (ans.length() < 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            ans.append(digit);
            num -= digit;
        }
        return ans.length() < 32 ? ans.toString() : "ERROR";
    }

    public static void main(String[] args) {
        System.out.println(new PrintBin().printBin(0.625));
        System.out.println(new PrintBin().printBin(0.1));
        System.out.println(new PrintBin().printBin(0.25));
    }
}
