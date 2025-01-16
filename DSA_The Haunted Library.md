# The Haunted Library

## Problem Statement
A group of adventurers has entered a haunted library where books are arranged in a row. Each book has a certain magical power level. The library is cursed: if you take too many powerful books together, the curse activates!  

The adventurers must pick the longest subarray of books where the sum of their powers does not exceed a given limit.

---

---

## Example Input/Output
### Input:
- Book powers: `[2, 3, 1, 2, 4, 3]`
- Limit: `7`

### Output:
`4`  
**Explanation**: The longest subarray is `[2, 3, 1, 2]`.

---


## Approaches

---

### 1. Sliding Window Approach
- This approach is optimal for finding the longest subarray under a given condition.
- It uses a dynamic window that grows when the sum is under the limit and shrinks when the sum exceeds the limit.
- Each element is processed at most twice — once when expanding the window and once when shrinking it.

#### Code: **C++**

``` 
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int slidingWindowLongestSubarray(const vector<int>& powers, int limit) {
    int n = powers.size();
    int start = 0, sum = 0, maxLength = 0;

    for (int end = 0; end < n; ++end) {
        sum += powers[end]; // Include the current book in the sum

        while (sum > limit) {
            sum -= powers[start++]; // Shrink the window
        }
        maxLength = max(maxLength, end - start + 1); // Update the maximum length
    }
    return maxLength;
}

int main() {
    vector<int> bookPowers = {2, 3, 1, 2, 4, 3};
    int limit = 7;

    cout << "Sliding Window Result: " << slidingWindowLongestSubarray(bookPowers, limit) << endl;
    return 0;
}
```

---

---

### 2. Prefix Sum Approach
- The prefix sum array is built such that each index stores the cumulative sum of all elements up to that point.
- Using the prefix sum, the sum of any subarray `[i, j]` is computed in constant time:
- This eliminates the need to recompute sums repeatedly.

#### Code: **C++**
```
#include <iostream>
#include <vector>
using namespace std;

int prefixSumLongestSubarray(const vector<int>& powers, int limit) {
    int n = powers.size();
    vector<int> prefixSum(n + 1, 0);

    for (int i = 0; i < n; ++i) {
        prefixSum[i + 1] = prefixSum[i] + powers[i]; // Build prefix sum
    }

    int maxLength = 0;

    for (int i = 0; i < n; ++i) {
        for (int j = i; j < n; ++j) {
            if (prefixSum[j + 1] - prefixSum[i] <= limit) {
                maxLength = max(maxLength, j - i + 1);
            }
        }
    }
    return maxLength;
}

int main() {
    vector<int> bookPowers = {2, 3, 1, 2, 4, 3};
    int limit = 7;

    cout << "Prefix Sum Result: " << prefixSumLongestSubarray(bookPowers, limit) << endl;
    return 0;
}
```
---
---

### 3. Brute Force Approach
- In this approach, all possible subarrays are generated, and their sums are computed individually.
- For each subarray, check if the sum is within the limit. Track the maximum length of valid subarrays.

#### Code: **C++**
```
#include <iostream>
#include <vector>
using namespace std;

int bruteForceLongestSubarray(const vector<int>& powers, int limit) {
    int n = powers.size();
    int maxLength = 0;

    for (int i = 0; i < n; ++i) {
        int sum = 0;
        for (int j = i; j < n; ++j) {
            sum += powers[j]; // Calculate sum for subarray
            if (sum <= limit) {
                maxLength = max(maxLength, j - i + 1);
            } else {
                break; // Stop if sum exceeds limit
            }
        }
    }
    return maxLength;
}

int main() {
    vector<int> bookPowers = {2, 3, 1, 2, 4, 3};
    int limit = 7;

    cout << "Brute Force Result: " << bruteForceLongestSubarray(bookPowers, limit) << endl;
    return 0;
}
```



---

## Performance Analysis

---



### Sliding Window Approach:

- **Time Complexity**: \(O(n)\), where \(n\) is the number of books. Each element is processed at most twice (once added and once removed).
- **Space Complexity**: \(O(1)\), as it uses constant space.
- **Best For**: Large input sizes due to linear time complexity.

---

### Prefix Sum Approach:

- **Time Complexity**: \(O(n^2)\), as it involves two nested loops to calculate subarray sums.
- **Space Complexity**: \(O(n)\), for the prefix sum array.
- **Best For**: Medium-sized inputs where simplicity is acceptable.

---

### Brute Force Approach:

- **Time Complexity**: \(O(n^2)\), as it involves two nested loops with explicit sum calculations.
- **Space Complexity**: \(O(1)\), as no extra space is used.
- **Best For**: Small input sizes due to inefficiency for larger datasets.


---

## Key Insights

- The curse constraint makes it necessary to carefully manage the sum within the limit, influencing algorithm efficiency.
- The sliding window approach is the most efficient and scales well with large input sizes, while the prefix sum and brute force approaches are less efficient but easier to implement and understand for smaller datasets.
