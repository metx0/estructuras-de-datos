def binary_search(arr: list, element: int) -> int:
    low = 0
    high = len(arr) - 1

    while (low <= high):
        mid = (low + high) // 2
        mid_element = arr[mid]

        if (mid_element == element):
            # Returns the index of the elemenet
            return mid 
        elif (mid_element < element):
            low = mid + 1
        else:
            high = mid - 1
        
    # If the number was not found, returns -1
    return -1