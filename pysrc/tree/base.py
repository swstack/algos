class Node(object):
    def __init__(self, value):
        self.value = value
        self.lchild = None
        self.rchild = None


class Tree(object):
    def __init__(self, array):
        self.array = array
        self.root = None

    def populate(self):
        """Fill the tree starting at `self.root` from array data"""
        return NotImplementedError("Abstract Method")

    def find(self, target):
        """Return the node containing value `target`"""
        return NotImplementedError("Abstract Method")
