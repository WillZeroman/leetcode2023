package io.github.willzeroman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertNames {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            List<Integer> list = map.getOrDefault(name, new ArrayList<>());
            String[] data = keyTime[i].split(":");
            int time = Integer.parseInt(data[0]) * 60 + Integer.parseInt(data[1]);
            list.add(time);
            map.put(name, list);
        }
        List<String> ans = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            if (times.size() >= 3) {
                Collections.sort(times);
                for (int i = 2; i < times.size(); i++) {
                    if (times.get(i) - times.get(i - 2) <= 60) {
                        ans.add(name);
                        break;
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new AlertNames().alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"},
                new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));
    }
}
