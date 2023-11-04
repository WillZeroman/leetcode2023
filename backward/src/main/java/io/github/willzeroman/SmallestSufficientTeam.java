package io.github.willzeroman;

import java.util.*;

public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int size = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(size, map, list, ans, 0, people);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }



    private void dfs(int size, Map<String, Integer> map, LinkedList<Integer> list, List<Integer> ans, int current, List<List<String>> people) {
        list.add(current);
        for (String skill : people.get(current)) {
            int count = map.getOrDefault(skill, 0);
            count++;
            map.put(skill, count);
        }
        if (map.size() == size) {
            // find success;
            if (ans.isEmpty() || list.size() < ans.size()) {
                ans.clear();
                ans.addAll(list);
            }
            System.out.println(list);
            for (String skill : people.get(current)) {
                int count = map.getOrDefault(skill, 0);
                count--;
                if (count <= 0) {
                    map.remove(skill);
                } else {
                    map.put(skill, count);
                }
            }
            list.removeLast();
            return;
        }
        for (int i = current + 1; i < people.size(); i++) {
            dfs(size, map, list, ans, i, people);
        }
        for (String skill : people.get(current)) {
            int count = map.getOrDefault(skill, 0);
            count--;
            if (count <= 0) {
                map.remove(skill);
            } else {
                map.put(skill, count);
            }
        }
        list.removeLast();
    }

    public int[] smallestSufficientTeam_best(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skill_index.put(req_skills[i], i);
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int cur_skill = 0;
            for (String s : people.get(i)) {
                cur_skill |= 1 << skill_index.get(s);
            }
            for (int prev = 0; prev < dp.length; ++prev) {
                if (dp[prev] == null) {
                    continue;
                }
                int comb = prev | cur_skill;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] skills = new String[]{"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        //[["java"],["nodejs"],["nodejs","reactjs"]]
        List<String> list = new ArrayList<>();
        list.add("java");
        people.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("nodejs");
        people.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("nodejs");
        list2.add("reactjs");
        people.add(list2);
        System.out.println(Arrays.toString(new SmallestSufficientTeam().smallestSufficientTeam(skills,people)));
    }
}
