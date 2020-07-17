import java.util.LinkedList;

public class NumIsland {
    //深度优先遍历
    //         x-1,y
    //  x,y-1  x,y    x,y+1
    //         x+1,y
    //方向数组
    private static final int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    //标记数组
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;
    boolean DFS = false;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        if (DFS) {
            System.out.println("DFS");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    //若为岛屿且没有被访问过，则进行深度优先遍历
                    if (!marked[i][j] && grid[i][j] == '1') {
                        count++;
                        dfs(i, j);
                    }
                }
            }
        } else {
            System.out.println("BFS");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!marked[i][j] && grid[i][j] == '1') {
                        count++;
                        LinkedList<Integer> queue = new LinkedList<>();
                        queue.addLast(i * cols + j);
                        marked[i][j] = true;
                        while (!queue.isEmpty()) {
                            int cur = queue.removeFirst();
                            int curX = cur / cols;
                            int curY = cur % cols;
                            for (int k = 0; k < 4; k++) {
                                int newX = curX + direction[k][0];
                                int newY = curY + direction[k][1];
                                if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                    queue.addLast(newX * cols + newY);
                                    marked[newX][newY] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 深度遍历
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < rows && newY >= 0 && newY < cols;
    }

    public static void main(String[] args) {
        NumIsland numIsland = new NumIsland();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int count1 = numIsland.numIslands(grid1);
        System.out.println(count1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        int count2 = numIsland.numIslands(grid2);
        System.out.println(count2);
    }
}
