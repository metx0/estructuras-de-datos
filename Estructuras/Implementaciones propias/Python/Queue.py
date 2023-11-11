from Node import Node

"""
We can access both ends
front: the first element
rear: the last element
"""

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None
        self.size = 0

    # Insert elements to the rear
    def enqueue(self, data) -> None:
        new_node = Node(data)

        if self.front is None:
            self.front = self.rear = new_node
        else:
            self.rear.next = new_node
            self.rear = new_node

        self.size += 1

    # Delete the element in the front
    def dequeue(self) -> None:
        if self.front is None:
            return None

        self.front = self.front.next
        # If there was only one element, delete the rear too
        if self.front is None:
            self.rear = None
        self.size -= 1

    # Check the value in the front
    def peek(self):
        if self.front is None:
            return None

        return self.front.data
    
    def print(self):
        elements = []
        current_node = self.front
        while current_node != None:
            elements.append(current_node.data)
            current_node = current_node.next
        
        print(elements)

def main():
    q1 = Queue()
    q1.enqueue(10)
    q1.enqueue(20)
    q1.enqueue(30)
    q1.dequeue()
    q1.print()
    q1.enqueue(40)
    q1.enqueue(101)
    q1.print()

if __name__ == "__main__":
    main()