import java.util.*;

public class KingdomFencing {
    
    public static int maxAreaBinarySearch(int[][] grid, int fences) {
        int m = grid.length, n = grid[0].length;
        List<int[]> ones = new ArrayList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) ones.add(new int[]{r, c});
            }
        }
        
        int lo = 1, hi = m * n, best = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canFormRectangle(grid, ones, mid, fences)) {
                best = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return best;
    }

    private static boolean canFormRectangle(int[][] grid, List<int[]> ones, int area, int fences) {
        for (int[] p1 : ones) {
            for (int[] p2 : ones) {
                int r1 = p1[0], c1 = p1[1], r2 = p2[0], c2 = p2[1];
                if (r2 >= r1 && c2 >= c1) {
                    int width = c2 - c1 + 1, height = r2 - r1 + 1;
                    int perimeter = 2 * (width + height);
                    if (perimeter <= fences && width * height >= area) return true;
                }
            }
        }
        return false;
    }

    public static int maxAreaGreedy(int[][] grid, int fences) {
        int m = grid.length, n = grid[0].length, maxArea = 0;
        
        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                if (grid[r1][c1] == 0) continue;
                for (int r2 = r1; r2 < m; r2++) {
                    for (int c2 = c1; c2 < n; c2++) {
                        if (isValidRectangle(grid, r1, c1, r2, c2)) {
                            int width = c2 - c1 + 1, height = r2 - r1 + 1;
                            int perimeter = 2 * (width + height);
                            if (perimeter <= fences) maxArea = Math.max(maxArea, width * height);
                        }
                    }
                }
            }
        }
        return maxArea;
    }

    private static boolean isValidRectangle(int[][] grid, int r1, int c1, int r2, int c2) {
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (grid[r][c] == 0) return false;
            }
        }
        return true;
    }

    public static int maxAreaMonotonicStack(int[][] grid, int fences) {
        int m = grid.length, n = grid[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                heights[j] = (row[j] == 1) ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestHistogramArea(heights, fences));
        }
        return maxArea;
    }

    private static int largestHistogramArea(int[] heights, int fences) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, n = heights.length;
        int[] extendedHeights = Arrays.copyOf(heights, n + 1);
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && extendedHeights[stack.peek()] > extendedHeights[i]) {
                int height = extendedHeights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int perimeter = 2 * (width + height);
                if (perimeter <= fences) maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int fences = 8;

        System.out.println("Binary Search Approach: " + maxAreaBinarySearch(grid, fences));
        System.out.println("Greedy Approach: " + maxAreaGreedy(grid, fences));
        System.out.println("Monotonic Stack Approach: " + maxAreaMonotonicStack(grid, fences));
    }
}

/*
 * Understanding the Problem
->We have a grid of land (m x n matrix with 0s and 1s).
->We have a limited number of fences to form rectangular plots.
->We must find the maximum area of a rectangle that can be enclosed.
->Rectangles can only be formed on 1s.
->Each rectangle needs at least 4 fences
 */

 /* SOLVE-
  * 1. Binary Search Approach
->Binary Search can be used to find the maximum possible rectangle area by searching over possible rectangle sizes.
->Define the search space( The smallest rectangle is 1x1=1, and the largest is the entire grid area.)
->Use binary search on the area values.
->For each mid-value in binary search, check if at least one rectangle of that area can be formed within the given fence limit.
->Adjust search space accordingly


 */


/*
 * 2. Greedy Algorithm Approach
->A greedy approach can start by picking the largest possible rectangle and trying to fit it within the available fences.
->Iterate over all possible rectangles in the grid.
->Calculate the perimeter needed for each rectangle.
->Choose the largest area that fits within the fence limit.

 */

/*
 * 
 3. Monotonic Stack Approach (Histogram Method)
->This is inspired by the largest rectangle in a histogram problem.
->Convert each row of the grid into a histogram representation (heights of consecutive 1s).
->Use a monotonic stack to find the largest possible rectangle at each row.
->Keep track of the maximum rectangle found within the fence limit.
 */

 /*
  * Easiest Approach:

Greedy is easiest to implement since it directly iterates over rectangles.
------------------------------------------------------------------------------------
Edge Cases to Consider:
All 0s in grid (no rectangles possible).
Single row or column grids.
Insufficient fences (not enough for a full rectangle).
Multiple small optimal rectangles instead of one large one.
  */
