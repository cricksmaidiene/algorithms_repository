# Binary Search

* The list should be sorted for Binary Search to work

## Pseudocode

* From This [Wiki](https://wikipedia.org/wiki/Binary_search_algorithm)

```java
function binary_search(A, n, T) is
    L := 0
    R := n − 1
    while L ≤ R do
        m := floor((L + R) / 2)
        if A[m] < T then
            L := m + 1
        else if A[m] > T then
            R := m - 1
        else:
            return m
    return unsuccessful
``` 

## Recursive Binary Search

Algorithmic Implementation in Python

```python
def recursive_binary_search(size, arr, key):
    if size == 0:
        return False

    lower_index = 0
    upper_index = size - 1
    mid_index = int(((lower_index + upper_index) / 2))
    mid_value = arr[mid_index]

    if mid_value == key: return True
    elif key < mid_value: return recursive_binary_search(len(arr[0:mid_index]), arr[0:mid_index], key)
    elif key > mid_value: return recursive_binary_search(len(arr[mid_index+1:size]), arr[mid_index+1:size], key)

```