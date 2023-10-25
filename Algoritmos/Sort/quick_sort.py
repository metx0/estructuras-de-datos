import random

""" 
En el quick sort todos los cambios se hacen a un solo arreglo, por lo que no hay "subarreglos" como tal
Consiste en elegir un pivote y hacer que a la izquierda de él queden los elementos menores y a su derecha
los elementos mayores
"""

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

# Versión que usa la segunda función de partición
def quick_sort_2(arr: list, left: int, right: int):
	# Si hay al menos dos elementos
	if left < right:
		# Obtener posición del pivote
		pivot_position = partition_2(arr, left, right)

		# Llamamos a la función para las dos mitades
		quick_sort_2(arr, left, pivot_position - 1)
		quick_sort_2(arr, pivot_position + 1, right)

# Este método de partición del arreglo usa solo un bucle for
def partition_2(arr: list, left: int, right: int) -> int:
	pivot = arr[right]
	# Último elemento más pequeño
	i = left - 1

	# Buscar elementos menores al pivote
	for j in range(left, right):
		if (arr[j] <= pivot):
			i += 1
			# Intercambiar los elementos en i y j
			arr[i], arr[j] = arr[j], arr[i]

	# Intercambiar el pivote
	(arr[i + 1], arr[right]) = (arr[right], arr[i + 1])

	print(arr)
	return i + 1

# Test
def main():
	arr = [346, 72, 13, 187, 29, 1250, 950]
	quick_sort_2(arr, 0, len(arr) - 1)
	# print(arr)

	# Lista de enteros aleatorios entre 1-1000
	# random_list = [random.randint(1, 1000) for _ in range(1000)]
	# quick_sort(random_list, 0, len(random_list) - 1)
	# print(random_list)

main()