from Node import Node

# Implementation of a simple linked list in Python

class LinkedList:
    def __init__(self) -> None:
        self.head = None
        self.length = 0
    
    def append(self, data) -> None:
        new_node = Node(data)

        if self.is_empty():
            self.head = new_node
        else:
            last_node = self.get_last_node()
            last_node.set_next(new_node)

    # Adds an element in the beggining of the list
    def prepend(self, data) -> None:
        new_node = Node(data)
        new_node.set_next(self.head)
        self.head = new_node

    # Deletes an element by data
    def delete(self, data):
        if self.is_empty(): 
            return None
        
        # If the head contains the data to delete
        if self.head.get_data() == data:
            self.head = self.head.next
            return

        current_node = self.head

        while current_node != None:
            if current_node.next.data == data:
                current_node.set_next(current_node.next.next)
                return
            current_node = current_node.get_next()

    def get_last_node(self) -> Node:
        if self.is_empty(): 
            return None

        current_node = self.head
        while current_node.next != None:
            current_node = current_node.next
        
        return current_node
    
    def is_empty(self) -> bool:
        return self.head is None

    def print(self) -> None:
        elements = []
        
        current_node = self.head
        while current_node != None:
            elements.append(current_node.get_data())
            current_node = current_node.get_next()
        
        print(elements)

def main():
    list1 = LinkedList()
    elements = [32, 312, "as", True, False, None, 233.222, 'c']

    for element in elements:
        list1.append(element)
    
    list1.prepend("start")
    list1.delete(312)
    list1.print()

if __name__ == "__main__":
    main()