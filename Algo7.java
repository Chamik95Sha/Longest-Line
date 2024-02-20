import java.util.Arrays;

void main() {
    printLongestStraightLine(new int[]{2, 2},
            new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 3}, new int[]{4, 4}, new int[]{1, 3});
    printLongestStraightLine(new int[]{0, 0},
            new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4}, new int[]{2, 2},
            new int[]{3, 1}, new int[]{4, 0});
}

void printLongestStraightLine(int[]... coordinatePairs) {
    String l1 = "";
    for (int i = 0; i < coordinatePairs.length; i++) {

        for (int j = i + 1; j < coordinatePairs.length; j++) {
            String l2 = "";
            for (int k = j + 1; k < coordinatePairs.length; k++) {
                if (gradient(i, j, coordinatePairs).equals(gradient(i, k, coordinatePairs))) {
                    l2 = l2 + "#" + i + "#" + j + "#" + k;

                }
                if (l2.length() > l1.length()) l1 = STR."\{l2}";
            }

        }

    }
    System.out.println("============================");
    System.out.println(" Longest Line Coordinates");
    System.out.println("============================");
    for(int i=0;i<coordinatePairs.length;i++){
        if(l1.contains("#"+i)) System.out.println(Arrays.toString(coordinatePairs[i]));
    }

}

String gradient(int i, int j, int[][] coordinatePairs) {
    String a;
    if (coordinatePairs[i][1] == coordinatePairs[j][1]) a = "y" + 3;
    else if (coordinatePairs[i][0] == coordinatePairs[j][0]) a = "x" + 3;
    else a = STR."\{(coordinatePairs[i][1] - coordinatePairs[j][1]) / (coordinatePairs[i][0] - coordinatePairs[j][0])}";
    return a;
}