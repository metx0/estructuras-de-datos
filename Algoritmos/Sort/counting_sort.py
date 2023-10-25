# Este algoritmo solo funciona para arreglos que tienen elementos en el rango de 0-9

def counting_sort(arr: list) -> list:
	# Se crea el array de conteo
	counting = [0 for _ in range(10)]

	for number in arr:
		counting[number] += 1

	# Realizar la suma acumulativa
	for i in range(len(counting) - 1):
		counting[i + 1] += counting[i]

	output = [0 for _ in range(len(arr))]

	for i in range(len(arr)):
		elem = arr[i]
		index = counting[elem] - 1
		output[index] = elem
		counting[elem] -= 1

	return output
	
arr = [1, 4, 1, 2, 7, 5]
print(counting_sort(arr))