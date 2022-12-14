package advance.backtrack_1.asg;

public class UniquePathsIII {

    public static void main(String[] args) {
        int[][] A = {
                    {1, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 2, -1},
        };
        int path = new UniquePathsIII().solve(A);
        System.out.println(path);
    }

    private int solve(int[][] grid) {
        int zero = 0, sx = 0, sy = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) zero++;
                else if (grid[r][c] == 1) {
                    sx = r;
                    sy = c;
                }
            }
        }

        return dfs(grid, sx, sy, zero);
    }

    private int dfs(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0;
        if (grid[x][y] == 2)
            return zero == -1 ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalPaths = dfs(grid, x + 1, y, zero) +
                dfs(grid, x, y + 1, zero) +
                dfs(grid, x - 1, y, zero) +
                dfs(grid, x, y - 1, zero);

        grid[x][y] = 0; // backtrack
        zero++;

        return totalPaths;
    }


}
