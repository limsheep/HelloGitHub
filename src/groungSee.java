import java.util.LinkedList;
import java.util.Queue;

public class groungSee {

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) return -1;
        int[][] next = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int level = -1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] cur = queue.poll();
                for (int[] nt : next) {
                        int nx = cur[0] - nt[0], ny = cur[1] - nt[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                            grid[nx][ny] = 1;
                            queue.offer(new int[]{nx, ny});
                        }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        groungSee GS = new groungSee();
        int num = GS.maxDistance(grid);
        System.out.println(num);

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

}
