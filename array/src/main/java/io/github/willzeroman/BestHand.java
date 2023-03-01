package io.github.willzeroman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BestHand {
    public String bestHand(int[] ranks, char[] suits) {
        if (isSame(suits)) {
            return "Flush";
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int ch : ranks) {
                int count = map.getOrDefault(ch, 0);
                count++;
                map.put(ch, count);
            }
            for (Integer key : map.keySet()) {
                int value = map.get(key);
                if (value >= 3) {
                    return "Three of a Kind";
                }
            }
            for (Integer key : map.keySet()) {
                int value = map.get(key);
                if (value >= 2) {
                    return "Pair";
                }
            }
            return "High Card";
        }
    }

    private boolean isSame(char[] suits) {
        Set<Character> set = new HashSet<>();
        for (char ch : suits) {
            set.add(ch);
        }
        return set.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(new BestHand().bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a'
                , 'a', 'a', 'a'}));
        System.out.println(new BestHand().bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a',
                'a', 'b', 'c'}));
    }
}
