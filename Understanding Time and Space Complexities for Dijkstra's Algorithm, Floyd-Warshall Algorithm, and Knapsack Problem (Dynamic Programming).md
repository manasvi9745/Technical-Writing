This document lists various algorithms and their time/space complexities. 

Dijkstra's Algorithm
Description: Finds the shortest paths in a weighted graph from a single source to all other vertices.

Time Complexity:
Best Case: O(V log V) (With Fibonacci Heap)
Average Case: O((V + E) log V) (Using a priority queue with Binary Heap)
Worst Case: O(V^2) (Using an adjacency matrix with simple linear search)

Space Complexity:
Adjacency List Implementation: O(V + E)
Adjacency Matrix Implementation: O(V^2)

Floyd-Warshall Algorithm

Description: Finds shortest paths between all pairs of vertices in a weighted graph.

Time Complexity:
Best Case: O(V^3)
Average Case: O(V^3)
Worst Case: O(V^3)

Space Complexity:
Matrix Storage: O(V^2)

Knapsack Problem (Dynamic Programming)

Description: Solves the problem of selecting the best items for a knapsack with limited weight.

Time Complexity:
Best Case: O(nW) (Using DP, where n is the number of items and W is the weight limit)
Average Case: O(nW)
Worst Case: O(nW)

Space Complexity:
2D DP Array: O(nW)
Optimized (1D DP Array): O(W)