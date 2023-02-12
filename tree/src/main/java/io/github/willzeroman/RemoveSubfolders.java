package io.github.willzeroman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典树
 */
public class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        TreeNode root = new TreeNode();
        root.name = "/";
        for (String path : folder) {
            add(root, path);
        }
        List<String> ans = new ArrayList<>();
        visit(root, ans);
        return ans;
    }

    private void visit(TreeNode node, List<String> ans) {
        if (node.end) {
            ans.add(node.fullname);
            return;
        }
        for (TreeNode child : node.childrenMap.values()) {
            visit(child, ans);
        }
    }

    private void add(TreeNode root, String path) {
        TreeNode cursor = root;
        String[] pathArray = path.split("/");
        for (int i = 1; i < pathArray.length; i++) {
            String folder = pathArray[i];
            TreeNode child = cursor.childrenMap.get(folder);
            if (child == null) {
                child = new TreeNode();
                child.name = folder;
                cursor.childrenMap.put(folder, child);
            }
            cursor = child;
        }
        cursor.end = true;
        cursor.fullname = path;
    }


    class TreeNode {
        String name;
        boolean end;

        String fullname;
        Map<String, TreeNode> childrenMap = new HashMap<>();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveSubfolders().removeSubfolders(new String[]{"/a", "/a/b", "/c" +
                "/d", "/c/d/e", "/c/f"}));
        System.out.println(new RemoveSubfolders().removeSubfolders(new String[]{"/a", "/a/b/c",
                "/a/b/d"}));
        System.out.println(new RemoveSubfolders().removeSubfolders(new String[]{"/a/b/c", "/a/b" +
                "/ca", "/a/b/d"}));
    }
}
