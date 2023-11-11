# Find the smallest element in an array
# Returns the index of the smallest element
def find_smallest(arr: list):
    smallest = arr[0]
    smallest_index = 0

    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i

    return smallest_index

# Use the function above to write selection sort
# Returns the sorted array
def selection_sort(arr) -> list:
    sorted_arr = []

    for i in range(len(arr)):
        smallest_index = find_smallest(arr)
        sorted_arr.append(arr[smallest_index])
        arr.pop(smallest_index)

    return sorted_arr

arr = [10, -2, 23, 0, -50, -101, 100, -2.2, -100]
print(selection_sort(arr))