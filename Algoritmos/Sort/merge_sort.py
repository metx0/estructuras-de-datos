""" 
Merge sort divide el arreglo por mitades en subarreglos hasta que dichos subarreglos tengan tamaño 1
Usamos la notación de rebanadas (slice) para indicar las particiones
"""

def merge_sort(arr: list) -> list:
    # Caso base
    if len(arr) == 1: 
        return arr

    middle = len(arr) // 2

    # Desde el inicio hasta el elemento anterior a la mitad
    left_arr = arr[:middle]
    # Desde la mitad hasta el final
    right_arr = arr[middle:]

    sorted_left = merge_sort(left_arr)
    sorted_right = merge_sort(right_arr)

    return merge(sorted_left, sorted_right)

def merge(left_arr, right_arr) -> list:
    arr_resultado = []

    # Comparar los elementos de ambos arreglos y eliminarlos de ellos
    while len(left_arr) > 0 and len(right_arr) > 0:
        if left_arr[0] < right_arr[0]:
            arr_resultado.append(left_arr[0])
            left_arr.pop(0)
        else:
            arr_resultado.append(right_arr[0])
            right_arr.pop(0)

    # Se añaden los elementos que quedaron
    while len(left_arr) > 0:
        arr_resultado.append(left_arr[0])
        left_arr.pop(0)

    while len(right_arr) > 0:
        arr_resultado.append(right_arr[0])
        right_arr.pop(0)

    print(arr_resultado)
    return arr_resultado

def main():
    arr = [346, 72, 13, 187, 29, 1250, 950]
    sorted_arr = merge_sort(arr)
    print(sorted_arr)

main()