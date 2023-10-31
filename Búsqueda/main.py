import random 

# To sort the list, we will use quick sort

def quick_sort(arr: list, left: int, right: int) -> None:
	if left < right:
		pivot_position = partition(arr, left, right)

		quick_sort(arr, left, pivot_position - 1)
		quick_sort(arr, pivot_position + 1, right)

def partition(arr: list, left: int, right: int) -> int:
	pivot = arr[right]
	i = left - 1

	for j in range(left, right):
		if (arr[j] <= pivot):
			i += 1
			arr[i], arr[j] = arr[j], arr[i]

	(arr[i + 1], arr[right]) = (arr[right], arr[i + 1])

	return i + 1

def binary_search(arr: list, element: int) -> int:
    low = 0
    high = len(arr) - 1

    while (low <= high):
        mid = (low + high) // 2
        mid_element = arr[mid]

        if (mid_element == element):
            # Returns the index of the element
            return mid 
        elif (mid_element < element):
            low = mid + 1
        else:
            high = mid - 1
        
    # If the number was not found, returns -1
    return -1

def generate_random_list():
    random_list = []
    last = 0

    for _ in range(100):
        random_number = random.randint(1, 100) + last
        random_list.append(random_number)
        last = random_number

    return random_list

def main():
    # Generate a list of 1000 random numbers between 1-2000
    random_list = [random.randint(1, 2000) for _ in range(1000)]
    
    # Sort the list
    quick_sort(random_list, 0, 999)
    # print(random_list)

    number_to_search = int(input("Digite el número que quiere buscar en el arreglo: "))
    result = binary_search(random_list, number_to_search)

    if result != -1:
        print(f"El número {number_to_search} fue encontrado en la posición {result}")
    else:
        print(f"El número {number_to_search} no fue encontrado en la lista")

# The line below ensures that the code only runs if it's executed directly, not as a module
if __name__ == "__main__":
    main()