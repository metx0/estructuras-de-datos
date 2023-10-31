class Node:
    def __init__(self, data) -> None:
        # Nodes contain data of different types
        self.data = data
        # Pointer to the next node
        self.next = None
    
    def get_data(self):
        return self.data
    
    def set_data(self, new_data):
        self.data = new_data

    def get_next(self):
        return self.next

    def set_next(self, next):
        self.next = next

    def __str__(self):
        return f"This node contains the data: {self.data}"