package 算法.搜索;/* 2020/8/31 1:11 */

public class 深度优先搜索 {
    public static void main(String[] args) {
        深度优先搜索 m = new 深度优先搜索();
        m.tarx = 1;
        m.tary = 2;
        m.step = Integer.MAX_VALUE;//
        boolean[][] map = {
                {true, false, true},
                {true, true, true},
                {false, true, true},
        };
        m.tracking(map, 0, 0, 0);
        System.out.println(m.step);
    }

    private int tarx, tary, step;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean tracking(boolean[][] map, int x, int y, int step) {//用深搜(回溯)来找最短距离试试
        if (!map[x][y]) return false;
        if (x == tarx && y == tary) {
            System.out.println(step);//
            this.step = Math.min(this.step, step);
            return true;
        }
        map[x][y] = false;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (tracking(map, nx, ny, step + 1)) ;//return true;
            }
        }
        map[x][y] = true;
        return false;
    }
}
