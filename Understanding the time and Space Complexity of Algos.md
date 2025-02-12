Common Algorithms and Their Complexities

This document lists various algorithms and their time/space complexities. Some complexities are missing - can you help fill them in?

1. Linear Search
Description: Sequentially checks each element in a list until a match is found or the end of list is reached.
Time Complexity: 
Space Complexity:

2. Binary Search
Description: Repeatedly divides a sorted array in half, eliminating the half that cannot contain the target value.
Time Complexity: 
Space Complexity:

3. Bubble Sort
Description: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
Time Complexity: 
Space Complexity:


4. Selection Sort
Description: Divides the input list into a sorted and an unsorted region, repeatedly selects the smallest element from the unsorted region to add to the sorted region.
Time Complexity: 
Space Complexity:


5. Insertion Sort
Description: Builds the final sorted array one item at a time, by repeatedly inserting a new element into the sorted portion of the array.
Time Complexity: 
Space Complexity:


6. Merge Sort
Description: Divides the array into two halves, recursively sorts them, and then merges the sorted halves.
Time Complexity: 
Space Complexity:


7. Quick Sort
Description: Selects a 'pivot' element and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot.
Time Complexity: 
Space Complexity:


8. Breadth-First Search (BFS)
Description: Explores a graph level by level, visiting all neighbors of a node before moving to the next level.
Time Complexity: 
Space Complexity:


9. Depth-First Search (DFS)
Description: Explores a graph by going as deep as possible along each branch before backtracking.
Time Complexity: 
Space Complexity:


10. Dijkstra's Algorithm
Description: Finds the shortest paths between nodes in a graph with non-negative edge weights.
Time Complexity: 
Space Complexity:


11. Floyd-Warshall Algorithm
Description: Finds shortest paths between all pairs of vertices in a weighted graph.
Time Complexity: 
Space Complexity:


12. Knapsack Problem (Dynamic Programming)
Description: Determines the most valuable combination of items that can be carried in a knapsack of limited weight.
Time Complexity: 
Space Complexity:


13. Fibonacci Sequence (Recursive)
Description: Calculates the nth Fibonacci number using recursive calls.
Time Complexity: 
Space Complexity:


14. Fibonacci Sequence (Dynamic Programming)
Description: Calculates the nth Fibonacci number using a bottom-up approach with memoization.
Time Complexity: 
Space Complexity:


15. Matrix Multiplication (Naive)
Description: Multiplies two matrices using the standard row-column multiplication method.
Time Complexity: 
Space Complexity:


Note: For each algorithm, consider:
- Best case scenario
- Average case scenario
- Worst case scenario
- Any space complexity variations based on implementation

Can you help fill in the missing complexities? Create a PR with your solutions!

---
### **Recursive vs. Iterative Algorithms: Space Complexity Comparison**  

Algorithms can be implemented using **recursion** or **iteration**, but they differ in **space complexity** due to how they manage memory.  

---

## **1. Understanding Space Complexity in Recursion**  
### How Recursion Uses Memory:  
- Recursive algorithms use the **call stack** to store function calls until they return.  
- Each recursive call **adds a new stack frame**, increasing space usage.  
- The recursion **depth determines space complexity**.  

### **Example: Quick Sort (Recursive)**
- **Space Complexity:** `O(log n)` (average case), `O(n)` (worst case when unbalanced).  
- **Reason:** The recursive function calls store partitions on the stack.  

#### **Pseudocode for Recursive Quick Sort**
```python
function quickSort(arr, low, high):
    if low < high:
        pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)  # Recursive call for left subarray
        quickSort(arr, pivotIndex + 1, high) # Recursive call for right subarray
```
- **Recursive Depth:** `O(log n)` in the best case but `O(n)` in the worst case (skewed partitioning).  
- **Memory Usage:** Each function call adds a new stack frame.  

---

## **2. Understanding Space Complexity in Iterative Algorithms**  
### How Iteration Saves Space:  
- Iterative algorithms **do not use the call stack** for recursive function calls.  
- Instead, they use **loop constructs**, requiring **constant space (`O(1)`)** if no extra data structures are needed.  

### **Example: Merge Sort (Iterative)**
- **Space Complexity:** `O(n)` (due to auxiliary array for merging).  
- **Reason:** Avoids recursion stack, but still requires temporary storage for merging.  

#### **Pseudocode for Iterative Merge Sort**
```python
function mergeSortIterative(arr):
    n = length(arr)
    currentSize = 1
    while currentSize < n:
        left = 0
        while left < n-1:
            mid = min(left + currentSize - 1, n-1)
            right = min(left + 2*currentSize - 1, n-1)
            merge(arr, left, mid, right)
            left += 2 * currentSize
        currentSize *= 2
```
- **No recursion stack used** → avoids `O(log n)` recursive call overhead.  
- **Still requires `O(n)` auxiliary space** for merging.  

---

## **3. Comparing Recursive vs. Iterative Implementations**  

| Algorithm | Recursive Space Complexity | Iterative Space Complexity |  
|-----------|---------------------------|---------------------------|  
| Quick Sort | `O(log n)` (best/avg), `O(n)` (worst) | `O(1)` (if stack avoided) |  
| Merge Sort | `O(n)` (auxiliary array + recursion depth) | `O(n)` (auxiliary array) |  
| Fibonacci | `O(n)` (due to recursion depth) | `O(1)` (loop-based) |  
| DFS | `O(h)`, where `h` is tree/graph depth | `O(n)` (if stack used explicitly) |  
| BFS | `O(n)` (queue storage) | `O(n)` (queue storage) |  

---
## **How Recursion Impacts Space Usage with Stack Frames**  

### **What Happens in Memory During Recursion?**  
When a function calls itself recursively, the system **allocates memory** on the **call stack** for each function call. These stack frames store:  
- **Function parameters**  
- **Local variables**  
- **Return address (where to continue execution after returning)**  

Each recursive call **adds a new stack frame**, and these frames remain in memory until the function returns. If recursion is too deep, it can cause **stack overflow**.

---

### **Example: Recursive Fibonacci Calculation**
Let's take a simple recursive Fibonacci function:
```python
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)
```
- **Function Calls for `fibonacci(4)`:**  
```
fibonacci(4)  
├── fibonacci(3)  
│   ├── fibonacci(2)  
│   │   ├── fibonacci(1) → returns 1  
│   │   ├── fibonacci(0) → returns 0  
│   ├── fibonacci(1) → returns 1  
├── fibonacci(2)  
│   ├── fibonacci(1) → returns 1  
│   ├── fibonacci(0) → returns 0  
```
- **Stack Frame Growth (Call Stack):**
```
fibonacci(4)
  fibonacci(3)
    fibonacci(2)
      fibonacci(1)  (returns)
      fibonacci(0)  (returns)
    fibonacci(1)  (returns)
  fibonacci(2)
    fibonacci(1)  (returns)
    fibonacci(0)  (returns)
```
- **Space Complexity:** `O(n)` (for call stack depth).  
- **Problem:** Many redundant calls (`fibonacci(2)` appears twice).  

---

### **Recursion vs. Iteration: Call Stack Usage**  
| Approach | Space Complexity | Why? |
|----------|----------------|------|
| **Recursive Fibonacci** | `O(n)` | Each call adds a stack frame until `n` reaches 0. |
| **Iterative Fibonacci** | `O(1)` | Uses only a few variables, no extra function calls. |

---


