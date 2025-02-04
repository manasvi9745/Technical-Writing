class DSA_Treasurehunt {
    // Brute Force Approach (Recursive)
    public static int maxCoinsBruteForce(int[][] grid, int i, int j) {
        int rows = grid.length, cols = grid[0].length;
        if (i >= rows || j >= cols || grid[i][j] == -1) return Integer.MIN_VALUE;
        if (i == rows - 1 && j == cols - 1) return grid[i][j];
        return grid[i][j] + Math.max(maxCoinsBruteForce(grid, i + 1, j), maxCoinsBruteForce(grid, i, j + 1));
    }

    // Backtracking Approach
    public static int maxCoinsBacktracking(int[][] grid, int i, int j, Integer[][] memo) {
        int rows = grid.length, cols = grid[0].length;
        if (i >= rows || j >= cols || grid[i][j] == -1) return Integer.MIN_VALUE;
        if (i == rows - 1 && j == cols - 1) return grid[i][j];
        if (memo[i][j] != null) return memo[i][j];
        
        int maxCoins = grid[i][j] + Math.max(maxCoinsBacktracking(grid, i + 1, j, memo), maxCoinsBacktracking(grid, i, j + 1, memo));
        memo[i][j] = maxCoins;
        return maxCoins;
    }

    // Dynamic Programming Approach (Bottom-Up)
    public static int maxCoinsDP(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                int left = (j > 0) ? dp[i][j - 1] : Integer.MIN_VALUE;
                int up = (i > 0) ? dp[i - 1][j] : Integer.MIN_VALUE;
                
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else dp[i][j] = grid[i][j] + Math.max(left, up);
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { {1, 3, -1}, {2, 0, 4}, {-1, 5, 2} };

        // Brute Force
        int resultBrute = maxCoinsBruteForce(grid, 0, 0);
        System.out.println("Brute Force Output: " + (resultBrute < 0 ? "Not Possible" : resultBrute));

        // Backtracking with Memoization
        Integer[][] memo = new Integer[grid.length][grid[0].length];
        int resultBacktracking = maxCoinsBacktracking(grid, 0, 0, memo);
        System.out.println("Backtracking Output: " + (resultBacktracking < 0 ? "Not Possible" : resultBacktracking));

        // Dynamic Programming
        int resultDP = maxCoinsDP(grid);
        System.out.println("Dynamic Programming Output: " + (resultDP < 0 ? "Not Possible" : resultDP));
    }
}

/*
1.Brute Force (Recursive)
Tries all possible paths.
Time Complexity: O(2^(m+n)) (Exponential)
Not efficient for large grids.

2.Backtracking (with Memoization)
Caches results to avoid redundant calculations.
Time Complexity: O(m*n)
Space Complexity: O(m*n) due to memoization.

3.Dynamic Programming (Bottom-Up)
Builds solutions iteratively using a DP table.
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Most efficient approach.*/
