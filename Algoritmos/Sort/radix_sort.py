def radix_sort(arr: list):
	# Obtener el mayor elemento
	max_ = str(max(arr))

	exp = 1
	for _ in range(len(max_)):
		counting_sort(arr, exp)
		exp *= 10

	# Obtener el mayor elemento
	""" max_ = max(arr)
	exp = 1
	while exp <= max_:
		counting_sort(arr, exp)
		exp *= 10 """

def counting_sort(arr: list, exp: int):
	# Se crea el array de conteo
	counting = [0 for _ in range(10)]

	for number in arr:
		# Reducimos el número según qué dígito queremos encontrar
		index = number // exp
		counting[index % 10] += 1

	# Se realiza la suma acumulativa
	for i in range(9): 
		counting[i + 1] += counting[i]

	output = [0 for _ in range(len(arr))]

	""" for i in range(len(arr)):
		# Recuperamos el dígito en cuestión para usarlo como índice
		digit = (arr[i] // exp) % 10
		# El índice que usaremos
		index = counting[digit] - 1
		output[index] = arr[i]
		counting[digit] -= 1 """
	
	i = len(arr) - 1
	while i >= 0:
		# Recuperamos el dígito en cuestión para usarlo como índice
		digit = (arr[i] // exp) % 10
		# El índice que usaremos
		index = counting[digit] - 1
		output[index] = arr[i]
		counting[digit] -= 1
		i -= 1

	# Copiar los elementos de "output" a nuestro arreglo, el que queremos ordenar
	for i in range(len(arr)):
		arr[i] = output[i]

	print(arr)

def main():
	arr = [346, 72, 13, 187, 29, 1250, 950]
	radix_sort(arr)
	# print(arr)

main()