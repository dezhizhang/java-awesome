package shop.xiaozhi.recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = createMap();

        for (int[] rows : map) {
            for (int col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }


    }

    public static int[][] createMap() {
        int[][] map = new int[8][7];

        //上下全部为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        return map;
    }


    /*
     * i,j表示从地图的哪个位置开始出发
     * 如果小球能map[6][5]位置，则说明通路找到
     * 约定当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通路可以走，3表示该点已经走过但不通
     * 在走迷宫时需要确定一个策略，下 -> 右 -> 上 ->左,如果不通再回溯
     * */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 通路已找到
            return true;
        } else {
            if (map[i][j] == 0) {
                // 当前没有走过
                map[i][j] = 2;

            }
        }

        return false;
    }


}
