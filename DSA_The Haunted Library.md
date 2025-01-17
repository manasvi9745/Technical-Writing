# The Haunted Library ⚡

## Problem Statement
A group of adventurers has entered a haunted library where books are arranged in a row. Each book has a certain magical power level. The library is cursed: if you take too many powerful books together, the curse activates!  

The adventurers must pick the longest subarray of books where the sum of their powers does not exceed a given limit.



## Example Input/Output
### Input:
- Book powers: `[2, 3, 1, 2, 4, 3]`
- Limit: `7`

### Output:
`4`  
**Explanation**: The longest subarray is `[2, 3, 1, 2]`.



#
# Different Approaches⚡



## 1. **Sliding Window 🪟** 
## Intuition 💡

- Imagine the books are lined up, and you’re trying to carry as many as possible without exceeding a weight limit.
- Start adding books one by one to your bag.
- If the bag gets too heavy (sum exceeds the limit), start removing books from the front until it’s light enough.
- Keep track of the maximum number of books you successfully carried at any time.

## Approach 🧭

**1. Initialize Variables:**

- start = 0: Marks the beginning of the window.
- sum = 0: Tracks the total magical power of books in the window.
- maxLength = 0: Keeps track of the longest valid window.

**2. Expand the Window:**

- Loop through each book using end (the current position in the row).
- Add the power of the current book (powers[end]) to the total sum.

**3. Shrink the Window (if needed):**

- If the sum exceeds the limit, remove books from the start:
- Subtract the power of the book at start from sum.
- Move start forward (shrink the window).

**4. Update the Maximum Length:**

- If the sum is within the limit, calculate the length of the current window (end - start + 1).
- Update maxLength if the current window is the longest seen so far.

**5. Return the Result:**

- After the loop, maxLength will contain the length of the longest valid window.

## Time Complexity ⏳:

- Efficient because it processes each book at most twice (once when adding to the window and once when removing from the window).
- Total time: O(n).
## Space Complexity 📦:

- Uses only constant extra space for tracking variables (start, sum, maxLength).
- Total space: O(1).

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


## **2. Prefix Sum ➕** 


## Intuition 💡

- First, build the prefix sum array.
- Then, iterate through all possible subarrays using two pointers (i and j).
- For each subarray, check if the sum (calculated using the prefix sum formula) is within the given limit.
- Keep track of the longest subarray that satisfies the condition.

## Approach 🧭

**1. Build the Prefix Sum Array:**

- Initialize prefixSum[0] = 0.
- For each book, calculate the running sum and store it in prefixSum.

**2. Iterate Through All Subarrays:**

- Use two pointers i (start of the subarray) and j (end of the subarray).
- For each subarray defined by i and j, calculate the sum as:
```
prefixSum[𝑗+1] − prefixSum[𝑖]
```
- If the sum is within the limit, update the maximum length.

**3. Return the Maximum Length:**

- After checking all subarrays, return the longest valid subarray length.

## Time Complexity ⏳:

- For each starting index i, we check all ending indices j (i ≤ j < n), which involves O(n²) operations.
- Total time: O(n²).
## Space Complexity 📦:

- The prefixSum array requires O(n) additional space.
- Total space: O(n).


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

## **3. Brute Force 🐢** 

## Intuition 💡
**1. Examine All Possible Subarrays:**

- For every starting point i in the array, examine all possible ending points j where j >= i.
- For each subarray defined by i and j, calculate the sum of the elements.

**2. Check the Sum:**

- If the sum of the subarray is less than or equal to the limit, calculate its length (j - i + 1) and update the maximum length if this subarray is the longest so far.

**3. Optimization:**

- If at any point the sum exceeds the limit, break out of the inner loop as adding more elements will only increase the sum.

## Approach 🧭

**1. Initialize Variables:**

- maxLength = 0: Tracks the longest valid subarray found.

**2. Outer Loop (Starting Point):**

- For each i from 0 to n-1, treat i as the starting point of the subarray.

**3. Inner Loop (Ending Point):**

- For each j from i to n-1, treat j as the ending point of the subarray:
- Calculate the sum of the subarray from i to j.
  - If the sum is less than or equal to the limit:
  - Calculate the length of the subarray (j - i + 1).
     - Update maxLength if the current subarray is the longest.
  - If the sum exceeds the limit, break out of the inner loop.

**4. Return the Result:**

- After processing all subarrays, return maxLength.


## Time Complexity ⏳:
- O(n²) — brute force checks all possible subarrays.
## Space Complexity 📦:
- O(1) — no additional space required apart from the input and a few variables.


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

## Performance Analysis 📊 



![Screenshot 2025-01-17 202831](https://github.com/user-attachments/assets/331ae033-f38b-4421-868e-b98ab7749516)

**Use Sliding Window 🪟:**

- It is the most efficient approach for this problem and works well for large inputs.

**Use Prefix Sum: ➕**
- This can be a useful alternative for problems where subarray sums need to be queried multiple times in different contexts.

**Avoid Brute Force: 🐢**
- While easy to implement, it should be avoided for large datasets due to its inefficiency.

