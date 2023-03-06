package io.github.willzeroman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetFolderNames {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetFolderNames().getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"})));
    }

}
