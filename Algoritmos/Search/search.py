""" 
Implementations of many search algorithms and related stuff
"""

# Given a list of number, determine if it's sorted or not
def is_sorted(list: list) -> bool:   
    for i in range(len(list) - 1):
        if list[i] > list[i + 1]:
            return False
        
    return True

# Search for all the ocurrences of an element in a list; if it appears many times, return the corresponding indexes
def search_all(list: list, element) -> list:
    indexes = []

    for i in range(len(list)):
        if list[i] == element:
            indexes.append(i)
    
    return indexes

# Search for an element in a list. Returns the index of the element
def linear_search(list: list, element_to_search) -> int:
    for index, element in enumerate(list):
        if element == element_to_search:
            return index
    
    return None

def binary_search(list: list, item) -> int:
    low = 0
    high = len(list) - 1

    while low <= high:
        mid = (low + high) // 2
        guess = list[mid]
        if guess == item:
            return mid
        elif guess < item:
            low = mid + 1
        else:
            high = mid - 1
    
    return -1

# Test
def main():
    list1 = [4, 10, 13, 33, 55, 55]
    print(binary_search(list1, 13))

main()

# TODO: algorithm to sort a list of strings