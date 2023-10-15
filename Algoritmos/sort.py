def bubble_sort(arr: list) -> None:
    while True:
        swap = False
        for i in range(len(arr) - 1):
            if arr[i] > arr[i + 1]:
                # swap the values
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swap = True
        
        # if there's no swap this time, the array is sorted
        if not swap:
            break

def bubble_sort_2(arr: list) -> None:
    length = len(arr)
    for i in range(length - 1):
        for j in range(i + 1, length):
            if arr[i] > arr[j]:
                # swap
                aux = arr[i]
                arr[i] = arr[j]
                arr[j] = aux

# arr = [10, 4, 6, 2, 120, 33, 0.2]
# print(arr)
# bubble_sort_2(arr)
# print(arr)