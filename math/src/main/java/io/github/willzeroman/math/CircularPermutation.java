package io.github.willzeroman.math;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CircularPermutation().circularPermutation(2,3));
    }
}
