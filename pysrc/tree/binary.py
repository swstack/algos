from base import Node, Tree


class BinaryTree(Tree):
    def _recursive_populate(self, root, value):
            if value > root.value:
                if root.rchild is None:
                    root.rchild = Node(value)
                else:
                    self._recursive_populate(root.rchild, value)
            else:
                if root.lchild is None:
                    root.lchild = Node(value)
                else:
                    self._recursive_populate(root.lchild, value)

    def populate(self):
        self.root = Node(self.array[0])
        for item in self.array[1:]:
            self._recursive_populate(self.root, item)

    def find(self, target):
        node = self.root
        while True:
            if node is None:
                return None
            if node.value == target:
                return node
            if target > node.value:
                node = node.rchild
            else:
                node = node


if __name__ == "__main__":
    data = [30, 24, 1, 32, 4, 17, 19, 8, 26, 40, 5]
    tree = BinaryTree(data)
    tree.populate()
    node = tree.find(32)
    if node:
        print "found: %s" % node.value
    else:
        print "not found"
