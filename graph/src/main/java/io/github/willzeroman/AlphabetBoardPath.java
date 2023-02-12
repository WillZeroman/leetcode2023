package io.github.willzeroman;

public class AlphabetBoardPath {


    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (i == 0) {
                ans.append(path('a', ch));
            } else {
                ans.append(path(target.charAt(i - 1), ch));
            }
        }
        return ans.toString();
    }

    private String path(char source, char target) {
        if (source == target) {
            return "!";
        }
        if (source == 'z') {
            int[] otherSourceArray = toPoint('u');
            int[] targetArray = toPoint(target);
            return "U" + path(otherSourceArray, targetArray) + "!";
        } else if (target == 'z') {
            int[] sourceArray = toPoint(source);
            int[] otherTargetArray = toPoint('u');
            return path(sourceArray, otherTargetArray) + "D!";
        } else {
            int[] sourceArray = toPoint(source);
            int[] targetArray = toPoint(target);
            return path(sourceArray, targetArray) + "!";
        }
    }

    private String path(int[] sourceArray, int[] targetArray) {
        StringBuilder path = new StringBuilder();
        int rowDist = targetArray[0] - sourceArray[0];
        for (int i = 0; i < Math.abs(rowDist); i++) {
            if (rowDist > 0) {
                path.append("D");
            } else {
                path.append("U");
            }
        }
        int colDist = targetArray[1] - sourceArray[1];
        for (int i = 0; i < Math.abs(colDist); i++) {
            if (colDist > 0) {
                path.append("R");
            } else {
                path.append("L");
            }
        }
        return path.toString();
    }

    private int[] toPoint(char source) {
        int value = (source - 'a');
        int[] points = new int[2];
        points[0] = value / 5;
        points[1] = value % 5;
        return points;
    }

    public static void main(String[] args) {
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("leet"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("z"));
    }

}
