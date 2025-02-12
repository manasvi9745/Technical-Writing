This document lists various algorithms and their time/space complexities. (added the time and space complexities )

1. Linear Search
Description: Sequentially checks each element in a list until a match is found or the end of list is reached.
Time Complexity: 
- Best Case: O(1)
- Average Case: O(n)
- Worst Case: O(n)
Space Complexity: O(1)

2. Binary Search
Description: Repeatedly divides a sorted array in half, eliminating the half that cannot contain the target value.
Time Complexity: 
- Best Case: O(1)
- Average Case: O(log n)
- Worst Case: O(log n)
Space Complexity: O(1)

3. Bubble Sort
Description: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
Time Complexity: 
- Best Case: O(n)
- Average Case: O(n^2)
- Worst Case: O(n^2)
Space Complexity: O(1)

4. Selection Sort
Description: Divides the input list into a sorted and an unsorted region, repeatedly selects the smallest element from the unsorted region to add to the sorted region.
Time Complexity: 
- Best Case: O(n^2)
- Average Case: O(n^2)
- Worst Case: O(n^2)
Space Complexity: O(1)

5. Insertion Sort
Description: Builds the final sorted array one item at a time, by repeatedly inserting a new element into the sorted portion of the array.
Time Complexity: 
- Best Case: O(n)
- Average Case: O(n^2)
- Worst Case: O(n^2)
Space Complexity: O(1)

6. Merge Sort
Description: Divides the array into two halves, recursively sorts them, and then merges the sorted halves.
Time Complexity: 
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)
Space Complexity: O(n)

7. Quick Sort
Description: Selects a 'pivot' element and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot.
Time Complexity: 
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n^2)
Space Complexity: O(log n) (for recursive calls)

8. Breadth-First Search (BFS)
Description: Explores a graph level by level, visiting all neighbors of a node before moving to the next level.
Time Complexity: O(V + E)
Space Complexity: O(V)

9. Depth-First Search (DFS)
Description: Explores a graph by going as deep as possible along each branch before backtracking.
Time Complexity: O(V + E)
Space Complexity: O(V)

10. Dijkstra's Algorithm
Description: Finds the shortest paths between nodes in a graph with non-negative edge weights.
Time Complexity: 
- Best Case: O(V log V)
- Average Case: O((V + E) log V)
- Worst Case: O(V^2)
Space Complexity: O(V + E)

11. Floyd-Warshall Algorithm
Description: Finds shortest paths between all pairs of vertices in a weighted graph.
Time Complexity: 
- Best Case: O(V^3)
- Average Case: O(V^3)
- Worst Case: O(V^3)
Space Complexity: O(V^2)

12. Knapsack Problem (Dynamic Programming)
Description: Determines the most valuable combination of items that can be carried in a knapsack of limited weight.
Time Complexity: 
- Best Case: O(nW)
- Average Case: O(nW)
- Worst Case: O(nW)
Space Complexity: O(nW)

13. Fibonacci Sequence (Recursive)
Description: Calculates the nth Fibonacci number using recursive calls.
Time Complexity: 
- Best Case: O(2^n)
- Average Case: O(2^n)
- Worst Case: O(2^n)
Space Complexity: O(n) (due to recursion stack)

14. Fibonacci Sequence (Dynamic Programming)
Description: Calculates the nth Fibonacci number using a bottom-up approach with memoization.
Time Complexity: 
- Best Case: O(n)
- Average Case: O(n)
- Worst Case: O(n)
Space Complexity: O(n) (for memoization) or O(1) (optimized approach)

15. Matrix Multiplication (Naive)
Description: Multiplies two matrices using the standard row-column multiplication method.
Time Complexity: 
- Best Case: O(n^3)
- Average Case: O(n^3)
- Worst Case: O(n^3)
Space Complexity: O(n^2)

