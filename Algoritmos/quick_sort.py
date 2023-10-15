""" 
left, right: las partes del arreglo que queremos ordenar. Al inicio es todo el arreglo, 
es decir (0, len(arr) - 1)
"""
def quick_sort(arr, left, right) -> None:
    # left ser menor a right; esto significa que hay al menos dos elementos
    if left < right:
        partition_pos = partition(arr, left, right)
        # subarray de los elementos menores al pivote
        quick_sort(arr, left, partition_pos - 1)
        # subarray de los elementos mayores al pivote
        quick_sort(arr, partition_pos + 1, right)

""" 
Se encarga de particionar el arreglo para que a la izquierda del pivote queden los elementos menores 
a él y a la derecha los elementos mayores a él
Retorna el índice del pivote
"""
def partition(arr, left, right) -> int:
    i = left
    j = right - 1
    pivot = arr[right]

    # i se mueve a la derecha y j a la izquierda hasta que se cruzan
    while i < j:
        while i < right and arr[i] < pivot:
            i += 1  
        while j > left and arr[j] >= pivot:
            j -= 1

        if i < j:
            # Intercambiamos los elementos correspondientes de i y j
            arr[i], arr[j] = arr[j], arr[i]
    
    if arr[i] > pivot:
        arr[i], arr[right] = arr[right], arr[i]
    
    return i

def main():
    arr = [346, 72, 13, 187, 29, 1250, 950]
    quick_sort(arr, 0, len(arr) - 1)
    print(arr)