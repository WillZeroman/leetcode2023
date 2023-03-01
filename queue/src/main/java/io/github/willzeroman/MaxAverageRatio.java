package io.github.willzeroman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Entity> queue =
                new PriorityQueue<>(new Comparator<Entity>() {
                    @Override
                    public int compare(Entity o1, Entity o2) {
                        if (o2.increaseRate > o1.increaseRate) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
        List<Entity> all = new ArrayList<>();
        for (int i = 0; i < classes.length; i++) {
            int[] claz = classes[i];
            Entity entity = new Entity();
            entity.pass = claz[0];
            entity.total = claz[1];
            entity.rate = entity.pass / (double) entity.total;
            entity.increaseRate = (entity.pass + 1) / (double) (entity.total + 1) - entity.rate;
            if (entity.pass != entity.total) {
                queue.add(entity);
            } else {
                all.add(entity);
            }
        }
        for (int i = 0; i < extraStudents && !queue.isEmpty(); i++) {
            Entity entity = queue.poll();
            entity.pass++;
            entity.total++;
            entity.rate = entity.pass / (double) entity.total;
            entity.increaseRate = (entity.pass + 1) / (double) (entity.total + 1) - entity.rate;
            if (entity.pass != entity.total) {
                queue.add(entity);
            } else {
                all.add(entity);
            }
        }
        all.addAll(queue);
        double sum = 0;
        int size = all.size();
        for (Entity entity : all) {
            sum += entity.rate;
        }
        return sum / size;
    }

    class Entity {
        int pass;
        int total;
        double rate;
        double increaseRate;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAverageRatio().maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2,
                2}}, 2));
    }
}
