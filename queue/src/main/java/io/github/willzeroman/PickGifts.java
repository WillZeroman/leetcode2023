package io.github.willzeroman;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : gifts) {
            queue.offer(num);
        }
        System.out.println(queue);
        for (int i = 0; i < k; i++) {
            int item = queue.poll();
            if (item == 1) {
                queue.offer(item);
                break;
            }
            int remain = (int) Math.sqrt(item);
            queue.offer(remain);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(10));
        System.out.println((int)Math.sqrt(10));
        System.out.println((int)Math.sqrt(15));
        System.out.println(new PickGifts().pickGifts(new int[]{25,64,9,4,100},4));
        System.out.println(new PickGifts().pickGifts(new int[]{1,1,1,1},4));
    }
}
